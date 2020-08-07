package com.itheima.servlet.demo1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Servlet的生命周期
 * @author jt
 *
 */
public class ServletDemo1 implements Servlet{

	@Override
	/**
	 * Servlet对象被实例化的时候init方法就会执行，而且只执行一次。（Servlet是单例的）
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletDemo1初始化了......");
	}
	@Override
	/**
	 * service方法:任何一次请求都会执行service方法。可以执行多次。
	 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("ServletDemo1执行了......");
	}
	@Override
	/**
	 * Servlet从服务器中移除或者服务器关闭的时候销毁Servlet。执行一次。
	 */
	public void destroy() {
		System.out.println("ServletDemo1被销毁了.......");
	}
	
	
	
	
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}



}
