package com.itheima.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Product {

	//@JSONField(name = "编号")
	private int id;
	private String name;
	private int count;
	private double price;
	//@JSONField(format="yyyy年MM月dd日")
	private Date pDate;// 生产日期

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
