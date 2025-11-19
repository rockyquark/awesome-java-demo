package org.keep.demo.service.repetition;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RepetitionCheckContextTest {

    @Resource
    private RepetitionCheckContext repetitionCheckContext;

    @Test
    void printStrategyInstance() {

        repetitionCheckContext.printStrategyInstance();
    }
}