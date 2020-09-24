package com.boot.boot.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
   功能说明：  分页实现类
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.common.page.PageImpl.java
 @date  2016年12月10日
 */

public class PageImpl<T> implements Page<T>, Serializable {
	private static final long serialVersionUID = 9183342519697951451L;
	private final Pageable pageable;
	private List<T> records = new ArrayList<>();
	private Long total = 0l;

	public PageImpl(Pageable pageable) {
		if (pageable == null) {
			throw new IllegalArgumentException("pageable");
		}
		this.pageable = pageable;
	}

	@Override
	public Long getTotalRows() {
		return total;
	}

	@Override
	public void setTotalRows(Long total) {
		this.total = total;
	}

	@Override
	public List<T> getRecords() {
		return records;
	}

	@Override
	public void setRecords(List<T> records) {
		this.records = records;
	}

	@Override
	public long getTotalPages() {
		if (total % pageable.getRows() == 0)
			return total / pageable.getRows();
		return (total / pageable.getRows()) + 1;
	}
}
