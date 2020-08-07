package com.itheima.web.action;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 请求参数封装
 * 第二种情况：
 * 	  属性驱动：有实体类
 * 	  表单数据的接收都定义在实体类中，把实体类定义在动作类中。
 * 要想封装成功，需要按照要求书写：
 * 	 此时需要使用OGNL表达式来指定表单元素的name取值
 * 	OGNL表达式全称：Object Graphic Navigation Language
 * 				   对象	  图			导航		语言
 *  写法：
 *  	user.username  user.age
 * 	
 * 执行参数封装，是一个名称为params的拦截器实现的。
 * 封装的规则只有一个，它要去指定位置找属性，找到之后调用set方法赋值。			
 * 
 * @author zhy
 *
 */
public class Demo2Action extends ActionSupport {

	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * 动作方法
	 * @return
	 */
	public String demo2(){
		System.out.println(user);
		return SUCCESS;
	}
	
}
