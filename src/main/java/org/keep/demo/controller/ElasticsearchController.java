package org.keep.demo.controller;

import com.alibaba.fastjson2.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.mapper.ObjectMapper;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/es")
@RequiredArgsConstructor
public class ElasticsearchController {

    private final RestHighLevelClient client;
    private final String INDEX_NAME = "people";

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody JSONObject data) {
        try {
            IndexRequest request = new IndexRequest(INDEX_NAME)
                    .id(UUID.randomUUID().toString())
                    .source(data, XContentType.JSON);

            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            return ResponseEntity.ok("Inserted with id: " + response.getId());

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insert failed: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<JSONObject>> getAll() {
        try {
            SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.matchAllQuery());
            sourceBuilder.size(1000); // 限制最大返回数量
            searchRequest.source(sourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);


            List<JSONObject> people = Arrays.stream(searchResponse.getHits().getHits())
                    .map(hit -> {
                        try {
                            return JSONObject.parseObject(hit.getSourceAsString());
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(people);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
