package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.得到请求参数username
		String username = request.getParameter("username");

		// 2.判断用户名是tom，就代表用户名已经被占用,否则没有被占用
		String msg = "";
		if ("tom".equals(username)) {
			msg = "<font color='red'>用户名已经被占用</font>";
		} else {
			msg = "<font color='green'>用户名可以使用</font>";
		}
		// 3.通过response获取输出流写回到浏览器
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(msg);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
