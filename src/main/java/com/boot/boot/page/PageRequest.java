package com.boot.boot.page;

import java.io.Serializable;

/**
   功能说明：     分页请求抽象接口实现类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.page.PageRequest.java
 @date  2016年12月10日
 */

public class PageRequest implements Pageable, Serializable {
	private static final long serialVersionUID = -5148825081763736397L;
	// 默认每页数据条数
	protected static final Integer DEFAULT_PAGE_SIZE = 10;
	// 默认当前页码
	protected static final Integer DEFAULT_PAGE_NUMBER = 1;

	// 每页显示数据条数
	private Integer rows = new Integer(DEFAULT_PAGE_SIZE);
	private Integer page = new Integer(DEFAULT_PAGE_NUMBER);

	public PageRequest() {
	}

	public PageRequest(Integer page, Integer rows) {
		setPage(page);
		setRows(rows);
	}

	public PageRequest(Integer page) {
		setPage(page);
	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public int getPage() {
		return page;
	}

	@Override
	public void setPage(int curPage) {
		this.page = (curPage <= 0) ? DEFAULT_PAGE_NUMBER : curPage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageRequest [rows=" + rows + ", page=" + page + "]";
	}

}
