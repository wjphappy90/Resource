package com.itheima.domain;

import java.util.Date;

public class Product {

	private int id;
	private String proNum;
	private String proName;
	private int proLimit;
	private double annualized;
	private Date releaseDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProNum() {
		return proNum;
	}

	public void setProNum(String proNum) {
		this.proNum = proNum;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProLimit() {
		return proLimit;
	}

	public void setProLimit(int proLimit) {
		this.proLimit = proLimit;
	}

	public double getAnnualized() {
		return annualized;
	}

	public void setAnnualized(double annualized) {
		this.annualized = annualized;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
