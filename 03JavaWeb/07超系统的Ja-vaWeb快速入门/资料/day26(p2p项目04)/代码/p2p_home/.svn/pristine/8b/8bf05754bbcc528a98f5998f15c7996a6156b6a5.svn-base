package com.itheima.service.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.dao.IAccountDAO;
import com.itheima.dao.impl.AccountDAOImpl;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.JdbcUtils;

public class AccountServiceImpl implements IAccountService {

	@Override
	public Account findByCustomer(int id) throws Exception {
		IAccountDAO accountDao=new AccountDAOImpl();
		
		return accountDao.findByCustomer(id);
	}

	

}
