package org.keep.demo;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.MainResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ElasticsearchConnectionTest {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void testConnectionToElasticsearch() throws Exception {
        // 调用 Elasticsearch 根节点信息 API
        MainResponse response = client.info(RequestOptions.DEFAULT);

        // 断言集群信息返回正常
        assertThat(response).isNotNull();
        assertThat(response.getVersion()).isNotNull();

        // 打印信息以供调试
        System.out.println("Cluster name: " + response.getClusterName());
        System.out.println("Elasticsearch version: " + response.getVersion().getNumber());
    }
}
