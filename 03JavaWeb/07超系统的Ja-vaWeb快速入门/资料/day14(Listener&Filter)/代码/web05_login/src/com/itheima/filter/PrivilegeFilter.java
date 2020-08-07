package com.itheima.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.itheima.domain.User;

/**
 * 权限验证的过滤器
 * @author jt
 *
 */
public class PrivilegeFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 判断：判断用户是否已经登录了。如果已经登录，放行。如果没有登录，回到登录页面！
		HttpServletRequest req = (HttpServletRequest) request;
		User existUser = (User) req.getSession().getAttribute("existUser");
		// 判断:
		if(existUser == null){
			// 没有登录:
			req.setAttribute("msg", "您还没有登录！没有权限访问！");
			req.getRequestDispatcher("/login.jsp").forward(req, response);
		}else{
			// 已经登录:
			chain.doFilter(req, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}
