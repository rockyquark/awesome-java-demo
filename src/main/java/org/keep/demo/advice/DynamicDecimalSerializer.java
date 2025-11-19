package org.keep.demo.advice;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.keep.demo.annotation.DynamicDecimalFormat;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class DynamicDecimalSerializer extends JsonSerializer<Number> implements ContextualSerializer {

    private final int scale;
    private final RoundingMode roundingMode;
    private final boolean writeAsString;

    // 默认构造器使用默认值
    public DynamicDecimalSerializer() {
        this(2, RoundingMode.HALF_UP, true);
    }

    public DynamicDecimalSerializer(int scale, RoundingMode roundingMode) {
        this(scale, roundingMode, true);
    }

    public DynamicDecimalSerializer(int scale, RoundingMode roundingMode, boolean writeAsString) {
        this.scale = scale;
        this.roundingMode = Objects.requireNonNull(roundingMode);
        this.writeAsString = writeAsString;
    }

    @Override
    public void serialize(Number value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }

        BigDecimal decimal = convertNumberToBigDecimal(value);

        if (writeAsString) {
            gen.writeString(decimal.toString());
        } else {
            gen.writeNumber(decimal);
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider provider,
                                              com.fasterxml.jackson.databind.BeanProperty property) {
        if (property == null) {
            return this;
        }

        DynamicDecimalFormat ann = property.getAnnotation(DynamicDecimalFormat.class);
        if (ann != null) {
            return new DynamicDecimalSerializer(
                    ann.scale(),
                    ann.roundingMode(),
                    ann.writeAsString()
            );
        }
        return this;
    }

    private BigDecimal convertNumberToBigDecimal(Number number) {
        BigDecimal decimal = (number instanceof BigDecimal)
                ? (BigDecimal) number
                : new BigDecimal(number.toString());

        try {
            return decimal.setScale(scale, roundingMode);
        } catch (ArithmeticException e) {
            // 对于无法精确表示的数字，使用更大的精度再舍入
            return decimal.setScale(scale + 2, roundingMode)
                    .setScale(scale, roundingMode);
        }
    }
}