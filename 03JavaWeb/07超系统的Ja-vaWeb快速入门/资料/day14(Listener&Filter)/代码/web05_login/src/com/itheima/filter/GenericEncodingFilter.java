package com.itheima.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 通用的字符集编码过滤器
 * @author jt
 *
 */
public class GenericEncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 在过滤器中增强request对象，并将增强后的request对象传递给Servlet:
		HttpServletRequest req = (HttpServletRequest) request;
		// 增强req:
		MyHttpServletRequest myReq = new MyHttpServletRequest(req);
		chain.doFilter(myReq, response);
	}

	@Override
	public void destroy() {
		
	}

}
