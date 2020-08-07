package com.itheima.order.vo;

public class Ordertable {
	Integer id;
	Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Ordertable{" +
				"id=" + id +
				", status=" + status +
				'}';
	}
}
