package org.keep.demo.controller.csn;

public record FunasrRequest(
        String host,
        String port,
        String wavPath,
        String mode,
        String chunkSize,
        int chunkInterval,
        String hotwords
) {}
