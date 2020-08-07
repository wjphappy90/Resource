package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 动作类
 * @author zhy
 *
 */
public class Demo1Action extends ActionSupport {

	public String demo1(){
		System.out.println("Demo1Action中的demo1方法执行了。。。。");
		return SUCCESS;
	}
}
