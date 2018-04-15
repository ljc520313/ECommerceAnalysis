package com.ljc.analysis.dao;

import com.ljc.analysis.vo.Task;

/**
 * 任务dao
 */
public interface ITaskDAO {
	
	/**
	 * 根据主键查询任务
	 * @param taskid 主键
	 * @return 任务
	 */
	Task findById(long taskid);
}
