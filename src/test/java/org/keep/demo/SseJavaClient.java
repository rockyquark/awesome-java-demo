package org.keep.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SseJavaClient {

    public static void main(String[] args) throws Exception {
        String taskId = "task-" + System.currentTimeMillis();
        URI uri = new URI("http://localhost:8080/api/sse/start?taskId=" + taskId);

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "text/event-stream")
                .GET()
                .build();

        System.out.println("开始监听 SSE 事件：" + uri);

        client.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
                .thenAccept(response -> {
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(response.body()))) {

                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.startsWith("data:")) {
                                System.out.println("接收到消息：" + line.substring(5).trim());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).join();
    }
}
