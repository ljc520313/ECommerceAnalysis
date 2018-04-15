package com.ljc.analysis.constant;

/**
 * 常量配置
 */
public class Constants {
	/*
	 * 项目配置
	 */
	// 项目名称
	public static final String PROJECT_NAME = "ECommerceAnalysis";
	
	/*
	 *数据库配置 
	 */
	// 驱动
	public static final String MYSQL_JDBC_DRIVER = "mysql.jdbc.driver";
	// 连接池
	public static final String JDBC_CONNECTIONPOOL_SIZE = "jdbc.connetion.pool.size";
	// mysql配置
	public static final String JDBC_LOCAL_URL = "jdbc.local.url";
	public static final String JDBC_LOCAL_USER = "jdbc.local.user";
	public static final String JDBC_LOCAL_PASSWORD = "jdbc.local.password";
	// hive配置
	public static final String JDBC_CLUSTER_URL = "jdbc.cluster.url";
	public static final String JDBC_CLUSTER_USER = "jdbc.cluster.user";
	public static final String JDBC_CLUSTER_PASSWORD = "jdbc.cluster.password";
	
	/*
	 * 任务管理平台相关的
	 */
	public static final String PARAM_START_TIME = "startTime";
	public static final String PARAM_END_TIME = "endTime";
	
	
	/*
	 * Spark作业相关的
	 */
	public static final String FIELD_SESSION_ID = "sessionid";
	public static final String FIELD_SEARCH_KEYWORDS = "searchKeywords";
	public static final String FIELD_CLICK_CATEGORY_IDS = "clickCategoryIds";
	
	public static final String FIELD_AGE = "age";
	public static final String FIELD_PROFESSIONAL = "professional";
	public static final String FIELD_CITY = "city";
	public static final String FIELD_SEX = "sex";
}
