package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.PageBean;
import com.itheima.service.ProductService;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 处理响应数据中文乱码
		response.setCharacterEncoding("utf-8");

		// 接收请求参数pageNo pageSize
		int pageNo = Integer.parseInt(request.getParameter("pageNo")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页显示条数

		// 查询所有的产品，得到List<Product>对象，转换成json响应到浏览器
		ProductService service = new ProductService();
		try {
			PageBean pb = service.findAll(pageNo, pageSize);
			// 将ps转换成json响应到浏览器
			String json = JSONObject.toJSONString(pb);
			response.getWriter().write(json);

		} catch (SQLException e) {
			e.printStackTrace();
			// 向浏览器发送一条描述错误信息的json数据
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
