package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面跳转的测试的Servlet
 */
public class ServletDemo2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.请求转发的方式：
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/demo3/demo1.jsp");
		dispatcher.forward(request, response);*/
		// 向request域保存数据:
		request.setAttribute("name", "张三");
		
//		request.getRequestDispatcher("/demo3/demo1.jsp").forward(request, response);
		
		// 2.重定向的方式
		response.sendRedirect("/web02/demo3/demo1.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
