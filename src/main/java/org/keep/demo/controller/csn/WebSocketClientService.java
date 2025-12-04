package org.keep.demo.controller.csn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

@Slf4j
@Component
public class WebSocketClientService {

    private static final int SAMPLE_RATE = 16000;
    private static final int WAV_HEADER_SIZE = 44;
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(180);
    private static final Duration ONLINE_CHUNK_DELAY = Duration.ofMillis(60);
    private static final int MAX_RETRY_ATTEMPTS = 2;

    // 配置Record
    public record AsrConfig(
            String wsUrl,
            String wavPath,
            String mode,
            String chunkSize,
            int chunkInterval,
            String hotwords,
            Duration timeout,
            int maxRetries
    ) {
        public AsrConfig(String wsUrl, String wavPath, String mode,
                         String chunkSize, int chunkInterval, String hotwords) {
            this(wsUrl, wavPath, mode, chunkSize, chunkInterval,
                    hotwords, DEFAULT_TIMEOUT, MAX_RETRY_ATTEMPTS);
        }
    }

    // 结果Record
    public record AsrResult(
            boolean success,
            String transcript,
            String errorMessage,
            Long durationMs,
            Long audioSize,
            Integer retryCount
    ) {
        public static AsrResult success(String transcript, Long durationMs,
                                        Long audioSize, Integer retryCount) {
            return new AsrResult(true, transcript, null, durationMs,
                    audioSize, retryCount);
        }

        public static AsrResult error(String errorMessage, Long durationMs,
                                      Integer retryCount) {
            return new AsrResult(false, null, errorMessage, durationMs,
                    null, retryCount);
        }
    }

    /**
     * 启动ASR识别 - 主入口方法
     */
    public Mono<AsrResult> startAsr(
            String wsUrl,
            String wavPath,
            String mode,
            String chunkSize,
            int chunkInterval,
            String hotwords) {

        AsrConfig config = new AsrConfig(wsUrl, wavPath, mode,
                chunkSize, chunkInterval, hotwords);
        return startAsr(config);
    }

    /**
     * 启动ASR识别 - 使用配置对象
     */
    public Mono<AsrResult> startAsr(AsrConfig config) {

        return Mono.create(new Consumer<MonoSink<AsrResult>>() {
            @Override
            public void accept(MonoSink<AsrResult> sink) {
                try {
                    // 验证配置
                    validateConfig(config);

                    // 获取音频文件大小
                    long audioSize = getAudioSize(config.wavPath());
                    AtomicLong startTime = new AtomicLong(System.currentTimeMillis());
                    AtomicInteger retryCount = new AtomicInteger(0);

                    // 创建WebSocket客户端
                    WebSocketClient client = new ReactorNettyWebSocketClient();

                    // 执行WebSocket连接和处理
                    client.execute(
                            URI.create(config.wsUrl()),
                            session -> processCompleteAsrSession(
                                    session, config, sink, startTime, audioSize, retryCount
                            )
                    ).subscribe(
                            null, // onNext - 忽略，因为返回的是Void
                            error -> handleWebSocketError(error, sink, startTime, retryCount, config),
                            () -> handleWebSocketCompletion(sink, startTime, retryCount)
                    );

                } catch (Exception e) {
                    sink.error(e);
                }
            }
        }) .timeout(config.timeout()).doOnSubscribe(s ->
                        log.info("Starting ASR for: {}", config.wavPath()))
                .doOnSuccess(result -> logResult(result))
                .onErrorResume(e -> {
                    log.error("ASR processing failed", e);
                    return Mono.just(AsrResult.error(
                            e.getMessage(),
                            System.currentTimeMillis(),
                            0
                    ));
                });

    }

    /**
     * 处理完整的ASR会话
     */
    private Mono<Void> processCompleteAsrSession(
            WebSocketSession session,
            AsrConfig config,
            reactor.core.publisher.MonoSink<AsrResult> sink,
            AtomicLong startTime,
            long audioSize,
            AtomicInteger retryCount) {

        AtomicBoolean isComplete = new AtomicBoolean(false);
        AtomicReference<StringBuilder> transcriptRef = new AtomicReference<>(new StringBuilder());

        String wavName = Path.of(config.wavPath()).getFileName().toString();
        String wavFormat = getWavFormat(config.wavPath());
        int sendChunkSize = calculateChunkSize(config.chunkSize(), config.chunkInterval());

        log.info("Starting ASR session for file: {}, mode: {}, chunkSize: {}",
                wavName, config.mode(), sendChunkSize);

        return Mono.when(
                        // 1. 发送初始化配置
                        sendInitialization(session, config, wavName, wavFormat),

                        // 2. 异步发送音频数据
                        sendAudioData(session, config, sendChunkSize)
                                .subscribeOn(Schedulers.boundedElastic())
                                .doOnError(e -> {
                                    log.error("Error sending audio data", e);
                                    completeWithError(sink, startTime, retryCount,
                                            "Audio send error: " + e.getMessage());
                                })
                )
                .then(
                        // 3. 接收和处理识别结果
                        receiveAndProcessResults(
                                session, transcriptRef, isComplete,
                                sink, startTime, audioSize, retryCount
                        )
                )
                .doFinally(signal -> {
                    // 4. 清理资源
                    cleanupSession(session, isComplete, transcriptRef,
                            sink, startTime, retryCount);
                });
    }

    /**
     * 发送初始化配置
     */
    private Mono<Void> sendInitialization(
            WebSocketSession session,
            AsrConfig config,
            String wavName,
            String wavFormat) {

        return Mono.fromCallable(() -> buildInitJson(config, wavName, wavFormat))
                .doOnNext(json -> log.info("Sending initialization: {}", json))
                .flatMap(json -> session.send(
                        Mono.just(session.textMessage(json.toJSONString()))
                ))
                .doOnSuccess(v -> log.debug("Initialization sent successfully"))
                .doOnError(e -> log.error("Failed to send initialization", e));
    }

    /**
     * 发送音频数据
     */
    private Mono<Void> sendAudioData(
            WebSocketSession session,
            AsrConfig config,
            int chunkSize) {

        Path audioPath = Path.of(config.wavPath());

        return Mono.using(
                () -> {
                    RandomAccessFile raf = new RandomAccessFile(audioPath.toFile(), "r");
                    // 如果是WAV文件，跳过头部
                    if (config.wavPath().endsWith(".wav")) {
                        raf.seek(WAV_HEADER_SIZE);
                    }
                    return raf;
                },
                raf -> Flux.generate(() -> 0L, (state, sink) -> {
                            try {
                                long currentPos = raf.getFilePointer();
                                long fileLength = raf.length();

                                if (currentPos >= fileLength) {
                                    sink.complete();
                                    return state;
                                }

                                long remaining = fileLength - currentPos;
                                int readSize = (int) Math.min(chunkSize, remaining);

                                byte[] buffer = new byte[readSize];
                                int bytesRead = raf.read(buffer);

                                if (bytesRead > 0) {
                                    sink.next(ByteBuffer.wrap(buffer, 0, bytesRead));

                                    // 在线模式添加延迟
                                    if ("online".equals(config.mode())) {
                                        try {
                                            Thread.sleep(ONLINE_CHUNK_DELAY.toMillis());
                                        } catch (InterruptedException e) {
                                            Thread.currentThread().interrupt();
                                            sink.error(e);
                                        }
                                    }
                                    return state + bytesRead;
                                } else {
                                    sink.complete();
                                    return state;
                                }
                            } catch (IOException e) {
                                sink.error(e);
                                return state;
                            }
                        })
                        .concatMap(buffer ->
                                session.send(Mono.just(
                                                session.binaryMessage(factory -> factory.wrap((ByteBuffer) buffer))
                                        ))
                                        .doOnError(e -> log.warn("Error sending audio chunk", e))
                        )
                        .then()
                        .then(sendEof(session)),
                raf -> {
                    try {
                        raf.close();
                    } catch (IOException e) {
                        log.warn("Failed to close audio file", e);
                    }
                }
        );
    }

    /**
     * 发送结束标记
     */
    private Mono<Void> sendEof(WebSocketSession session) {
        return Mono.fromCallable(() -> {
                    JSONObject eof = new JSONObject();
                    eof.put("is_speaking", false);
                    return eof;
                })
                .doOnNext(eof -> log.info("Sending EOF signal"))
                .flatMap(eof -> session.send(
                        Mono.just(session.textMessage(eof.toJSONString()))
                ))
                .doOnSuccess(v -> log.debug("EOF sent successfully"));
    }

    /**
     * 接收并处理识别结果
     */
    private Mono<Void> receiveAndProcessResults(
            WebSocketSession session,
            AtomicReference<StringBuilder> transcriptRef,
            AtomicBoolean isComplete,
            reactor.core.publisher.MonoSink<AsrResult> sink,
            AtomicLong startTime,
            long audioSize,
            AtomicInteger retryCount) {

        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .doOnNext(message -> {
                    try {
                        JSONObject json = JSONObject.parseObject(message);
                        log.debug("Received ASR response: {}", json);

                        // 提取识别文本
                        String text = json.getString("text");
                        if (text != null && !text.isEmpty()) {
                            transcriptRef.get().append(text).append(" ");
                        }

                        // 检查会话是否结束
                        Boolean isSpeaking = json.getBoolean("is_speaking");
                        if (Boolean.FALSE.equals(isSpeaking)) {
                            isComplete.set(true);

                            String transcript = transcriptRef.get().toString().trim();
                            long duration = System.currentTimeMillis() - startTime.get();

                            if (!transcript.isEmpty()) {
                                // 成功完成，发送结果
                                sink.success(AsrResult.success(
                                        transcript, duration, audioSize, retryCount.get()
                                ));
                                log.info("ASR completed successfully with transcript length: {}",
                                        transcript.length());
                            } else {
                                // 完成但没有识别结果
                                sink.success(AsrResult.error(
                                        "No transcript generated", duration, retryCount.get()
                                ));
                                log.warn("ASR completed but no transcript generated");
                            }
                        }
                    } catch (Exception e) {
                        log.warn("Failed to parse ASR message: {}", message, e);
                    }
                })
                .then()
                .doOnError(e -> {
                    log.error("Error receiving ASR results", e);
                    completeWithError(sink, startTime, retryCount,
                            "Receive error: " + e.getMessage());
                });
    }

    /**
     * 清理会话
     */
    private void cleanupSession(
            WebSocketSession session,
            AtomicBoolean isComplete,
            AtomicReference<StringBuilder> transcriptRef,
            reactor.core.publisher.MonoSink<AsrResult> sink,
            AtomicLong startTime,
            AtomicInteger retryCount) {

        // 关闭会话
        if (session.isOpen()) {
            session.close().subscribe(
                    null,
                    e -> log.debug("Error closing session", e)
            );
        }

        // 如果会话结束但还没有完成回调
        if (!isComplete.get()) {
            long duration = System.currentTimeMillis() - startTime.get();
            String transcript = transcriptRef.get().toString().trim();

            if (!transcript.isEmpty()) {
                // 有部分结果
                sink.success(AsrResult.success(
                        transcript, duration, 0L, retryCount.get()
                ));
                log.info("ASR session ended with partial transcript");
            } else {
                // 没有结果
                sink.success(AsrResult.error(
                        "Session ended without completion",
                        duration,
                        retryCount.get()
                ));
                log.warn("ASR session ended without completion");
            }
        }
    }

    /**
     * 处理WebSocket错误
     */
    private void handleWebSocketError(
            Throwable error,
            reactor.core.publisher.MonoSink<AsrResult> sink,
            AtomicLong startTime,
            AtomicInteger retryCount,
            AsrConfig config) {

        long duration = System.currentTimeMillis() - startTime.get();
        log.error("WebSocket error after {}ms (retry count: {})",
                duration, retryCount.get(), error);

        // 检查是否应该重试
        if (shouldRetry(error) && retryCount.get() < config.maxRetries()) {
            retryCount.incrementAndGet();
            log.info("Retrying ASR (attempt {})", retryCount.get());

            // 这里可以添加重试逻辑
            // 目前我们直接返回错误，实际项目中可以实现重试
            sink.success(AsrResult.error(
                    "Connection error (attempt " + retryCount.get() + "): " + error.getMessage(),
                    duration,
                    retryCount.get()
            ));
        } else {
            sink.success(AsrResult.error(
                    "Connection failed: " + error.getMessage(),
                    duration,
                    retryCount.get()
            ));
        }
    }

    /**
     * 处理WebSocket完成
     */
    private void handleWebSocketCompletion(
            MonoSink<AsrResult> sink,
            AtomicLong startTime,
            AtomicInteger retryCount) {

        long duration = System.currentTimeMillis() - startTime.get();
        log.debug("WebSocket session completed after {}ms", duration);

        // 如果还没有完成（正常情况下应该在processCompleteAsrSession中完成）
        sink.success(AsrResult.error(
                "WebSocket session completed without result",
                duration,
                retryCount.get()
        ));
    }

    /**
     * 完成并返回错误
     */
    private void completeWithError(
            MonoSink<AsrResult> sink,
            AtomicLong startTime,
            AtomicInteger retryCount,
            String errorMessage) {

        long duration = System.currentTimeMillis() - startTime.get();
        sink.success(AsrResult.error(errorMessage, duration, retryCount.get()));
    }

    /**
     * 构建初始化JSON
     */
    private JSONObject buildInitJson(
            AsrConfig config,
            String wavName,
            String wavFormat) {

        JSONObject obj = new JSONObject();
        obj.put("mode", config.mode());

        JSONArray chunkSizes = new JSONArray();
        for (String c : config.chunkSize().split(",")) {
            chunkSizes.add(Integer.parseInt(c.trim()));
        }
        obj.put("chunk_size", chunkSizes);
        obj.put("chunk_interval", config.chunkInterval());
        obj.put("wav_name", wavName);
        obj.put("is_speaking", true);
        obj.put("wav_format", wavFormat);

        // 处理热词
        if (config.hotwords() != null && !config.hotwords().isBlank()) {
            JSONObject hotwords = parseHotwords(config.hotwords());
            if (!hotwords.isEmpty()) {
                obj.put("hotwords", hotwords);
            }
        }

        return obj;
    }

    /**
     * 解析热词
     */
    private JSONObject parseHotwords(String hotwordsStr) {
        JSONObject hotwords = new JSONObject();
        if (hotwordsStr == null || hotwordsStr.isBlank()) {
            return hotwords;
        }

        String[] tokens = hotwordsStr.trim().split("\\s+");
        StringBuilder currentWord = new StringBuilder();

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                if (!currentWord.isEmpty()) {
                    String word = currentWord.toString().trim();
                    if (!word.isEmpty()) {
                        hotwords.put(word, Integer.parseInt(token));
                    }
                    currentWord.setLength(0);
                }
            } else {
                if (!currentWord.isEmpty()) {
                    currentWord.append(" ");
                }
                currentWord.append(token);
            }
        }

        // 处理最后一个词（如果没有权重）
        if (!currentWord.isEmpty()) {
            String word = currentWord.toString().trim();
            if (!word.isEmpty()) {
                hotwords.put(word, 10); // 默认权重
            }
        }

        return hotwords;
    }

    /**
     * 计算块大小
     */
    private int calculateChunkSize(String chunkSizeConfig, int chunkInterval) {
        String[] chunkList = chunkSizeConfig.split(",");
        if (chunkList.length < 2) {
            throw new IllegalArgumentException("Invalid chunk size: " + chunkSizeConfig);
        }

        int intChunkSize = 60 * Integer.parseInt(chunkList[1].trim()) / chunkInterval;
        int chunkSamples = SAMPLE_RATE / 1000 * intChunkSize;
        return chunkSamples * 2; // 16-bit = 2 bytes per sample
    }

    /**
     * 获取音频格式
     */
    private String getWavFormat(String wavPath) {
        int dotIndex = wavPath.lastIndexOf('.');
        if (dotIndex == -1) {
            return "pcm";
        }
        String suffix = wavPath.substring(dotIndex + 1).toLowerCase();
        return "wav".equals(suffix) ? "pcm" : suffix;
    }

    /**
     * 获取音频文件大小
     */
    private long getAudioSize(String wavPath) {
        try {
            Path path = Path.of(wavPath);
            long size = Files.size(path);
            if (wavPath.endsWith(".wav")) {
                size = Math.max(0, size - WAV_HEADER_SIZE);
            }
            return size;
        } catch (IOException e) {
            log.warn("Failed to get audio file size: {}", e.getMessage());
            return 0L;
        }
    }

    /**
     * 验证配置
     */
    private void validateConfig(AsrConfig config) {
        if (config.wsUrl() == null || config.wsUrl().isBlank()) {
            throw new IllegalArgumentException("WebSocket URL is required");
        }
        if (config.wavPath() == null || config.wavPath().isBlank()) {
            throw new IllegalArgumentException("Audio file path is required");
        }
        if (!Files.exists(Path.of(config.wavPath()))) {
            throw new IllegalArgumentException("Audio file not found: " + config.wavPath());
        }
    }

    /**
     * 判断是否应该重试
     */
    private boolean shouldRetry(Throwable e) {
        return e instanceof IOException ||
                e instanceof java.util.concurrent.TimeoutException ||
                (e.getMessage() != null &&
                        (e.getMessage().contains("connection") ||
                                e.getMessage().contains("timeout") ||
                                e.getMessage().contains("reset")));
    }

    /**
     * 记录结果日志
     */
    private void logResult(AsrResult result) {
        if (result.success()) {
            log.info("""
                ===== ASR SUCCESS =====
                Duration: {}ms
                Audio size: {} bytes
                Retry count: {}
                Transcript (first 200 chars): {}
                =======================
                """,
                    result.durationMs(),
                    result.audioSize(),
                    result.retryCount(),
                    result.transcript().length() > 200 ?
                            result.transcript().substring(0, 200) + "..." :
                            result.transcript()
            );
        } else {
            log.warn("""
                ===== ASR FAILED =====
                Duration: {}ms
                Retry count: {}
                Error: {}
                ======================
                """,
                    result.durationMs(),
                    result.retryCount(),
                    result.errorMessage()
            );
        }
    }

    /**
     * 简化调用方法（返回字符串）
     */
    public Mono<String> startAsrSimple(
            String wsUrl,
            String wavPath,
            String mode,
            String chunkSize,
            int chunkInterval,
            String hotwords) {

        return startAsr(wsUrl, wavPath, mode, chunkSize, chunkInterval, hotwords)
                .map(result -> {
                    if (result.success()) {
                        return result.transcript();
                    } else {
                        return "ERROR: " + result.errorMessage();
                    }
                });
    }
}