package com.itheima.filter.demo1;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * FilterConfig的演示
 * @author jt
 *
 */
public class FilterDemo4 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获得过滤器的名称:
		String filterName = filterConfig.getFilterName();
		System.out.println(filterName);
		// 获得初始化参数:
		String username = filterConfig.getInitParameter("username");
		String password = filterConfig.getInitParameter("password");
		System.out.println(username);
		System.out.println(password);
		// 获得所有初始化参数的名称:
		Enumeration<String> names = filterConfig.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = filterConfig.getInitParameter(name);
			System.out.println(name+"    "+value);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

	}

	@Override
	public void destroy() {

	}

}
