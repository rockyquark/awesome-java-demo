package org.keep.demo.controller.csn;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/asr")
@RequiredArgsConstructor
public class FunAsrController {

    private final FunAsrService funasr;

    @PostMapping("/start")
    public Mono<WebSocketClientService.AsrResult> startAsr(@RequestBody FunasrRequest req) {
        return funasr.runAsr(req);
    }
}
