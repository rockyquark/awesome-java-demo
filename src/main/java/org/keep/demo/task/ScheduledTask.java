package org.keep.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.keep.demo.redis.ComplianceTaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 定时任务测试
 * @date 2024/1/3 9:57
 */
@Component
@Slf4j
public class ScheduledTask {

    private final ComplianceTaskManager complianceTaskManager;

    @Autowired
    public ScheduledTask(ComplianceTaskManager complianceTaskManager) {
        this.complianceTaskManager = complianceTaskManager;
    }

    public void printDate() {
       try {
           complianceTaskManager.pullTask();
       } catch (Exception e) {
           log.error(e.getMessage(), e);
       }
    }
}
