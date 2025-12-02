package org.keep.demo.controller;

import com.alibaba.fastjson2.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/es")
@RequiredArgsConstructor
public class ElasticsearchController {

    private final ElasticsearchOperations esOps;

    private final String INDEX_NAME = "people";

    /** 插入数据 */
    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody JSONObject data) {
        try {
            String id = UUID.randomUUID().toString();
            esOps.save(data, INDEX_NAME);

            return ResponseEntity.ok("Inserted with id: " + id);
        } catch (Exception e) {
            log.error("Insert error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Insert failed: " + e.getMessage());
        }
    }

    /** 查询全部 */
    @GetMapping("/all")
    public ResponseEntity<List<JSONObject>> getAll() {
        try {
            Query query = NativeQuery.builder()
                    .withQuery(q -> q.matchAll(m -> m))
                    .withPageable(org.springframework.data.domain.PageRequest.of(0, 1000))
                    .build();

            SearchHits<JSONObject> searchHits =
                    esOps.search(query, JSONObject.class);

            List<JSONObject> result = new ArrayList<>();

            for (SearchHit<JSONObject> hit : searchHits) {
                result.add(hit.getContent());
            }

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            log.error("Search error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
