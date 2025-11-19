package org.keep.demo.service.repetition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class RepetitionCheckContext {

    /**
     * @note 对齐策略实现
     */
    private final Map<RepetitionCheckType, IRepetitionCheckStrategy> repetitionCheckTypeStrategyMap
            = new HashMap<>(RepetitionCheckType.values().length);

    @Autowired
    public RepetitionCheckContext(Map<String, IRepetitionCheckStrategy> repetitionCheckStrategyMap) {
        repetitionCheckStrategyMap.forEach((strategyName, repetitionCheckStrategy)
                -> repetitionCheckTypeStrategyMap.put(
                        repetitionCheckStrategy.getRepetitionCheckType(),
                repetitionCheckStrategy
        ));

    }

    public void printStrategyInstance() {

        repetitionCheckTypeStrategyMap.forEach(((repetitionCheckType, repetitionCheckStrategy) -> {
            System.out.println(repetitionCheckType);
            repetitionCheckStrategy.getRepetitionCheckType();
            System.out.println(repetitionCheckStrategy.getClass().getSimpleName());
        }));
    }

}


