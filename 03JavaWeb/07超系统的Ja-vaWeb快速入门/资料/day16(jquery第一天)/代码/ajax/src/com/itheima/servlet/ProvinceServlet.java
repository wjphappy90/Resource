package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.util.CityUtil;

/**
 * Servlet implementation class ProvinceServlet
 */
public class ProvinceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到省份信息
		String province = CityUtil.getProvince();
		
		//写回到浏览器
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(province);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
