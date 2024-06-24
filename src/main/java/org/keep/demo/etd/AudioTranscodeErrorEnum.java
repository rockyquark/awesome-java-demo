package org.keep.demo.etd;

import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 音频转码错误类型
 * @date 2024/1/22 22:03
 */
@Getter
public enum AudioTranscodeErrorEnum implements IErrorType {

    AUDIO_G726_TRANSCODE_FAILED(1, "G726编解码器转码失败"),

    AUDIO_16K_TRANSCODE_FAILED(2, "16K转码失败"),

    MKDIR_FAILED(3, "创建文件夹失败"),

    ;

    private final int code;

    private final String reason;

    AudioTranscodeErrorEnum(int code, String reason) {
        this.code = code;
        this.reason = reason;
        ErrorManager.register(TaskStepEnum.AUDIO_CHECK_TRANSCODE, this);
    }
}
