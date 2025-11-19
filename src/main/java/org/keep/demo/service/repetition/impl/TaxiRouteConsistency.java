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
public class TaxiRouteConsistency implements IRepetitionCheckStrategy {


    @Override
    public RepetitionCheckType getRepetitionCheckType() {
        return RepetitionCheckType.TAXI_ROUTE_CONSISTENCY;
    }
}
