package com.ljc.analysis.dao.impl;

import java.sql.ResultSet;

import com.ljc.analysis.dao.ITaskDAO;
import com.ljc.analysis.util.JDBCUtils;
import com.ljc.analysis.vo.Task;

/**
 * 任务管理DAO实现类
 */
public class TaskDAOImpl implements ITaskDAO {

	/**
	 * 根据主键查询任务
	 * @param taskid 主键
	 * @return 任务
	 */
	public Task findById(long taskid) {
		final Task task = new Task();
		
		String sql = "select * from task where task_id=?";
		Object[] params = new Object[]{taskid};
		
		JDBCUtils jdbcHelper = JDBCUtils.getInstance();
		jdbcHelper.executeQuery(sql, params, new JDBCUtils.QueryCallback() {
			
			@Override
			public void process(ResultSet rs) throws Exception {
				if(rs.next()) {
					long taskid = rs.getLong(1);
					String taskName = rs.getString(2);
					String createTime = rs.getString(3);
					String startTime = rs.getString(4);
					String finishTime = rs.getString(5);
					String taskType = rs.getString(6);
					String taskStatus = rs.getString(7);
					String taskParam = rs.getString(8);
					
					task.setTaskid(taskid);
					task.setTaskName(taskName); 
					task.setCreateTime(createTime); 
					task.setStartTime(startTime);
					task.setEndTime(finishTime);
					task.setTaskType(taskType);  
					task.setTaskStatus(taskStatus);
					task.setTaskParam(taskParam);  
				}
			}
			
		});
		
		return task;
	}
}
