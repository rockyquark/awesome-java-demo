package org.keep.demo.service.repetition;


import java.util.List;

/**
 * @note 复诵检查策略入口
 */
public interface IRepetitionCheckStrategy {

    /**
     * @node 获取当前复诵检测策略类型
     */
    RepetitionCheckType getRepetitionCheckType();
}
