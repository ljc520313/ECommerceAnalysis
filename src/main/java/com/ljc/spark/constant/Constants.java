package com.ljc.spark.constant;

/**
 * 常量配置
 */
public interface Constants {
	/*
	 * 项目配置
	 */
	// 本地
	String SPARK_LOCAL = "spark.local";
	
	/*
	 *数据库配置 
	 */
	// 驱动
	String JDBC_DRIVER = "jdbc.driver";
	// 连接池
	String JDBC_CONNECTIONPOOL_SIZE = "jdbc.connetion.pool.size";
	// mysql配置
	String JDBC_LOCAL_URL = "jdbc.local.url";
	String JDBC_LOCAL_USER = "jdbc.local.user";
	String JDBC_LOCAL_PASSWORD = "jdbc.local.password";
	// hive配置
	String JDBC_CLUSTER_URL = "jdbc.cluster.url";
	String JDBC_CLUSTER_USER = "jdbc.cluster.user";
	String JDBC_CLUSTER_PASSWORD = "jdbc.cluster.password";
	
}
