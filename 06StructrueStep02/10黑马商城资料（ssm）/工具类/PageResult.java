package com.itheima.shop.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 描述:黑马商城-分页实体
 * @author zhuan
 * @version 2018年2月17日 下午7:13:17
 */
public class PageResult implements Serializable{
	private static final long serialVersionUID = 2766366427300071157L;
	private long total; // 总记录数
	private long pageNo = 1; //当前页码
	private long totalPage; //总页数
	private long pageSize = 10; //每页条数
	private List<?> rows; // 返回每页的数据的集合
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getPageNo() {
		return pageNo;
	}
	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
