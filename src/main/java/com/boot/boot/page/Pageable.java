package com.boot.boot.page;

/**
   功能说明：      分页请求抽象接口
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.Pageable.java
 @date  2016年12月10日
 */

public interface Pageable {
	/**
	 * 获取查询记录条数
	 * 
	 * @return
	 */
	int getRows();

	/**
	 * 设置查询记录条数
	 * 
	 * @param rows 查询条数
	 */
	void setRows(int rows);

	/**
	 * 获取当前页码
	 * 
	 * @return
	 */
	int getPage();

	/**
	 * 设置当前页码
	 * 
	 * @param curPage 当前页码
	 */
	void setPage(int curPage);
}
