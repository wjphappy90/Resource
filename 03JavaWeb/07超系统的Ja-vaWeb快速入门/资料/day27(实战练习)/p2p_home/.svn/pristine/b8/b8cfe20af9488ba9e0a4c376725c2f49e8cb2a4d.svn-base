package com.itheima.service.impl;

import java.sql.SQLException;

import com.itheima.dao.IAccountDAO;
import com.itheima.dao.ICustomerDAO;
import com.itheima.dao.impl.AccountDAOImpl;
import com.itheima.dao.impl.CustomerDAOImpl;
import com.itheima.domain.Account;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.utils.JdbcUtils;

public class CustomerServiceImpl implements ICustomerService {

	// 添加客户
	@Override
	public void addCustomer(Customer c) {
		// 开启事务
		try {
			JdbcUtils.startTransaction();

			// 1.添加客户
			ICustomerDAO customerDao = new CustomerDAOImpl();
			customerDao.addCustomer(c);
			Customer cc = customerDao.findByName(c.getC_name());
			// 2.生成帐户
			Account account = new Account();
			// account.setC(c); //如果添加的c这个对象，那么它的id是0
			// 我们需要在查询一次当前添加的客户
			account.setC(cc); // cc是有id
			IAccountDAO accountDao = new AccountDAOImpl();
			accountDao.addAccount(account);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				JdbcUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException();
		} finally {
			try {
				JdbcUtils.commit();
				JdbcUtils.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Customer findByName(String c_name) throws Exception {
		ICustomerDAO customerDao = new CustomerDAOImpl();
		return customerDao.findByName(c_name);
	}

	@Override
	public Customer findByEmail(String email) throws Exception {
		ICustomerDAO customerDao = new CustomerDAOImpl();
		return customerDao.findByEmail(email);
	}

	// 登录操作
	@Override
	public Customer login(String c_name, String password) throws Exception {
		ICustomerDAO customerDao = new CustomerDAOImpl();
		return customerDao.findCustomerByNameAndPassword(c_name, password);
	}

	// 修改邮箱状态
	@Override
	public void updateEmailStatus(String email) throws Exception {
		ICustomerDAO customerDao = new CustomerDAOImpl();
		customerDao.updateEmailStatus(email);
	}

}
