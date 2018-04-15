package com.ljc.analysis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 参数工具类
 */
public class ParamUtils {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(ParamUtils.class);

	/**
	 * 从命令行参数中提取任务id
	 */
	public static Long getTaskIdFromArgs(String[] args) {
		try {
			if(args != null && args.length > 0) {
				return Long.valueOf(args[0]);
			}
		} catch (Exception e) {
			logger.error("",e);
		}
		return null;
	}
	
	/**
	 * 从JSON对象中提取参数
	 */
	public static String getParam(JSONObject jsonObject, String field) {
		JSONArray jsonArray = jsonObject.getJSONArray(field);
		if(jsonArray != null && jsonArray.size() > 0) {
			return jsonArray.getString(0);
		}
		return null;
	}
}
