package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.Account;
import com.itheima.domain.Customer;
import com.itheima.domain.JsonResult;
import com.itheima.service.IAccountService;
import com.itheima.service.IProductAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.service.impl.ProductAccountServiceImpl;

/**
 * Servlet implementation class ProductAccountServlet
 */
public class ProductAccountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");

		if ("buy".equals(method)) {
			buy(request, response);
		}
		if ("findByCustomer".equals(method)) {
			findByCustomer(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// 查询购买理财产品信息及帐户信息
	public void findByCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.判断用户是否登录
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		JsonResult jr = new JsonResult();
		if (customer == null) {
			// 没有登录
			jr.setType(0);
			jr.setError("用户未登录，请登录后操作");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}

		// 2.查询帐户信息及理财产品信息
		IProductAccountService paService = new ProductAccountServiceImpl();
		try {
			Map<String, Object> map = paService.findByCustomer(customer);

			jr.setType(1);
			jr.setContent(map);
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;

		} catch (Exception e) {
			e.printStackTrace();
			jr.setType(0);
			jr.setError("客户资产信息查询失败");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}

	}

	// 购买理财产品
	public void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.判断用户是否登录
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		JsonResult jr = new JsonResult();
		if (customer == null) {
			// 没有登录
			jr.setType(0);
			jr.setError("用户未登录，请登录后操作");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}

		// 2.判断帐户余额
		double money = Double.parseDouble(request.getParameter("money")); // 投资金额要与帐户中的余额对比

		IAccountService accountService = new AccountServiceImpl();
		try {
			Account account = accountService.findByCustomer(customer.getId()); // 根据客户的id查询帐户信息

			if (account.getBalance() < money) { // 余额不足
				jr.setType(0);
				jr.setError("帐户余额不足");
				response.getWriter().write(JSONObject.toJSONString(jr));
				return;
			}

			// 3. 完成投资操作
			// 获取产品id
			int pid = Integer.parseInt(request.getParameter("pid"));
			IProductAccountService paService = new ProductAccountServiceImpl();

			paService.buy(account, customer, money, pid); // 购买理财产品

			jr.setType(1);
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;

		} catch (Exception e) {
			e.printStackTrace();
			jr.setType(0);
			jr.setError("投资失败");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}

	}

}
