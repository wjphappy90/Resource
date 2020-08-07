package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.BeanFactory;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("login".equals(method)) {
			// 登录操作
			login(request, response);
		}
		if ("shutdown".equals(method)) {
			shutdown(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void shutdown(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 销毁session
		request.getSession().invalidate();
	}

	// 登录操作
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.得到username,password
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2.验证username,password不为空
		// if(username==null||username.trim().equals("")){
		// //判断为空
		// }

		// 3.调用service完成登录操作
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/bean.xml");
		
		IUserService userService = (IUserService) BeanFactory.createBean("userService", path);
		User user = userService.login(username, password);

		// 4.判断是否登录成功
		if (user != null) {
			// 登录成功
			request.getSession().setAttribute("user", user);
			// 跳转路径
			response.sendRedirect(request.getContextPath() + "/views/home.jsp");
			return;
		} else {
			// 登录失败
			request.setAttribute("loginError", "登录失败");
			// 跳转路径
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

	}

}
