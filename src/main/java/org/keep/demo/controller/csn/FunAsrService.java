package org.keep.demo.controller.csn;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FunAsrService {

    private final WebSocketClientService ws;

    public Mono<WebSocketClientService.AsrResult> runAsr(FunasrRequest req) {
        String wsUrl = "ws://" + req.host() + ":" + req.port();

        return ws.startAsr(
                wsUrl,
                req.wavPath(),
                req.mode(),
                req.chunkSize(),
                req.chunkInterval(),
                req.hotwords()
        );
    }
}
