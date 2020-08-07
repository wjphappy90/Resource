package com.itheima.request.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Request对象获得客户机信息
 */
public class RequestDemo1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得请求方式:
		System.out.println("请求方式:"+request.getMethod());
		// 获得客户机的IP地址:
		System.out.println("客户机IP地址:"+request.getRemoteAddr());
		// 获得请求参数的字符串
		System.out.println("请求参数的字符串:"+request.getQueryString());
		// 获得请求路径的URL和URI
		System.out.println("请求路径的URL:"+request.getRequestURL());
		System.out.println("请求路径的URI:"+request.getRequestURI());
		// 获得请求头的信息
		System.out.println("获得客户机浏览器类型:"+request.getHeader("User-Agent"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
