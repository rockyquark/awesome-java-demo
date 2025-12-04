package org.keep.demo.etd.ws;

import com.alibaba.fastjson2.JSONObject;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public record AsrRequest(
        String filePath,
        String mode,
        String chunkSize,
        int chunkInterval,
        String hotwords
) {

    public List<Integer> chunkSizeList() {
        return Arrays.stream(chunkSize.split(","))
                .map(Integer::parseInt).toList();
    }

    public String fileName() {
        return Path.of(filePath).getFileName().toString();
    }

    public String format() {
        return filePath.endsWith(".wav") ? "pcm" : "pcm";
    }

    public JSONObject hotwordsJson() {
        JSONObject obj = new JSONObject();
        if (hotwords == null || hotwords.isBlank()) return obj;

        String[] items = hotwords.split(",");
        for (String item : items) {
            String[] kv = item.split(":");
            if (kv.length == 2) obj.put(kv[0], Integer.parseInt(kv[1]));
        }
        return obj;
    }
}
