package org.keep.demo.etd;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note TODO
 * @date 2024/1/19 0:00
 */
@Getter
@AllArgsConstructor
public enum TaskStepEnum implements ITaskStep {

    UPLOAD_FILE_HANDLE(1, 1, "上传文件消息任务", "上传文件消息处理"),

    AUDIO_CHECK_DECRYPT_DECODE(2, 1, "音频检测任务", "解密解压处理"),

    AUDIO_CHECK_TRANSCODE(2, 2, "音频检测任务", "16K转码处理"),

    AUDIO_CHECK_GENERATE_FLAC(2, 3, "音频检测任务", "生成备份文件处理"),

    AUDIO_CHECK_AUDIO_PADDING(2, 4, "音频检测任务", "音频时长补齐处理"),

    AUDIO_CHECK_UPLOAD_FILE(2, 5, "音频检测任务", "上传音频文件处理"),

    RECOGNISE_DOWNLOAD_MERGE_AUDIO(3, 1, "预识别任务", "下载合并音频文件"),

    RECOGNISE_SPEECH_TO_TEXT(3, 2, "预识别任务", "语音转文字处理"),

    RECOGNISE_RESULT_HANDLE(3, 3, "预识别任务", "识别记录处理"),

    ;

    /**
     * 任务代码
     */
    private final int taskCode;

    /**
     * 步骤代码
     */
    private final int stepCode;

    /**
     * 任务名称
     */
    private final String taskName;

    /**
     * 步骤名称
     */
    private final String stepName;
}
