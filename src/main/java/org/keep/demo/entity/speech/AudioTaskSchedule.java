package org.keep.demo.entity.speech;

import java.util.Date;
import lombok.*;

/**
 * @note cockpit-process-service 简称 cps 舱音入库处理，任务流程时间追踪记录表
 * @createdDate 2024/01/17
 */
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AudioTaskSchedule {
    /**
     * 追踪记录编号
     */
    private Integer id;

    /**
     * 入库编号
     */
    private Integer sfFileId;

    /**
     * 航段唯一编号
     */
    private String soflSeqNr;

    /**
     * 音频检测任务流程开始时间
     */
    private Date checkStartTime;

    /**
     * 音频检测任务流程结束时间
     */
    private Date checkEndTime;

    /**
     * 音频检测任务流程，音频解密解压开始时间
     */
    private Date checkDecryptDecodeStartTime;

    /**
     * 音频检测任务流程，音频解密解压结束时间
     */
    private Date checkDecryptDecodeEndTime;

    /**
     * 音频检测任务流程，16K 转码开始时间
     */
    private Date checkTranscodeStartTime;

    /**
     * 音频检测任务流程，16K转码结束时间
     */
    private Date checkTranscodeEndTime;

    /**
     * 音频检测任务流程，生成备份文件开始时间
     */
    private Date checkGenerateFlacStartTime;

    /**
     * 音频检测任务流程，生成备份音频结束时间
     */
    private Date checkGenerateFlacEndTime;

    /**
     * 音频检测任务流程，上传文件开始时间
     */
    private Date checkUploadStartTime;

    /**
     * 音频检测任务流程，上传文件结束时间
     */
    private Date checkUploadEndTime;

    /**
     * 预识别开始时间
     */
    private Date recogniseStartTime;

    /**
     * 预识别结束时间
     */
    private Date recogniseEndTime;

    /**
     * 分析入库开始时间
     */
    private Date analysisStorageStartTime;

    /**
     * 分析入库结束时间
     */
    private Date analysisStorageEndTime;

    /**
     * 分析入库任务流程，采样率压缩开始时间
     */
    private Date analysisSampleCompressStartTime;

    /**
     * 分析入库任务流程，分析采样率压缩结束时间
     */
    private Date analysisSampleCompressEndTime;

    /**
     * 分析入库任务流程，上传采样率压缩文件和10分钟片段音频文件的开始时间
     */
    private Date analysisUploadStartTime;

    /**
     * 分析入库任务流程，上传采样率压缩文件和10分钟片段音频文件的结束时间
     */
    private Date analysisUploadEndTime;

    /**
     * 分析入库任务流程，语义识别开始时间
     */
    private Date analysisRoleRecogniseStartTime;

    /**
     * 分析入库任务流程，语义识别结束时间
     */
    private Date analysisRoleRecogniseEndTime;

    /**
     * 对齐任务处理开始时间
     */
    private Date alignStartTime;

    /**
     * 对齐任务处理结束时间
     */
    private Date alignEndTime;

    /**
     * 标注入库任务开始时间
     */
    private Date labelStorageStartTime;

    /**
     * 标注入库任务结束时间
     */
    private Date labelStorageEndTime;

    /**
     * 追踪记录创建时间
     */
    private Date createdTime;

    /**
     * 追踪记录修改时间
     */
    private Date updatedTime;
}