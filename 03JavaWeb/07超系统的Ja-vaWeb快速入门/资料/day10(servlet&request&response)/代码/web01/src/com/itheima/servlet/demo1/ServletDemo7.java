package com.itheima.servlet.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext的域对象的演示
 */
public class ServletDemo7 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 当ServletDemo7被创建，初始化一个值。
		this.getServletContext().setAttribute("name", "张三");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) this.getServletContext().getAttribute("name");
		System.out.println("姓名："+name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
