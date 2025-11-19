package org.keep.demo.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.keep.demo.advice.DynamicDecimalSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.RoundingMode;

@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = DynamicDecimalSerializer.class)
public @interface DynamicDecimalFormat {

    int scale() default 2; // 默认保留2位小数

    RoundingMode roundingMode() default RoundingMode.HALF_UP; // 默认四舍五入

    boolean writeAsString() default true;
}