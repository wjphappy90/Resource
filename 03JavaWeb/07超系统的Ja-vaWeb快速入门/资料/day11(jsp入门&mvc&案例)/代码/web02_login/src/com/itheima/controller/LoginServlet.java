package com.itheima.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.model.UserModel;

/**
 * 登录的Servlet的编写
 */
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			// 1.接收数据
			// 处理中文乱码
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// 2.封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			// 3.处理数据
			UserModel userModel = new UserModel();
			User existUser = userModel.login(user);
			// 4.页面跳转
			if(existUser == null){
				// 登录失败
				// 向request域中保存一个错误信息：
				request.setAttribute("msg", "用户名或密码错误！");
				// 使用请求转发进行页面跳转
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				// 登录成功
				// 记录登录成功的人数：
				// 将ServletContext中的值取出 +1
				int count = (int) this.getServletContext().getAttribute("count");
				// 进行了+1的操作
				count++;
				// 将+1后的值存回到ServletContext中去。
				this.getServletContext().setAttribute("count", count);
				// 重定向到成功页面
				response.sendRedirect("/web02_login/success.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
