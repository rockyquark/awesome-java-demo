package org.keep.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.keep.demo.entity.primary.DatasourceConfig;
import org.keep.demo.mapper.primary.DatasourceConfigMapper;
import org.keep.demo.service.IDatasourceConfigService;
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
public class IDatasourceConfigServiceImpl implements IDatasourceConfigService {

    private final DatasourceConfigMapper datasourceConfigMapper;

    @Autowired
    public IDatasourceConfigServiceImpl(DatasourceConfigMapper datasourceConfigMapper) {
        this.datasourceConfigMapper = datasourceConfigMapper;
    }

    @Override
    public boolean add(DatasourceConfig datasourceConfig) {
        return datasourceConfigMapper.insert(datasourceConfig) > 0;
    }
}
