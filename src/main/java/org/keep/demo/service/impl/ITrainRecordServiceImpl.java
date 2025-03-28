package org.keep.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.keep.demo.entity.secondary.TrainRecord;
import org.keep.demo.mapper.secondary.TrainRecordMapper;
import org.keep.demo.service.ITrainRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 成员服务实现类
 * @date 2025/03/28 10:18
 */
@Slf4j
@Service
public class ITrainRecordServiceImpl implements ITrainRecordService {

    private final TrainRecordMapper mapper;

    @Autowired
    public ITrainRecordServiceImpl(TrainRecordMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean add(TrainRecord trainRecord) {
        return mapper.insert(trainRecord) > 0;
    }
}
