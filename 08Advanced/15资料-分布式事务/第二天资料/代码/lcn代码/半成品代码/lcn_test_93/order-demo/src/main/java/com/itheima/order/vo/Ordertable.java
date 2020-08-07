package com.itheima.order.vo;

import java.io.Serializable;

public class Ordertable implements Serializable {
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
