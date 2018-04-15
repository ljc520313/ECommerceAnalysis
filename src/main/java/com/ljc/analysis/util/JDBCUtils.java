package com.ljc.analysis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ljc.analysis.conf.ConfigurationManager;
import com.ljc.analysis.constant.Constants;

/**
 * JDBC工具类
 */
public class JDBCUtils {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);
	// 实例
	private static JDBCUtils instance = new JDBCUtils();
	// 数据库连接池
	private LinkedList<Connection> connectionPool = new LinkedList<Connection>();
	
	static {
		try {
			// 加载驱动
			String driver = ConfigurationManager.getProperty(Constants.MYSQL_JDBC_DRIVER);
			Class.forName(driver);
		} catch (Exception e) {
			logger.error("",e);
		}
	}
	
	/**
	 * 获取单例
	 */
	public static JDBCUtils getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private JDBCUtils() {
		// 设置数据库连接池的大小
		int datasourceSize = ConfigurationManager.getInteger(Constants.JDBC_CONNECTIONPOOL_SIZE);
		
		// 创建指定数量的数据库连接，并放入数据库连接池中
		for(int i = 0; i < datasourceSize; i++) {
//			boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
			String url = null;
			String user = null;
			String password = null;
			
//			if(local) {
				url = ConfigurationManager.getProperty(Constants.JDBC_LOCAL_URL);
				user = ConfigurationManager.getProperty(Constants.JDBC_LOCAL_USER);
				password = ConfigurationManager.getProperty(Constants.JDBC_LOCAL_PASSWORD);
//			} else {
//				url = ConfigurationManager.getProperty(Constants.JDBC_CLUSTER_URL);
//				user = ConfigurationManager.getProperty(Constants.JDBC_CLUSTER_USER);
//				password = ConfigurationManager.getProperty(Constants.JDBC_CLUSTER_PASSWORD);
//			}
			
			try {
				Connection conn = DriverManager.getConnection(url, user, password);
				connectionPool.push(conn);  
			} catch (Exception e) {
				logger.error("",e);
			}
		}
	}
	
	/**
	 * 提供获取数据库连接的方法
	 */
	public synchronized Connection getConnection() {
		while(connectionPool.size() == 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				logger.error("",e);
			}  
		}
		return connectionPool.poll();
	}
	
	/**
	 * 增删改方法
	 */
	public int executeUpdate(String sql, Object[] params) {
		int rtn = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);  
			
			pstmt = conn.prepareStatement(sql);
			
			if(params != null && params.length > 0) {
				for(int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);  
				}
			}
			
			rtn = pstmt.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			logger.error("",e);
		} finally {
			if(conn != null) {
				connectionPool.push(conn);  
			}
		}
		
		return rtn;
	}
	
	/**
	 * 查询方法
	 */
	public void executeQuery(String sql, Object[] params, QueryCallback callback) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(params != null && params.length > 0) {
				for(int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);   
				}
			}
			
			rs = pstmt.executeQuery();
			
			callback.process(rs);  
		} catch (Exception e) {
			logger.error("",e);
		} finally {
			if(conn != null) {
				connectionPool.push(conn);  
			}
		}
	}
	
	/**
	 * 批量执行方法
	 */
	public int[] executeBatch(String sql, List<Object[]> paramsList) {
		int[] rtn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			// 取消自动提交
			conn.setAutoCommit(false);  
			
			pstmt = conn.prepareStatement(sql);
			
			// 设置参数
			if(paramsList != null && paramsList.size() > 0) {
				for(Object[] params : paramsList) {
					for(int i = 0; i < params.length; i++) {
						pstmt.setObject(i + 1, params[i]);  
					}
					pstmt.addBatch();
				}
			}
			
			// 执行批量语句
			rtn = pstmt.executeBatch();
			
			// 提交批量
			conn.commit();
		} catch (Exception e) {
			logger.error("",e);
		} finally {
			if(conn != null) {
				connectionPool.push(conn);  
			}
		}
		
		return rtn;
	}
	
	/**
	 * 静态内部类：查询回调接口
	 *
	 */
	public static interface QueryCallback {
		
		/**
		 * 处理查询结果
		 */
		void process(ResultSet rs) throws Exception;
	}
}
