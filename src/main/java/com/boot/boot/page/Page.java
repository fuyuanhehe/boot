package com.boot.boot.page;

import java.util.List;

/**
   功能说明：     分页抽象接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.page.Page.java
 @date  2016年12月10日
 */

public interface Page<T> {
	/**
	 * 获取记录总条数
	 * 
	 * @return
	 */
	Long getTotalRows();

	/**
	 * 设置记录总条数
	 * 
	 * @param total
	 *            记录总条数
	 */
	void setTotalRows(Long total);

	/**
	 * 获取数据记录内容
	 * 
	 * @return
	 */
	List<T> getRecords();

	/**
	 * 设置数据记录内容
	 * 
	 * @param records
	 *            记录内容
	 */
	void setRecords(List<T> records);

	/**
	 * 获取分页总数
	 * 
	 * @return
	 */
	long getTotalPages();
}
