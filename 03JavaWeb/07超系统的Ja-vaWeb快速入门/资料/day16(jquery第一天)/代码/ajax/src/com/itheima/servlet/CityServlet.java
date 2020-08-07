package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.util.CityUtil;

public class CityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决post请求方式乱码
		request.setCharacterEncoding("utf-8");

		// 1.得到省份名称
		String pname = request.getParameter("pname");

		// 2.根据名称得到对应的城市
		String citys = CityUtil.getCitys(pname);

		// 3.写回到浏览器
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(citys);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
