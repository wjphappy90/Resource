package com.itheima.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts2对EL表达式的改变
 * EL表达式：
 * 		原来的搜索顺序：
 * 			page		request 		session			application
 * struts2框架通过对request进行包装，增强了getAttribute方法，把EL表达式的搜索范围改为：
 * 		page		request 	ValueStack		ActionContext	session			application
 * @author zhy
 *
 */
public class Demo3Action extends ActionSupport {
	
	private String name = "动作类中的name";

	/**
	 * @return
	 */
	public String demo3(){

		HttpServletRequest request = ServletActionContext.getRequest();
		//往请求域中存入一个name
		//request.setAttribute("name", "请求域中的name");
		//往会话域中存入一个name
		request.getSession().setAttribute("name", "会话域中的name");
		return SUCCESS;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
