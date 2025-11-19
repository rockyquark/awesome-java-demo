package org.keep.demo.service.repetition;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 飞行复诵检查类型枚举
 */
@Getter
@AllArgsConstructor
public enum RepetitionCheckType {

    /** 跑道外检查 - 检查飞机是否在指定跑道外完成所有准备工作 */
    RUNWAY_EXTERIOR_CHECK("跑道外检查"),
    
    /** 频率一致性检查 - 确认飞行员复诵的频率与管制员指令一致 */
    FREQUENCY_CONSISTENCY("频率一致性"),
    
    /** 修正海压一致性检查 - 确认飞行员复诵的QNH/QFE值与管制员指令一致 */
    ALTIMETER_SETTING_CONSISTENCY("修正海压一致性"),
    
    /** 滑行路径一致性检查 - 确认飞行员复诵的滑行路线与管制员指令一致 */
    TAXI_ROUTE_CONSISTENCY("滑行路径一致性"),
    
    /** 高度一致性检查 - 确认飞行员复诵的高度指令与管制员指令一致 */
    ALTITUDE_CONSISTENCY("高度一致性");

    private final String type;
}