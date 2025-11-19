package org.keep.demo.service;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface ISseTaskService {

    /**
     * @node 执行笨重的任务
     * @param taskId 任务编号
     * @param emitter 事件发射器
     */
    void executeHeavyTask(String taskId, SseEmitter emitter);
}
