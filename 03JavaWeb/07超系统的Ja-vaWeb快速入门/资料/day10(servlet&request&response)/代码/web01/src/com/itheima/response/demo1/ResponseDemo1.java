package com.itheima.response.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置响应的状态码
 * * 使用状态码和Location头完成重定向
 * * 定时刷新
 */
public class ResponseDemo1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应的状态码：
		// response.setStatus(404);
		// 完成重定向
		// response.setStatus(302);
		// 设置响应头
		// response.setHeader("Location", "/web01/ResponseDemo2");
		
		// 定时刷新
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("5秒以后页面跳转!");
		response.setHeader("Refresh", "5;url=/web01/ResponseDemo2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
