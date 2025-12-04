package org.keep.demo.etd.ws;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class AsrWebSocketClient extends WebSocketClient {

    private final AsrRequest request;
    private final CompletableFuture<AsrResponse> resultFuture = new CompletableFuture<>();
    private final AudioSender audioSender;

    private final StringBuilder finalText = new StringBuilder();
    private volatile boolean finished = false;

    public AsrWebSocketClient(URI serverUri, AsrRequest req) {
        super(serverUri);
        this.request = req;
        this.audioSender = new AudioSender();
    }

    public CompletableFuture<AsrResponse> start() {
        log.info("Connecting to {}", getURI());
        this.connect();
        return resultFuture;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        log.info("WebSocket opened");

        // 初始化 JSON
        JSONObject init = new JSONObject();
        init.put("mode", request.mode());
        init.put("chunk_size", request.chunkSizeList());
        init.put("chunk_interval", request.chunkInterval());
        init.put("wav_name", request.fileName());
        init.put("wav_format", request.format());
        init.put("is_speaking", true);
        init.put("hotwords", request.hotwordsJson());

        send(init.toJSONString());

        // 发送音频
        new Thread(() -> {
            try {
                audioSender.sendAudioChunks(this, request.filePath(), request.mode());
                send("{\"is_speaking\": false}");
            } catch (Exception e) {
                resultFuture.complete(AsrResponse.error("Audio send failed: " + e.getMessage()));
            }
        }).start();
    }

    @Override
    public void onMessage(String message) {
        JSONObject json = JSON.parseObject(message);

        String text = json.getString("text");
        Boolean isFinal = json.getBoolean("is_final");

        if (text != null) {
            finalText.append(text).append(" ");
            log.info("Partial: {}", text);
        }

        if (Boolean.TRUE.equals(isFinal)) {
            finished = true;
            completeSuccess();
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        if (!finished) {
            completeSuccess();
        }
    }

    @Override
    public void onError(Exception ex) {
        resultFuture.complete(AsrResponse.error("WebSocket error: " + ex.getMessage()));
    }

    private void completeSuccess() {
        if (!resultFuture.isDone()) {
            resultFuture.complete(
                    AsrResponse.success(finalText.toString().trim())
            );
        }
    }
}
