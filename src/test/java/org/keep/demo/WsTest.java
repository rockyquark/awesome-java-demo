package org.keep.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.keep.demo.controller.csn.WebSocketClientService;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.annotation.Resource;

@SpringBootTest
@Slf4j
public class WsTest {

    @Resource
    private WebSocketClientService webSocketClientService;

    @Test
    void test() {
        String wavPath = "C:\\Users\\HelloWorld\\Desktop\\用户测试音频\\output.wav";
        String wsURL = "ws://10.0.128.155:10098";
        // 方法1：使用配置对象
        WebSocketClientService.AsrConfig config = new WebSocketClientService.AsrConfig(
                wsURL,
                wavPath,
                "online",
                "5,10,5",
                10,
                "阿里巴巴 30 腾讯 20"
        );

        webSocketClientService.startAsr(config)
                .subscribe(result -> {
                    if (result.success()) {
                        log.info("识别成功: {}", result.transcript());
                        log.info("耗时: {}ms", result.durationMs());
                    } else {
                        log.info("识别失败: {}", result.errorMessage());
                    }
                });

        // 方法2：使用简化参数
        webSocketClientService.startAsr(
                wsURL,
                wavPath,
                "online",
                "5,10,5",
                10,
                ""
        ).subscribe(result -> {
            // 处理AsrResult对象
        });

        // 方法3：只返回字符串
        webSocketClientService.startAsrSimple(
                wsURL,
                wavPath,
                "online",
                "5,10,5",
                10,
                ""
        ).subscribe(transcript -> {
            System.out.println("识别结果: " + transcript);
        });
    }
}
