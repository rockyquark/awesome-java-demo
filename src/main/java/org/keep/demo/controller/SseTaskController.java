package org.keep.demo.controller;

import org.keep.demo.service.ISseTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.*;

@RestController
@RequestMapping("/api/sse")
public class SseTaskController {

    private final ISseTaskService sseTaskService;

    @Autowired
    public SseTaskController(ISseTaskService sseTaskService) {
        this.sseTaskService = sseTaskService;
    }


    @GetMapping("/start")
    public SseEmitter startTask(@RequestParam String taskId) {
        // 创建一个 SSE 连接（默认超时 30分钟）
        SseEmitter emitter = new SseEmitter(30 * 60 * 1000L);
        sseTaskService.executeHeavyTask(taskId, emitter);
        return emitter;
    }
}
