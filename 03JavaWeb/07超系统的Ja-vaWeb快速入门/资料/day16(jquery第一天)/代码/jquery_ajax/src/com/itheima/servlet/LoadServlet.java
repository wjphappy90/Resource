package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 1.得到用户名
		String username = request.getParameter("username");

		// 2.判断用户名是否可以使用
		if ("tom".equals(username)) {
			// 用户名不可以使用
			response.getWriter().write("<font color='red'>用户名被占用</font>");
		} else {
			// 用户名可以使用

			response.getWriter().write("<font color='green'>用户名可以使用</font>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
