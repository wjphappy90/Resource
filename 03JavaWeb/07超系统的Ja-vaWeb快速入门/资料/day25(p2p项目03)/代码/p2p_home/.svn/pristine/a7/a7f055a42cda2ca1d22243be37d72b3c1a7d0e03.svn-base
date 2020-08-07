package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.Customer;
import com.itheima.domain.JsonResult;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
import com.itheima.utils.MailUtils;

public class CustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("regist".equals(method)) {
			regist(request, response);
		}
		if ("login".equals(method)) {
			login(request, response);
		}
		if ("findCustomer".equals(method)) {
			findCustomer(request, response);
		}

		if ("sendEmail".equals(method)) {
			sendEmail(request, response);
		}

		if ("checkEmail".equals(method)) {
			checkEmail(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// 邮箱认证
	public void checkEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取请求参数
		String email = request.getParameter("email");
		String emailCode = request.getParameter("emailCode");

		// 2.判断emailCode是否正确
		String _emailCode = (String) request.getSession().getAttribute("emailCode");
		JsonResult jr = new JsonResult();
		if (!emailCode.equalsIgnoreCase(_emailCode)) {
			jr.setType(0);
			jr.setError("邮箱验证码不正确");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}

		// 3.调用service完成认证操作
		ICustomerService customerService = new CustomerServiceImpl();
		try {
			customerService.updateEmailStatus(email);
			jr.setType(1);
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		} catch (Exception e) {
			e.printStackTrace();
			jr.setType(0);
			jr.setError("邮箱验证失败");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}
	}

	// 发送邮件
	public void sendEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.得到发送邮件的邮箱地址
		String email = request.getParameter("email");
		// 2.产生随机码
		String num = RandomStringUtils.randomNumeric(4); // 随机产生一个四位的数字

		String emailMsg = "邮箱认证码为:" + num;

		// 在服务器端保存邮件认证码
		request.getSession().setAttribute("emailCode", num);

		JsonResult jr = new JsonResult();

		try {
			// 发送邮件
			MailUtils.sendMail(email, emailMsg);
			jr.setType(1);
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		} catch (Exception e) {
			e.printStackTrace();
			jr.setType(0);
			jr.setError("邮件发送失败");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}
	}

	// 主要是用于查询客户，展示邮箱信息
	public void findCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 用户必须登录才能进行邮箱认证
		Customer customer = (Customer) request.getSession().getAttribute("customer");

		ICustomerService customerService = new CustomerServiceImpl();

		try {
			Customer c = customerService.findByEmail(customer.getEmail());
			JsonResult jr = new JsonResult();
			if (c.getEmail_status() == 0) {
				// 没有认证
				jr.setType(1);
				jr.setContent(c);
			} else {
				// 认证
				jr.setType(0);
				jr.setError("邮箱已认证");
			}
			response.getWriter().write(JSONObject.toJSONString(jr));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 登录操作
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1.得到请求参数
		String c_name = request.getParameter("c_name");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkCode");

		// 一般在开发中，服务器端可以进行非空校验

		JsonResult jr = new JsonResult();
		if (StringUtils.isBlank(c_name)) { // c_name为空
			jr.setType(0);
			jr.setError("用户名不能为空");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}
		if (StringUtils.isBlank(password)) { // c_name为空
			jr.setType(0);
			jr.setError("密码不能为空");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}
		if (StringUtils.isBlank(checkCode)) { // c_name为空
			jr.setType(0);
			jr.setError("验证码不能为空");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}

		// 2.判断验证码是否正确
		String _checkCode = (String) request.getSession().getAttribute("checkcode_session");
		// 验证码只使用一次，从session中获取后，就应该将验证码从session中删除
		request.getSession().removeAttribute("checkcode_session");

		if (!checkCode.equalsIgnoreCase(_checkCode)) {
			// 验证码错误
			jr.setType(0);
			jr.setError("验证码不正确");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}
		ICustomerService customerService = new CustomerServiceImpl();
		try {
			// 判断c_name是否是邮箱--通过java中的正则表达式
			String reg = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(c_name);
			boolean flag = matcher.matches();
			if (flag) {
				// 符合邮箱规范
				Customer c = customerService.findByEmail(c_name);
				c_name = c.getC_name(); // 将用户名重新赋值
			}

			// 3.调用service完成登录操作

			Customer customer = customerService.login(c_name, password);

			if (customer == null) {
				// 用户名或密码错误
				jr.setType(0);
				jr.setError("用户名或密码错误");
				response.getWriter().write(JSONObject.toJSONString(jr));
				return;
			}
			request.getSession().setAttribute("customer", customer);
			jr.setType(1);
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;

		} catch (Exception e) {
			e.printStackTrace();
			jr.setType(0);
			jr.setError("登录失败");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}

	}

	// 注册操作
	public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.得到请求参数，封装到Customer
		Customer c = new Customer();
		try {
			BeanUtils.populate(c, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		ICustomerService customerService = new CustomerServiceImpl();
		// 2.要保证客户的名称与邮箱是唯一的。
		JsonResult jr = new JsonResult();
		try {
			Customer c1 = customerService.findByName(c.getC_name());
			Customer c2 = customerService.findByEmail(c.getEmail());

			if (c1 != null) {
				// 说明用户名占用
				jr.setType(0);
				jr.setError("客户名称被占用");
				response.getWriter().write(JSONObject.toJSONString(jr));
				return;
			}
			if (c2 != null) {
				// 说明 邮箱占用
				jr.setType(0);
				jr.setError("邮箱被占用");
				response.getWriter().write(JSONObject.toJSONString(jr));
				return;
			}
			// 3.调用service将c添加，还需要添加帐户信息
			request.getSession().setAttribute("customer", c1);
			customerService.addCustomer(c);
			jr.setType(1);
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		} catch (Exception e) {
			e.printStackTrace();
			jr.setType(0);
			jr.setError("注册失败");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}

	}

}
