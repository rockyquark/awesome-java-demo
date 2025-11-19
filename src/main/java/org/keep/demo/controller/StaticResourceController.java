package org.keep.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author 肖锦光
 * @description 练习模板静态资源控制入口
 * @date 2025/9/29 09:28
 */
@Slf4j
@Validated
@CrossOrigin
@RestController
@RequestMapping("/static/resources")
public class StaticResourceController {
	
	/**
	 * @note 流式播放 m3u8 信息文件
	 */
	@GetMapping(value = "/hls/{filename:.+\\.m3u8}", produces = "application/vnd.apple.mpegurl")
	public ResponseEntity<Resource> getM3U8(@PathVariable String filename) throws IOException {
		byte[] bytes = Files.readAllBytes(Path.of("src/main/resources/HLS").resolve(filename));
		ByteArrayResource resource = new ByteArrayResource(bytes);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/vnd.apple.mpegurl"));
		return ResponseEntity.ok().headers(headers).body(resource);
	}
	
	
	/**
	 * @note 流式播放接口
	 */
	@GetMapping(value = "/hls/{filename:.+\\.ts}", produces = "video/mp2t")
	public ResponseEntity<Resource> getVideoHls(@PathVariable String filename) throws IOException {
		Path root = Path.of("src/main/resources/HLS/");
		byte[] bytes = Files.readAllBytes(root.resolve(filename));
		ByteArrayResource resource = new ByteArrayResource(bytes);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("video/mp2t"));
		headers.set(HttpHeaders.ACCEPT_RANGES, "bytes");
		headers.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()));
		// 添加缓存控制头，因为.ts文件通常较小且需要频繁请求
//		headers.setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS));
		headers.set(HttpHeaders.CONNECTION, "keep-alive");
		
		
		return ResponseEntity.ok()
				.headers(headers)
				.body(resource);
	}
}
