package com.itheima.servlet.demo1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet的入门程序
 * @author jt
 *
 */
public class HelloServlet implements Servlet{
	@Override
	/**
	 * 用来处理客户的请求，并且对请求作出响应的方法
	 */
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// 向页面输出一个HelloServlet字符串:
		resp.getWriter().println("Hello Servlet...");
	}
	
	
	
	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
	}



}
