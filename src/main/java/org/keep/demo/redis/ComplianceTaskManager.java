package org.keep.demo.redis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class ComplianceTaskManager {

    private static final String LOCK_KEY = "compliance_task_lock";
    private static final String TASK_HASH_PREFIX = "compliance_task:";
    private static final String TASK_STATUS_FIELD_H1_H2 = "H1_H2_status";
    private static final String TASK_STATUS_FIELD_H4 = "H4_status";
    private static final String TASK_STATUS_COMPLETED = "completed";
    private static final String TASK_UPDATE_TIME_KEY = "compliance_task_update_time";

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public ComplianceTaskManager(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addComplianceTask(String taskId) {
        // 新增合规监察任务入口
        String taskKey = getTaskKey(taskId);
        redisTemplate.opsForHash().put(taskKey, TASK_STATUS_FIELD_H1_H2, TASK_STATUS_COMPLETED);
        redisTemplate.opsForHash().put(taskKey, TASK_STATUS_FIELD_H4, TASK_STATUS_COMPLETED);

        // 更新任务的更新时间
        redisTemplate.opsForZSet().add(TASK_UPDATE_TIME_KEY, taskKey, System.currentTimeMillis());
    }

    public void pullTask() {
        // 获取分布式锁
        if (acquireLock()) {
            try {
                // 获取所有任务的键
                Set<String> taskKeys = getAllTaskKeys();

                // 遍历任务，按照更新时间排序
                for (String taskKey : taskKeys) {
                    Map<Object, Object> taskInfo = redisTemplate.opsForHash().entries(taskKey);
                    String h1h2Status = (String) taskInfo.get(TASK_STATUS_FIELD_H1_H2);
                    String h4Status = (String) taskInfo.get(TASK_STATUS_FIELD_H4);

                    // 检查任务状态
                    if (TASK_STATUS_COMPLETED.equals(h1h2Status) && TASK_STATUS_COMPLETED.equals(h4Status)) {
                        // 拉取到合规监察记录任务后的处理逻辑
                        // processPulledTask(taskKey);

                        // 任务处理完成后，更新任务状态为已完成
                        updateTaskStatus(taskKey, TASK_STATUS_COMPLETED, TASK_STATUS_COMPLETED);

                        // 结束遍历，已经找到最早更新完的任务
                        break;
                    }
                }
            } finally {
                // 释放分布式锁
                releaseLock();
            }
        }
    }

    private boolean acquireLock() {
        // 尝试获取锁并设置锁超时时间为10ms
        Boolean result = redisTemplate.opsForValue().setIfAbsent(LOCK_KEY, "locked", Duration.ofMillis(10));

        // 返回获取锁结果
        return result != null && result;
    }

    private void releaseLock() {
        // 释放锁
        redisTemplate.delete(LOCK_KEY);
    }

    private Set<String> getAllTaskKeys() {
        // 获取所有任务的键，并按照更新时间排序
        return redisTemplate.opsForZSet().range(TASK_UPDATE_TIME_KEY, 0, -1);
    }

    private void updateTaskStatus(String taskKey, String h1h2Status, String h4Status) {
        // 更新合规监察任务状态
        redisTemplate.opsForHash().put(taskKey, TASK_STATUS_FIELD_H1_H2, h1h2Status);
        redisTemplate.opsForHash().put(taskKey, TASK_STATUS_FIELD_H4, h4Status);
    }

    private String getTaskKey(String taskId) {
        // 构造任务的键
        return TASK_HASH_PREFIX + taskId;
    }
}
