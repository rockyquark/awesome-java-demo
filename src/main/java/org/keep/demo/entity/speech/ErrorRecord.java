package org.keep.demo.entity.speech;

import java.util.Date;
import lombok.*;

/**
 * @note cockpit-process-service 简称 cps 舱音处理错误记录表，记录舱音入库任务每个处理流程的错误信息
 * @createdDate 2024/01/17
 */
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ErrorRecord {
    /**
     * 错误信息记录编号
     */
    private Integer id;

    /**
     * 舱音入库编号
     */
    private Integer sfFileId;

    /**
     * 航段唯一编号
     */
    private String soflSeqNr;

    /**
     * 错误流程位置，如音频解密解码流程...
     */
    private String errorLocation;

    /**
     * 错误代号
     */
    private Integer errorCode;

    /**
     * 错误摘要
     */
    private String errorSummary;

    /**
     * 错误信息记录创建日期
     */
    private Date createdDate;

    /**
     * 错误信息记录修改日期
     */
    private Date updatedDate;

    /**
     * 错误明细
     */
    private String errorDetail;
}