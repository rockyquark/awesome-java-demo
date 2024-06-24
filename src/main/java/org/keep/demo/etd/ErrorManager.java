package org.keep.demo.etd;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 错误管理入库
 * @date 2024/1/22 14:08
 */
//@Component
public class ErrorManager {

    private static final ConcurrentHashMap<IErrorType, ITaskStep> ERROR_TASK_STEP_MAP
            = new ConcurrentHashMap<>(100);

    private static final ConcurrentHashMap<IErrorType, Integer> GLOBAL_FULL_CODE_MAP
            = new ConcurrentHashMap<>(100);

    private static final ConcurrentHashMap<Integer, IErrorType> GLOBAL_ERROR_CODE_MAP
            = new ConcurrentHashMap<>(100);

    static {
        try {
            Class.forName("org.keep.demo.etd.DecryptDecodeErrorEnum");
            Class.forName("org.keep.demo.etd.AudioTranscodeErrorEnum");
        } catch (ClassNotFoundException ignore) {}
    }

    /**
     * @note 生成【任务代码 + 步骤代码 + 错误码】
     * @return 返回完整的错误码
     */
    public static ConcurrentHashMap<IErrorType, Integer> getAllError() {

        return GLOBAL_FULL_CODE_MAP;
    }

    public static ITaskStep getTaskStep(IErrorType errorType) {
        return ERROR_TASK_STEP_MAP.get(errorType);
    }

    /**
     * @note 生成详细的错误原因【任务代码 + 步骤代码 + 错误码】
     * @param errorType 错误类型
     * @return 返回完整的错误码
     */
    public static String generateFullReason(IErrorType errorType) {

        ITaskStep taskStep = errorType.getTaskStep();
        return "[" +
                taskStep.getTaskName() +
                "]" +
                "[" +
                taskStep.getStepName() +
                "]" +
                "[" +
                errorType.getReason() +
                "]";
    }

    /**
     * @note 生成【任务代码 + 步骤代码 + 错误码】
     * @param errorType 错误类型
     * @return 返回完整的错误码
     */
    public static int getFullCode(IErrorType errorType) {

        return GLOBAL_FULL_CODE_MAP.get(errorType);
    }

    /**
     * @note 生成完整的错误码
     * @param taskStep 任务步骤
     * @param errorType 错误类型枚举
     * @return 返回生成完整的错误码
     */
    private static int generateFullCode(ITaskStep taskStep, IErrorType errorType) {
        int[] taskCodeDigits = extractDigits(taskStep.getTaskCode());
        int[] errorCodes = extractDigits(taskStep.getStepCode());
        int[] codes = extractDigits(errorType.getCode());
        List<Integer> total = new ArrayList<>(taskCodeDigits.length + errorCodes.length);
        for (int digit: taskCodeDigits) {
            total.add(digit);
        }
        for (int code : errorCodes) {
            total.add(code);
        }
        for (int code : codes) {
            total.add(code);
        }

        return insertDigits(total);
    }


    public static void register(ITaskStep taskStep, IErrorType errorType) {

        Preconditions.checkNotNull(taskStep);
        Preconditions.checkArgument(taskStep.getTaskCode() > 0);
        Preconditions.checkArgument(taskStep.getStepCode() > 0);
        Preconditions.checkArgument(errorType.getCode() > 0);

        int code = generateFullCode(taskStep, errorType);
        Preconditions.checkArgument(
                !GLOBAL_ERROR_CODE_MAP.containsKey(code),
                "错误码重复:" + code
        );
        GLOBAL_ERROR_CODE_MAP.put(code, errorType);
        GLOBAL_FULL_CODE_MAP.put(errorType, code);
        ERROR_TASK_STEP_MAP.put(errorType, taskStep);
    }

    /**
     * @note 十进制数字按位提取
     * @param number 数字
     * @return
     */
    private static int[] extractDigits(int number) {

        if ( 0 <= number && number< 10) {
            return new int[]{number};
        }
        int numDigits = (int) Math.log10(number) + 1;
        int[] digits = new int[numDigits];

        for (int i = numDigits - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }


    /**
     * @note 十进制数字按位提取
     * @param digits 十进制位数字
     * @return 返回拼接好的十进制数
     */
    private static int insertDigits(List<Integer> digits) {

        int number = 0;
        for (Integer digit : digits) {
            number = number * 10 + digit;
        }
        return number;
    }
}
