package com.itheima.domain;

//json返回数据
public class JsonResult {

	private int type; // 0失败 1成功
	private String error;// 错误信息
	private Object content;// 用于封装对象

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
