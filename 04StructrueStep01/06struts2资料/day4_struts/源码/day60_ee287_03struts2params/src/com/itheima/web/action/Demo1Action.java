package com.itheima.web.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 请求参数封装
 * 第一种情况：
 * 	  属性驱动：没有实体类
 * 	  表单数据的接收都定义在动作类中，所以称为动作类和模型数据写在一起
 * 要想封装成功，需要按照要求书写：
 * 	 要求是：表单元素的name属性取值，必须和动作类中成员get/set方法后面的部分保持一致
 * 
 * 细节：
 * 	  1、struts2框架会我们解决post请求的中文乱码问题，但是get请求不解决。
 * 	  2、struts2框架会自动为我们转换数据类型：
 * 			基本类型自动转换
 * 			字符串数组会按照逗号+空格的方式拼接成字符串
 * 			日期类型会按照本地格式转成日期对象
 * 				本地格式：yyyy-MM-dd
 * 	
 * 执行参数封装，是一个名称为params的拦截器实现的。
 * 封装的规则只有一个，它要去指定位置找属性，找到之后调用set方法赋值。			
 * 
 * @author zhy
 *
 */
public class Demo1Action extends ActionSupport {

	private String username;
	private Integer age;
	private Date birthday;
	private String hobby;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 动作方法
	 * @return
	 */
	public String demo1(){
		System.out.println(username+"==="+age+"==="+birthday+"==="+hobby);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
}
