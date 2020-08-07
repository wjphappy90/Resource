package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 在service方法中我们完成原来servlet中根据method来调用方法操作。
		// 1.得到method参数
		String methodName = request.getParameter("method"); // login

		// 2.使用java反射技术来完成调用具体方法操作
		try {

			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 3.让这个方法执行
			method.invoke(this, request, response);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
