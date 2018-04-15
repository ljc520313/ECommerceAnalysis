package com.ljc.analysis.vo;

import java.io.Serializable;

/**
 * 任务vo
 */
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	// 任务id
	private long taskid;
	// 任务名称
	private String taskName;
	// 创建时间
	private String createTime;
	// 任务开始时间
	private String startTime;
	// 任务完成时间
	private String endTime;
	// 任务类型
	private String taskType;
	// 任务状态
	private String taskStatus;
	// 任务参数
	private String taskParam;

	public long getTaskid() {
		return taskid;
	}

	public void setTaskid(long taskid) {
		this.taskid = taskid;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskParam() {
		return taskParam;
	}

	public void setTaskParam(String taskParam) {
		this.taskParam = taskParam;
	}

}
