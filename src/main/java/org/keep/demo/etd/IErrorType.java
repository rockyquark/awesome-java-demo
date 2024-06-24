package org.keep.demo.etd;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 错误码规范
 * @date 2024/1/19 23:11
 */
public interface IErrorType {

    /**
     * @note 最小粒度的代码
     * @return
     */
    int getCode();


    /**
     * 获取错误描述
     * @return
     */
    String getReason();


    /**
     * @note 获取拼接完整的错误码
     * @return
     */
    default int getFullCode() {
        return ErrorManager.getFullCode(this);
    }

    /**
     * @note 获取拼接完整的错误码
     * @return
     */
    default String getFullReason() {
        return ErrorManager.generateFullReason(this);
    }

    /**
     * @note 获取任务步骤
     * @return
     */
    default ITaskStep getTaskStep() {
        return ErrorManager.getTaskStep(this);
    }

}
