package com.itheima.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ActionContext的数据存取
 * @author zhy
 *
 */
public class Demo1Action extends ActionSupport {

	/**
	 * 通过ActionContext往ContextMap中存入数据
	 * 		contextMap    hello context map 
	 * 
	 * 往应用域中存入数据：用两种方式实现
	 * 		applicationMap		hello application map
	 * 		applicationAttr		hello application attr
	 * 
	 * 往会话域中存入数据：用两种方式
	 * @return
	 */
	public String demo1(){
		//1.获取ActionContext
		ActionContext context = ActionContext.getContext();//从当前线程上获取
		//2.存入数据
		context.put("contextMap", "hello context map");
		
		//3.往应用域中存入数据
		//第一种方式：使用原始ServletAPI对象ServletContext
		ServletContext applicationAttr = ServletActionContext.getServletContext();
		applicationAttr.setAttribute("applicationAttr", "hello application attr");
		
		//第二种方式：根据key从ActionContext中获取应用域的map，往map中存入数据
		Map<String,Object> applicationMap = context.getApplication();
		applicationMap.put("applicationMap","hello application map");
		
		//4.往会话域中存入数据
		//第一种：使用ServletAPI的HttpSession
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionAttr", "hello session attr");
		//第二种：获取key为session的map
		Map<String,Object> sessionMap = context.getSession();
		sessionMap.put("sessionMap","hello session map");
		return SUCCESS;
	}
}
