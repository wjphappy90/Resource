package com.itheima.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itheima.dao.IAccountDAO;
import com.itheima.dao.IProductAccountDAO;
import com.itheima.dao.IProductDAO;
import com.itheima.dao.impl.AccountDAOImpl;
import com.itheima.dao.impl.ProductAccountDAOImpl;
import com.itheima.dao.impl.ProductDAOImpl;
import com.itheima.domain.Account;
import com.itheima.domain.Customer;
import com.itheima.domain.Product;
import com.itheima.domain.ProductAccount;
import com.itheima.service.IProductAccountService;
import com.itheima.utils.JdbcUtils;

public class ProductAccountServiceImpl implements IProductAccountService {

	// 购买理财产品
	@Override
	public void buy(Account account, Customer customer, double money, int pid) {

		IAccountDAO accountDao = new AccountDAOImpl();
		// 1.修改客户的帐户信息 现阶段只需要修改余额就可以
		// double balance = account.getBalance() - money;
		// //在真实开发中对于敏感的数字操作，可以使用BigInterger BigDecimal
		BigDecimal bg = new BigDecimal(account.getBalance()); // 当前帐户余额

		BigDecimal sub = bg.subtract(new BigDecimal(money)); // 原帐户的balance-投资金额
		double balance = sub.doubleValue();

		// 开启事务
		try {
			JdbcUtils.startTransaction();
			accountDao.updateAccount(balance, account.getId());

			// 2.向product_account插入数据
			// 2.1根据pid查询产品
			IProductDAO productDao = new ProductDAOImpl();
			Product p = productDao.findById(pid);

			// 2.2 计算收益
			// 收益=本金*收益率*期限/100/12
			BigDecimal bd1 = new BigDecimal(money);// 本金
			double interest = bd1.multiply(new BigDecimal(p.getAnnualized())).multiply(new BigDecimal(p.getProLimit()))
					.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)
					.divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP).doubleValue();

			IProductAccountDAO paDao = new ProductAccountDAOImpl();
			// 2.3封装数据到ProductAccount
			ProductAccount pa = new ProductAccount();
			pa.setC(customer);
			pa.setP(p);
			pa.setInterest(interest);
			pa.setMoney(money);
			String pa_num = "tz" + new Date().getTime();
			pa.setPa_num(pa_num);
			// 添加
			paDao.add(pa);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				JdbcUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				JdbcUtils.commit();
				JdbcUtils.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 查询帐户信息及客户购买理财产品信息
	@Override
	public Map<String, Object> findByCustomer(Customer customer) throws Exception {

		// 1.查询帐户信息
		IAccountDAO accountDao = new AccountDAOImpl();
		Account account = accountDao.findByCustomer(customer.getId());

		// 2.查询购买的理财 产品信息
		IProductAccountDAO paDao = new ProductAccountDAOImpl();
		List<Object[]> objs = paDao.findByCustomer(customer.getId());
		// 手动将objs中的数据在封装成List<ProductAccount>
		List<ProductAccount> pas = new ArrayList<ProductAccount>();
		for (Object[] obj : objs) {

			ProductAccount pa = new ProductAccount();
			pa.setPa_num((String) obj[0]); // 封装购买理财产品编号
			pa.setInterest((double) obj[4]); // 封装预期收益
			pa.setPa_date((Date) obj[6]);
			pa.setMoney((double) obj[7]);

			Product p = new Product();
			p.setProName((String) obj[1]);
			p.setProLimit((int) obj[2]);
			p.setAnnualized((double) obj[3]);
			pa.setP(p); // 将产品相关信息进行封装

			Customer c = new Customer();
			c.setC_name((String) obj[5]);
			pa.setC(c);

			pa.setStatus(checkStatus(pa.getPa_date(), p.getProLimit())); // 设置购买的产品是否到期
			pas.add(pa);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", account);
		map.put("productAccount", pas);
		return map;
	}

	// 参数1 是购买产品的日期 参数二是产品的期限
	private int checkStatus(Date pa_date, int proLimit) {
		Calendar c = Calendar.getInstance();
		c.setTime(pa_date); // 当前的c就代表的是购买产品的日期
		c.add(Calendar.MONTH, proLimit); // 从购买产品开始+产品的期限的时间值

		if (c.getTimeInMillis() - new Date().getTime() >= 0) {
			// 未到期
			return 0;
		} else {
			// 到期
			return 1;
		}
	}

}
