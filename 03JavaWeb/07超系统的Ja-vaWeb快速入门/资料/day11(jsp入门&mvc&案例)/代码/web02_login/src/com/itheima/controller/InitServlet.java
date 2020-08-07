package com.itheima.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 初始化的Servlet
 * * 将这个Servlet配置成启动时加载
 */
public class InitServlet extends HttpServlet {
	@Override
	/**
	 * 初始化的方法:
	 */
	public void init() throws ServletException {
		// 初始一个值为0。
		int count = 0;
		// 将这个值存入到ServletContext域中。
		this.getServletContext().setAttribute("count", count);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
