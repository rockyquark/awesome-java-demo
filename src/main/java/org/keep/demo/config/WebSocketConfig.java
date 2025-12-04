package org.keep.demo.config;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(ApplicationContext context) {
        // 判断当前是否为 Web 容器环境
        if (context instanceof AnnotationConfigServletWebServerApplicationContext) {
            return new ServerEndpointExporter();
        } else {
            // 测试环境或非 Web 环境直接跳过
            return null;
        }
    }
}