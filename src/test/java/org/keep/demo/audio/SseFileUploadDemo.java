package org.keep.demo.audio;

import okhttp3.*;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SseFileUploadDemo {

    // 使用CountDownLatch防止程序立即退出
    private static final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        // 1. 配置OkHttpClient（添加超时设置）
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(0, TimeUnit.SECONDS) // 0表示不超时，适合SSE长连接
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        // 2. 检查文件是否存在
        File audioFile = new File("C:\\Users\\CSAIR\\Desktop\\通用语音识别问题\\1.mp3");
        if (!audioFile.exists()) {
            System.err.println("❌ 文件不存在: " + audioFile.getAbsolutePath());
            return;
        }
        System.out.println("📁 文件大小: " + audioFile.length() + " bytes");

        // 3. 构建multipart请求体
        MultipartBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("enableTextRcg", "true")
                .addFormDataPart("rcgEngineType", "common")
                .addFormDataPart("audio", "test.wav",
                        RequestBody.create(
                                MediaType.parse("audio/wav"),
                                audioFile))
                .build();

        // 4. 构建请求
        Request request = new Request.Builder()
                .url("http://127.0.0.1:29993/csn/generateSpeakerVoiceSegment/sse")
                .post(requestBody)
                .header("Accept", "text/event-stream")
                .header("Cache-Control", "no-cache")
                .build();

        System.out.println("🚀 开始建立SSE连接...");

        // 5. 建立SSE监听
        EventSource.Factory factory = EventSources.createFactory(client);
        factory.newEventSource(request, new EventSourceListener() {
            @Override
            public void onOpen(EventSource eventSource, Response response) {
                System.out.println("✅ SSE连接已建立，响应码: " + response.code());
                if (!response.isSuccessful()) {
                    System.err.println("❌ 服务器返回错误: " + response.code());
                    latch.countDown(); // 释放锁，让程序结束
                }
            }

            @Override
            public void onEvent(EventSource eventSource, String id, String type, String data) {
                System.out.println("📩 接收到事件 - ID: " + id + ", Type: " + type);
                System.out.println("📄 数据: " + data);

                // 如果接收到结束事件，可以关闭连接
                if (data.contains("\"status\":\"COMPLETED\"") ||
                        data.contains("\"status\":\"FAILED\"")) {
                    System.out.println("🏁 任务完成，关闭连接");
                    eventSource.cancel();
                    latch.countDown();
                }
            }

            @Override
            public void onFailure(EventSource eventSource, Throwable t, Response response) {
                System.err.println("❌ SSE连接出错: " + t.getMessage());
                if (response != null) {
                    System.err.println("响应码: " + response.code());
                    try {
                        System.err.println("响应体: " + response.body().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                t.printStackTrace();
                latch.countDown();
            }

            @Override
            public void onClosed(EventSource eventSource) {
                System.out.println("🔌 SSE连接已关闭");
                latch.countDown();
            }
        });

        // 6. 等待SSE事件（防止程序立即退出）
        System.out.println("⏳ 等待SSE事件...");
        try {
            // 等待最多30分钟
            boolean completed = latch.await(30, TimeUnit.MINUTES);
            if (!completed) {
                System.out.println("⏰ 等待超时");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("🎯 程序结束");
    }
}