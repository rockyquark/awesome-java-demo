package org.keep.demo.service.repetition.impl;

import lombok.extern.slf4j.Slf4j;
import org.keep.demo.service.repetition.IRepetitionCheckStrategy;
import org.keep.demo.service.repetition.RepetitionCheckType;
import org.springframework.stereotype.Service;


@Slf4j
@Service
class RunWayExteriorCheck implements IRepetitionCheckStrategy {

    @Override
    public RepetitionCheckType getRepetitionCheckType() {
        return RepetitionCheckType.RUNWAY_EXTERIOR_CHECK;
    }
}
