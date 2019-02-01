package com.cyb.blog.entity;

public class Pagenation {

	private int pageSize = 10;
	
	private long pageCount;
	
	private Object pageDatas;
	
	private int limit = 10;
	
	private int offset = 0;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize >= 50) {
			this.pageSize = 10;
		}else {
			this.pageSize = pageSize;
		}
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public Object getPageDatas() {
		return pageDatas;
	}

	public void setPageDatas(Object pageDatas) {
		this.pageDatas = pageDatas;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
