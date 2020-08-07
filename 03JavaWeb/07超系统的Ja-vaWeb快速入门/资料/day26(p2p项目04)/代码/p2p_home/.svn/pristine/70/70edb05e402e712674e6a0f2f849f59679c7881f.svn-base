package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.Account;
import com.itheima.domain.Customer;
import com.itheima.domain.JsonResult;
import com.itheima.service.IAccountService;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.service.impl.CustomerServiceImpl;

public class AccountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("findByCustomer".equals(method)) {
			findByCustomer(request, response);
		}
	}

	// 根据客户查询客户的帐户信息
	public void findByCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.得到当前登录的客户
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		JsonResult jr = new JsonResult();
		if (customer == null) {
			// 用户未登录
			jr.setType(0);
			jr.setError("用户未登录，请登录后操作");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		} else {
			// 用户登录
			// 2.调用service,根据客户的id来查询客户的帐户信息
			IAccountService accountService = new AccountServiceImpl();
			try {
				Account account = accountService.findByCustomer(customer.getId());
				if (account == null) {
					jr.setType(0);
					jr.setError("用户帐户信息查询失败");
					response.getWriter().write(JSONObject.toJSONString(jr));
					return;
				}
				ICustomerService customerService=new CustomerServiceImpl();
				Customer c=customerService.findByEmail(customer.getEmail());
				account.setC(c);
				jr.setType(1);
				jr.setContent(account);
				response.getWriter().write(JSONObject.toJSONString(jr));
				return;
			} catch (Exception e) {
				e.printStackTrace();
				jr.setType(0);
				jr.setError("用户帐户信息查询失败");
				response.getWriter().write(JSONObject.toJSONString(jr));
				return;
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
