package org.keep.demo;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.keep.demo.etd.AudioTranscodeErrorEnum;
import org.keep.demo.etd.ErrorManager;
import org.keep.demo.etd.IErrorType;
import org.keep.demo.etd.ITaskStep;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 子列表测试
 * @date 2023/12/26 22:20
 */
@Slf4j
@SpringBootTest
public class SubListTest {

    @Test
    public void test4() {
        System.out.println(ErrorManager.getAllError());
    }

    public static final int MAX_BATCH_SIZE = 3;

    public int batch1(List<String> stringList) throws InterruptedException {

        int raws = 0;
        while (stringList.size() > MAX_BATCH_SIZE) {
            List<String> subList = stringList.subList(0, MAX_BATCH_SIZE);
            log.info("subList={}", JSON.toJSONString(subList));
            raws += subList.size();
            subList.clear();
        }
        raws += stringList.size();
        return raws;
    }

    public int batch2(List<String> stringList) throws InterruptedException {

        int size = stringList.size();
        int rows = 0;
        if (size > MAX_BATCH_SIZE) {

            for (int index = 0; index < stringList.size(); index += MAX_BATCH_SIZE) {
                int lastIndex = index + MAX_BATCH_SIZE;
                if (lastIndex > size) {
                    lastIndex = size;
                }
                List<String> subList = stringList.subList(index, lastIndex);
                log.info("index={}, lastIndex={}, subList={}", index, lastIndex, JSON.toJSONString(subList));
                rows += subList.size();
            }
            return rows;
        }

        return size;
    }


    @Test
    public void test2() throws InterruptedException {
        int fullCode = AudioTranscodeErrorEnum.AUDIO_16K_TRANSCODE_FAILED.getFullCode();
        int code = AudioTranscodeErrorEnum.AUDIO_16K_TRANSCODE_FAILED.getCode();
        String reason = AudioTranscodeErrorEnum.AUDIO_16K_TRANSCODE_FAILED.getReason();
        ITaskStep taskStep = AudioTranscodeErrorEnum.AUDIO_16K_TRANSCODE_FAILED.getTaskStep();
        System.out.println(fullCode);
        System.out.println(code);
        System.out.println(reason);
        System.out.println(taskStep);
    }

    @Test
    public void test() throws InterruptedException {
        List<String> stringList = List.of(
                "0", "1", "2", "3", "4", "5", "9", "10"
        );
        stringList = new ArrayList<>(stringList);
//        List<String> strings = stringList.subList(3, 5);
//        System.out.println(strings);
        List<String> subList = stringList.subList(4, 6);
        System.out.println(subList);

        System.out.println(stringList);
        int batch = batch2(stringList);
        System.out.println(batch);
    }
}
