package org.keep.demo.service;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ISseTaskServiceImpl implements ISseTaskService {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void executeHeavyTask(String taskId, SseEmitter emitter) {
        executor.submit(() -> {
            try {
                JSONObject sendBody = new JSONObject();
                sendBody.put("taskId", taskId);
                sendBody.put("progress", 0);
                sendBody.put("data", "任务开始执行");
                send(emitter, sendBody);

                for (int i = 1; i <= 100; i += 10) {
                    Thread.sleep(30_000); // 模拟耗时30秒
                    sendBody.put("progress", i);
                    send(emitter, sendBody);
                }

                sendBody.put("progress", 100);
                sendBody.put("data", Map.of("result", "success", "data", "[1,2,3]"));
                send(emitter, sendBody);
                emitter.complete();

            } catch (Exception e) {
                try {
                    emitter.send(SseEmitter.event()
                            .name("error")
                            .data("任务执行异常：" + e.getMessage()));
                } catch (IOException ignored) {}
                emitter.completeWithError(e);
            }
        });
    }

    private void send(SseEmitter emitter, JSONObject sendBody) throws IOException {
        emitter.send(SseEmitter.event()
                .name("message")
                .data(sendBody)
                .id(String.valueOf(System.currentTimeMillis())));
    }
}
