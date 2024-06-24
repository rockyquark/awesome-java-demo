package org.keep.demo.etd;

import lombok.Getter;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 解密解压失败错误类型
 * @date 2024/1/22 22:03
 */
@Getter
public enum DecryptDecodeErrorEnum implements IErrorType {

    ZIP_NOT_EXISTS(1, "音频压缩包不存在"),

    DECRYPT_DECODE_FAILED(2, "解密解压失败"),

    MISSING_DECRYPT_DECODE_KEY(3, "缺少解密解压关键参数")
    ;

    private final int code;

    private final String reason;

    DecryptDecodeErrorEnum(int code, String reason) {
        this.code = code;
        this.reason = reason;
        ErrorManager.register(TaskStepEnum.AUDIO_CHECK_DECRYPT_DECODE, this);
    }
}
