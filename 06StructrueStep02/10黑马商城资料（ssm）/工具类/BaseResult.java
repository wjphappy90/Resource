package com.itheima.shop.utils;
public class BaseResult {
	
	private String status = "FAIL"; //状态 "OK":请求成功 "FAIL":请求失败
	private String msg; //返回信息
	private boolean success = false; //是否成功
	
	
	public BaseResult() {
		super();
	}
	public BaseResult(String status, String msg, boolean success) {
		super();
		this.status = status;
		this.msg = msg;
		this.success = success;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}

