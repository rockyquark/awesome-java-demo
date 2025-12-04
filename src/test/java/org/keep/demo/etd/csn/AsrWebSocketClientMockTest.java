package org.keep.demo.etd.csn;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.junit.jupiter.api.Test;
import org.java_websocket.server.WebSocketServer;
import org.keep.demo.etd.ws.AsrRequest;
import org.keep.demo.etd.ws.AsrWebSocketClient;

import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class AsrWebSocketClientMockTest {

    private String preview(byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(arr.length, 40); i++) {
            sb.append(String.format("%02X ", arr[i]));
        }
        return sb.toString();
    }


    @Test
    void testAsrClient() throws Exception {

        int port = 11098;
        Random random = new Random();
        // ------------------ Mock WebSocket Server ------------------
        WebSocketServer server = new WebSocketServer(new InetSocketAddress(port)) {

            boolean flag = false;
            @Override public void onOpen(WebSocket conn, ClientHandshake handshake) {}

            @Override
            public void onMessage(WebSocket conn, ByteBuffer message) {
                log.info("Recv binary: {} bytes", message.remaining());
            }

            @Override public void onMessage(WebSocket conn, String msg) {
                log.info("onMessage: {}", msg);
                JSONObject jsonObject = JSONObject.parseObject(msg, JSONObject.class);
                Boolean isSpeaking = jsonObject.getBoolean("is_speaking");
                if (Boolean.FALSE == isSpeaking) {
                    conn.send("{\"text\":\"hello world \",\"is_final\":true}");
                }
            }

            @Override public void onClose(WebSocket conn, int code, String reason, boolean remote) {}

            @Override public void onError(WebSocket conn, Exception ex) {}

            @Override
            public void onStart() {
                log.info("WebSocketServer started");
            }
        };
        server.start();

        // ------------------ Create temp PCM ------------------
        String pcmPath = "C:\\Users\\HelloWorld\\Desktop\\用户测试音频\\output.wav";
        AsrRequest request = new AsrRequest(
                pcmPath,
                "online",
                "5,10,5",
                10,
                null
        );

        AsrWebSocketClient client = new AsrWebSocketClient(
                new java.net.URI("ws://127.0.0.1:" + port),
                request
        );

        var response = client.start().get();
        log.info("response: {}", JSONObject.toJSONString(response));
    }
}
