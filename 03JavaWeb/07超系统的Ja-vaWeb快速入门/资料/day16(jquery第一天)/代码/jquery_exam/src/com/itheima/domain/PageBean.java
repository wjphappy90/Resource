package com.itheima.domain;

import java.util.List;

//主要封装分页的相关信息
public class PageBean<T> {

	private int pageNo; // 页码
	private int pageSize; // 每页显示条数
	private int totalPage; // 总页数
	private int totalCount; // 总条数
	private List<T> content; // 当前页显示的数据

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

}
