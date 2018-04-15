package com.ljc.analysis.dao.factory;

import com.ljc.analysis.dao.ITaskDAO;
import com.ljc.analysis.dao.impl.TaskDAOImpl;

/**
 * DAO工厂类
 */
public class DAOFactory {
	// 获取TaskDao实例
	public static ITaskDAO getTaskDAO() {
		return new TaskDAOImpl();
	}
}
