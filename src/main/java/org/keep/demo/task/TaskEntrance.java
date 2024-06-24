package org.keep.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 任务执行入口
 * @date 2023/12/10 14:01
 */
@Slf4j
@Component
public class TaskEntrance implements CommandLineRunner {

    private final static int MAX_SIZE = 5;
    private static final ExecutorService EXECUTOR_SERVICE
            = Executors.newFixedThreadPool(MAX_SIZE, new CustomThreadFactory("download"));
    private static final ExecutorCompletionService<String> EXECUTOR_COMPLETION_SERVICE
            = new ExecutorCompletionService<>(EXECUTOR_SERVICE);

    private static final ScheduledExecutorService RESULT_HANDLER = Executors.newSingleThreadScheduledExecutor();


    public void producer() {

        ConcreteTask concreteTask = new ConcreteTask();
        EXECUTOR_COMPLETION_SERVICE.submit(concreteTask);
        log.info("任务已提交");
    }

    private void enableResultHandler() {

        while (true) {
            Future<String> future;
            try {
                future = EXECUTOR_COMPLETION_SERVICE.take();
            } catch (InterruptedException e) {
                log.info("任务执行线程池关闭");
                return;
            }
            try {
                String result = future.get(30, TimeUnit.SECONDS);
                log.info("任务执行结果：{}", result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("任务入口启动成功");
        RESULT_HANDLER.submit(this::enableResultHandler);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            List<Runnable> runnables = RESULT_HANDLER.shutdownNow();
            log.info("结果处理手柄关闭操作");
        }));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            List<Runnable> runnables = EXECUTOR_SERVICE.shutdownNow();
            log.info("任务执行线程池关闭操作");
        }));
    }
}
