package com.itheima.web.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 演示OGNL表达式在html中的使用
 * @author zhy
 *
 */
public class DemoAction extends ActionSupport {
	
	private String name = "值栈中的一个name";
	
	private Date today = new Date();
	
	
	public Date getToday() {
		return today;
	}

	public String getName() {
		return name;
	}

	public String demo(){
		System.out.println("DemoAction的demo方法执行了");
		return SUCCESS;
	}
}
