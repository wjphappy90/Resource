package com.itheima.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.Product;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callback=request.getParameter("callback");
		//处理响应数据的中文乱码
		response.setCharacterEncoding("utf-8");
		Product p1 = new Product();
		p1.setId(1);
		p1.setCount(100);
		p1.setName("电视机");
		p1.setPrice(2000);

		Product p2 = new Product();
		p2.setId(2);
		p2.setCount(200);
		p2.setName("洗衣机");
		p2.setPrice(1000);

		List<Product> list = new ArrayList<Product>();
		list.add(p1);
		list.add(p2);
		// 将其转换成json响应到浏览器
		String json = JSONObject.toJSONString(list);
		response.getWriter().write(callback+"("+json+")");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
