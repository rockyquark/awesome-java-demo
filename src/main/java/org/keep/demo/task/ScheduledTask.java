package org.keep.demo.task;

import lombok.extern.slf4j.Slf4j;
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

    @Scheduled(cron = "10 * * * * *")
    @Scheduled(cron = "5 * * * * *")
    public void printDate() {
        log.info("current date={}", new Date());
    }
}
