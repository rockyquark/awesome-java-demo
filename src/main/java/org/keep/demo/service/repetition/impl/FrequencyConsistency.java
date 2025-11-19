package org.keep.demo.service.repetition.impl;
import lombok.extern.slf4j.Slf4j;
import org.keep.demo.service.repetition.IRepetitionCheckStrategy;
import org.keep.demo.service.repetition.RepetitionCheckType;
import org.springframework.stereotype.Service;


/**
 * 频率一致性检查
 */

@Slf4j
@Service
class FrequencyConsistency implements IRepetitionCheckStrategy {

    @Override
    public RepetitionCheckType getRepetitionCheckType() {
        return RepetitionCheckType.FREQUENCY_CONSISTENCY;
    }
}
