package org.keep.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;

@Configuration
public class AsrWebSocketConfig {

    @Bean
    public ReactorNettyWebSocketClient reactorNettyWebSocketClient() {
        return new ReactorNettyWebSocketClient();
    }
}
