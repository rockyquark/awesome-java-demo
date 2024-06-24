package org.keep.demo;

import org.junit.jupiter.api.Test;
import org.keep.demo.etd.IErrorType;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class InterfaceImplementationsFinder {

    @Test
    public void durationCompare() {
            // 定义第一对时间范围：[start1, end1]
            double start1 = 2;
            double end1 = 3;

            // 定义第二对时间范围：[start2, end2]
            double start2 = 2.3;
            double end2 = 2.8;

            // 计算重叠部分的开始时间和结束时间
            double overlapStart = Math.max(start1, start2);
            double overlapEnd = Math.min(end1, end2);

            // 计算重叠部分的时长
            double overlapDuration = Math.max(0, overlapEnd - overlapStart);

            // 计算第一对时间范围的总 时长
            double duration1 = end1 - start1;

            // 计算第二对时间范围的总时长
            double duration2 = end2 - start2;

            // 计算重叠部分时长占总时长的比例
            double overlapRatio1 = overlapDuration / duration1;
            double overlapRatio2 = overlapDuration / duration2;

            System.out.println("第一对时间范围重复比例：" + overlapRatio1);
            System.out.println("第二对时间范围重复比例：" + overlapRatio2);
    }
}
