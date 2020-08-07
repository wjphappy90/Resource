package com.itheima.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 访问ServletAPI:
 * 	有两种方式：
 * 	第一种方式：
 * 		使用struts2框架提供的一个工具类，该类中包含了相应的静态方法，可以直接获取
 * 		工具类是：ServletActionContext
 * 		此种方式是我们实际开发中用的最多的方式
 * 
 * 输出结果之后，找出其中一个和其他三个不一样：
 * 		org.apache.struts2.dispatcher.StrutsRequestWrapper@1c6e453		它和其他三个不一样，它是struts2提供的
		org.apache.catalina.connector.ResponseFacade@b846ae		
		org.apache.catalina.core.ApplicationContextFacade@287809
		org.apache.catalina.session.StandardSessionFacade@e0d480
 * @author zhy
 *
 */
public class Demo1Action extends ActionSupport {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext application;
	
	/**
	 * 动作方法
	 * @return
	 */
	public String demo1(){
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		application = ServletActionContext.getServletContext();
		session = request.getSession();
		
		System.out.println(request);
		System.out.println(response);
		System.out.println(application);
		System.out.println(session);
		return SUCCESS;
	}
}
