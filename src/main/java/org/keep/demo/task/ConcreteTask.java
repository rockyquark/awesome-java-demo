package org.keep.demo.task;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note: TODO
 * @date 2023/12/10 14:30
 */
@Slf4j
public class ConcreteTask implements Callable<String> {

    private static final HttpClient client =  HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(3))
                .build();

    private final static List<String> imageUrlList = List.of(
            "https://cdn.pixabay.com/photo/2023/10/16/03/44/daughter-8318355_1280.jpg",
            "https://cdn.pixabay.com/photo/2023/12/08/23/46/cat-8438334_1280.jpg",
            "https://cdn.pixabay.com/photo/2023/10/16/10/57/fountain-8318963_1280.jpg",
            "https://cdn.pixabay.com/photo/2023/12/07/11/11/girl-8435340_1280.png",
            "https://cdn.pixabay.com/photo/2023/11/11/04/03/christmas-8380345_1280.png",
            "https://st2.depositphotos.com/5544578/8301/v/950/depositphotos_83018516-stock-illustration-8k-ultra-hd-sign.jpg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/3c16a961-5c90-4cc9-8f0c-3214b693527f/width=1440/91.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/f2ffa927-c66d-4eac-a224-e42bc5b4c355/width=1024/09717-3300056387-glossy%20bimbo,_((Masterpiece,%20best%20quality)),%20ballgown,edgPreppy,%20a%20woman%20in%20a%20([set%20of%20edgPreppy%20clothes,blazer_ballgown,ribbons.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/4724a136-cde6-4608-951d-2a9574eb1cd1/width=896/3DNA231203231203202134_An%20anime%20scene%20of%20a%20forest%20guardian%20ancient%20tree%20ani_00167_.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/fc0bf17c-5554-4eb8-b27e-a7fed778a4f7/width=1024/09744-1678181625-((Masterpiece,%20best%20quality,edgQuality))smiling,excited,solo,1girl,((turtleneck))_edgEF,%20a%20((santa%20claus%20cosplay))%20with%20a%20cape%20a.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/b09ce2ad-a4a7-4385-9d85-b0b29f9189df/width=768/00030-1421507747.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/44ef865b-3dff-4a05-8f0e-ca6ac62a9b79/width=1440/00053-2960040487.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/3a988d17-5c2e-4d82-b4f7-fb9d40214a43/width=1024/img2img-0002-2873497517.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/b89074d9-63db-40ea-b7e6-9395d17968d2/width=1440/00234-95901227.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/312bdf34-3768-4ce8-9dcd-d1ccc08b3cc4/width=1440/00034-2457432829.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/637f1a5f-5fa0-4eb6-af64-f272359c1a0e/width=1024/09731-1953826564-((Masterpiece,%20best%20quality,edgQuality)),smiling,excited,%201girl,solo,standing,posing_a%20woman%20in%20a%20colorful%20dress%20with%20feathers%20,.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/7c06af1a-dbbd-4d03-8d8f-9ab810b18dd5/width=1440/Masyunya_2k.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/85beafbd-55d2-42e7-9de7-9a5b25127c2c/width=1440/00078-3661836696.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/549164de-8722-43fd-9c90-60557e7a94cd/width=768/00049-3840257194-aniverse_v15Pruned.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/be821567-8b07-4689-9dc1-981d7fcc5b37/width=1024/00607-2799196394-20231203201633.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/359cd45c-0add-46c9-ae68-0554d8db0efd/width=768/00051-3516460946-AniHello2d_21.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/e51188a4-e04a-4054-a7e4-cebd1faad5a5/width=1024/00578-3525219380-20231203192437.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/8739ce12-77bb-4724-b6ea-3185abc4f729/width=681/09741-2955170258-((Masterpiece,%20best%20quality,edgQuality))smiling,excited,solo,1girl,(((turtleneck)))_edgEF,%20a%20((santa%20claus%20cosplay))%20with%20a%20cape.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/7e60b4e9-c6a6-452e-912b-a684b6a8b75b/width=576/07578-3930711171.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/88b4df68-e0c0-4fb1-846c-5c74c2a94479/width=1024/00048-1905583349.jpeg",
            "https://image.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/ca93cfdd-0b9e-44ee-be90-c8baf137d85e/width=1024/00158-604131504.jpeg"
    );


    private void submit() {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        imageUrlList.forEach(imageUrl -> {

            try {
                downloadAsFile(atomicInteger, imageUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long start = System.currentTimeMillis();
        while (true) {
            if (atomicInteger.get() == 0) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        log.info("全部下载完成, 耗时={}毫秒", end - start);


    }


    @SneakyThrows
    private CompletableFuture<Path> downloadAsFile(AtomicInteger atomicInteger, String imageUrl) {

        Path dir = Paths.get("D:/images", Thread.currentThread().getName());
        if (!dir.toFile().exists()) {
            boolean mkdirs = dir.toFile().mkdirs();
            log.info("创建文件夹状态：{}", mkdirs);
        }

        try {
            URI uri = new URI(imageUrl);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                    .timeout(Duration.ofSeconds(10))
                    .GET()
                    .build();
            String filename = DigestUtils.md5DigestAsHex(imageUrl.getBytes(StandardCharsets.UTF_8)) + ".jpeg";

            CompletableFuture<HttpResponse<Path>> future
                    = client.sendAsync(request, HttpResponse.BodyHandlers.ofFile(dir.resolve(filename)));
            atomicInteger.incrementAndGet();
            return future.thenApply(new Function<HttpResponse<Path>, Path>() {
                @Override
                public Path apply(HttpResponse<Path> pathHttpResponse) {
                    int statusCode = pathHttpResponse.statusCode();
                    Map<String, List<String>> map = pathHttpResponse.headers().map();
                    log.info("下载状态🐎:{}, 线程名称：{}， 线程组名称：{}，线程组活跃线程数量：{}， 线程组父母：{}，响应头：{}",
                            statusCode,
                            Thread.currentThread().getName(),
                            Thread.currentThread().getThreadGroup().getName(),
                            Thread.currentThread().getThreadGroup().activeCount(),
                            Thread.currentThread().getThreadGroup().getParent(),
                            map
                    );
                    atomicInteger.decrementAndGet();
                    return pathHttpResponse.body();
                }
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String call() throws Exception {
        submit();
        return "Success";
    }
}
