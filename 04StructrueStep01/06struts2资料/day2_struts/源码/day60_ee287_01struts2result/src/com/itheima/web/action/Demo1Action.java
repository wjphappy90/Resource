package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 一个动作类
 * @author zhy
 *
 */
public class Demo1Action extends ActionSupport {

	/**
	 * 动作方法
	 * @return
	 */
	public String demo1(){
		System.out.println("Demo1Action中的demo1方法执行了");
		return LOGIN;
	}
}
