package com.itheima.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 判断用户是否登录，只需要判断session中是否有user
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			// 登录
			chain.doFilter(request, response);
		} else {
			// 未登录
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
