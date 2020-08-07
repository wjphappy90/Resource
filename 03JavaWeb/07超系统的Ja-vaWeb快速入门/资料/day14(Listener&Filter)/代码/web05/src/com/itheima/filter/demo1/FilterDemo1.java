package com.itheima.filter.demo1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 过滤器的入门案例
 * @author jt
 *
 */
public class FilterDemo1 implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterDemo1被创建了...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo1执行了...");
		// 放行
		chain.doFilter(request, response);
		System.out.println("FilterDemo1执行结束了...");
	}

	@Override
	public void destroy() {
		System.out.println("FilterDemo1被销毁了...");
	}

}
