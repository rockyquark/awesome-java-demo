package org.keep.demo.service;

import org.keep.demo.entity.primary.DatasourceConfig;
import org.keep.demo.entity.secondary.TrainRecord;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note: 数据源配置服务
 * @date 2023/11/22 21:17
 */
public interface IDatasourceConfigService {

    /**
     * 添加记录
     * @param datasourceConfig 数据源配置记录对象
     * @return 如果添加成果则返回 {@code true} 反之返回 {@code false}
     */
    boolean add(DatasourceConfig datasourceConfig);
}
