package org.keep.demo.etd;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note 任务步骤信息提供者
 * @date 2024/1/18 23:52
 */
public interface ITaskStep {

    /**
     * @note 获取任务代号
     * @return 返回任务代号
     */
    int getTaskCode();


    /**
     * @note 获取任务执行步骤代号
     * @return 返回任务执行步骤代号
     */
    int getStepCode();


    /**
     * @note 获取任务名称
     * @return 返回任务名称
     */
    String getTaskName();

    /**
     * @note 获取任务执行步骤名称
     * @return 返回任务步骤名称
     */
    String getStepName();
}
