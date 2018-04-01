package com.ljc.spark.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置管理器
 */
public class ConfigurationManager {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(ConfigurationManager.class);
	// 配置
	private static Properties prop = new Properties();
	
	// 静态代码块，加载配置
	static {
		// 获取输入流
		InputStream in = ConfigurationManager.class.getClassLoader().getResourceAsStream("conf.properties"); 
		try {
			prop.load(in);
		} catch (IOException e) {
			logger.error("",e);
		}  
	}
	
	/**
	 * 根据key获取value
	 */
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	/**
	 * 获取整数类型的value
	 */
	public static Integer getInteger(String key) {
		String value = getProperty(key);
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			logger.error("",e);
		}
		return 0;
	}
	
	/**
	 * 获取布尔类型的value
	 */
	public static Boolean getBoolean(String key) {
		String value = getProperty(key);
		try {
			return Boolean.valueOf(value);
		} catch (Exception e) {
			logger.error("", e);
		}
		return false;
	}
	
	/**
	 * 获取Long类型的value
	 */
	public static Long getLong(String key) {
		String value = getProperty(key);
		try {
			return Long.valueOf(value);
		} catch (Exception e) {
			logger.error("",e);
		}
		return 0L;
	}
}
