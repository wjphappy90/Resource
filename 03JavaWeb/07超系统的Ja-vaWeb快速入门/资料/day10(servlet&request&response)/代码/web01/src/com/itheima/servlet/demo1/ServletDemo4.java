package com.itheima.servlet.demo1;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig对象的API的演示
 */
public class ServletDemo4 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获得初始化参数的API：
		// 获得ServletConfig对象:
		ServletConfig config = this.getServletConfig();
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		System.out.println(username+"    "+password);
		// 2.获得所有初始化参数的名称
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name+"    "+value);
		}
		// 3.获得Servlet的名称
		String servletName = config.getServletName();
		System.out.println(servletName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
