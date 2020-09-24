package com.boot.boot.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


import net.sf.json.JSONArray;


/**
   功能说明：     常用工具类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.helper.ObjectHelper.java
 @date  2016年11月30日
 */

public class ObjectHelper {

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 *            -参数对象
	 * @return boolean -true:表示对象为空;false:表示对象为非空 集合： Collection.isEmpty()
	 *         数组：判断数组每个元素，所有元素都为空，即判定数组为空
	 *         字符串：判断字符串等于"null"，或去除两端""字窜后返回String.isEmpty()的结果 其它类型返回 false
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).entrySet().isEmpty();
		}

		if (obj instanceof Collection) {
			return ((Collection<?>) obj).isEmpty();
		}

		if (obj instanceof String) {
			return ((String) obj).equalsIgnoreCase("null") | ((String) obj).trim().isEmpty();
		}

		if (obj instanceof StringBuffer) {
			return ((StringBuffer) obj).length() == 0;
		}

		if (obj.getClass().isArray()) {
			try {
				Object[] a = (Object[]) obj;

				boolean b = true;
				for (Object o : a) {
					b = b & ObjectHelper.isEmpty(o);

					if (!b)
						break;
				}

				return b;
			} catch (ClassCastException e) {
			}
		}

		return false;
	}

	/**
	 * 判断对象是否为非空
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * 将list转换成json 
	 * @param list
	 * @return
	 */
	public static String objectToJson(List<?> list) {
		JSONArray json = JSONArray.fromObject(list);
		String temp = json.toString();
		return temp;
	}

	/**
	 * 将set转换成json
	 * @param set
	 * @return
	 */
	public static String objectToJson(Set<?> set) {
		JSONArray json = JSONArray.fromObject(set);
		String temp = json.toString();
		return temp;
	}

	/**
	 * 将Map转换成json
	 * @param map
	 * @return
	 */
	public static String objectToJson(Map<?, ?> map) {
		JSONArray json = JSONArray.fromObject(map);
		String res = "";
		res = json.get(0).toString();
		return res;
	}

	/**
	 * 将对象转换成json
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj) {
		JSONArray json = JSONArray.fromObject(obj);
		String res = "";
		if (json.size() != 0) {
			res = json.get(0).toString();
		}
		return res;
	}
	
	
}
