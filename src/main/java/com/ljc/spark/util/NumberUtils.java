package com.ljc.spark.util;

import java.math.BigDecimal;

/**
 * 数字格工具类
 */
public class NumberUtils {

	/**
	 * 格式化小数
	 */
	public static double formatDouble(double num, int scale) {
		BigDecimal bd = new BigDecimal(num);  
		return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
}
