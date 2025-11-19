package org.keep.demo.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.*;
import org.keep.demo.annotation.DynamicDecimalFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TestDto {

    @DynamicDecimalFormat(scale = 4)
    private Float editRatio;

    @DynamicDecimalFormat(scale = 6, roundingMode = RoundingMode.DOWN)
    private BigDecimal editDistance;

    public static void main(String[] args) throws JsonProcessingException {

        TestDto testDto = new TestDto();
        testDto.setEditDistance(new BigDecimal("1.023"));
        testDto.setEditRatio(0.12F);

        JsonMapper mapper = new JsonMapper();
        System.out.println(mapper.writeValueAsString(testDto));
    }
}
