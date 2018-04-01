package com.ljc.spark.util;

/**
 * 字符串工具类
 */
public class StringUtils {

	/**
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}
	
	/**
	 * 判断字符串是否不为空
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && !"".equals(str);
	}
	
	/**
	 * 去掉字符串两侧的逗号
	 */
	public static String trimComma(String str) {
		if(str.startsWith(",")) {
			str = str.substring(1);
		}
		if(str.endsWith(",")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	/**
	 * 补全两位数字
	 */
	public static String fullTwoDigits(String str) {
		if(str.length() == 2) {
			return str;
		} else {
			return "0" + str;
		}
	}
	
	/**
	 * 从拼接的字符串中提取字段
	 */
	public static String getFieldFromConcatString(String str, String delimiter, String field) {
		String[] fields = str.split(delimiter);
		for(String fd : fields) {
			// searchKeywords=|clickCategoryIds=1,2,3
			String[] fieldArr = fd.split("=");
			if(fieldArr.length == 2) {
				String fieldName = fieldArr[0];
				String fieldValue = fieldArr[1];
				if(fieldName.equals(field)) {
					return fieldValue;
				}
			}
		}
		return null;
	}
	
	/**
	 * 从拼接的字符串中给字段设置值
	 * @param str 字符串
	 * @param delimiter 分隔符 
	 * @param field 字段名
	 * @param newFieldValue 新的field值
	 * @return 字段值
	 */
	public static String setFieldInConcatString(String str, String delimiter, String field, String newFieldValue) {
		String[] fields = str.split(delimiter);
		
		for(int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].split("=")[0];
			if(fieldName.equals(field)) {
				String concatField = fieldName + "=" + newFieldValue;
				fields[i] = concatField;
				break;
			}
		}
		
		StringBuffer buffer = new StringBuffer("");
		for(int i = 0; i < fields.length; i++) {
			buffer.append(fields[i]);
			if(i < fields.length - 1) {
				buffer.append(delimiter);  
			}
		}
		
		return buffer.toString();
	}
	
}
