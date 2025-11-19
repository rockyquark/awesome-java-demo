package org.keep.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
public class RedisConcurrentReadWriteTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final int KEY_RANGE = 1000;
    private static final int WRITE_THREAD_COUNT = 5;
    private static final int READ_THREAD_COUNT = 5;
    private static final int TEST_DURATION_SECONDS = 10;

    private final AtomicInteger writeSuccess = new AtomicInteger();
    private final AtomicInteger readSuccess = new AtomicInteger();
    private final AtomicInteger readFail = new AtomicInteger();

    @Test
    public void testConcurrentReadWrite() throws InterruptedException {
        System.out.println("启动 Redis 并发读写测试（SpringBootTest）...");

        ExecutorService executor = Executors.newFixedThreadPool(WRITE_THREAD_COUNT + READ_THREAD_COUNT);
        Random random = new Random();
        long endTime = System.currentTimeMillis() + TEST_DURATION_SECONDS * 1000L;

        // 写线程
        for (int i = 0; i < WRITE_THREAD_COUNT; i++) {
            executor.submit(() -> {
                while (System.currentTimeMillis() < endTime) {
                    String key = "test:key:" + random.nextInt(KEY_RANGE);
                    String value = "val_" + System.nanoTime();
                    try {
                        redisTemplate.opsForValue().set(key, value);
                        writeSuccess.incrementAndGet();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // 读线程
        for (int i = 0; i < READ_THREAD_COUNT; i++) {
            executor.submit(() -> {
                while (System.currentTimeMillis() < endTime) {
                    String key = "test:key:" + random.nextInt(KEY_RANGE);
                    try {
                        String value = redisTemplate.opsForValue().get(key);
                        if (value != null) {
                            readSuccess.incrementAndGet();
                        } else {
                            readFail.incrementAndGet();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // 等待执行结束
        executor.shutdown();
        executor.awaitTermination(TEST_DURATION_SECONDS + 5, TimeUnit.SECONDS);

        System.out.println("=== 测试完成 ===");
        System.out.println("写入成功：" + writeSuccess.get());
        System.out.println("读取成功：" + readSuccess.get());
        System.out.println("读取失败：" + readFail.get());
    }
}
