package com.itheima.response.demo1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Response响应中文的处理
 */
public class ResponseDemo3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		test2(response);
	}
	/**
	 * 使用字符流输出中文
	 * @param response
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private void test2(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		// 设置浏览器默认打开的时候采用的字符集:
		// response.setHeader("Content-Type", "text/html;charset=UTF-8");
		// 设置response获得字符流的缓冲区的编码:
		// response.setCharacterEncoding("UTF-8");
		// 简化代码
		response.setContentType("text/html;charset=UTF-8");
		// 会不会产生乱码
		response.getWriter().println("中文");
	}
	/**
	 * 使用字节流输出中文
	 * @param response
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private void test1(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		// 使用字节流的方式输出中文：
		ServletOutputStream outputStream = response.getOutputStream();
		// 设置浏览器默认打开的时候采用的字符集
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		// 设置中文转成字节数组字符集编码
		outputStream.write("中文".getBytes("UTF-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
