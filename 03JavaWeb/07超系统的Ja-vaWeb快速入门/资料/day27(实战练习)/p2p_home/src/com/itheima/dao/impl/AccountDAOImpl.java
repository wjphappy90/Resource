package com.itheima.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.IAccountDAO;
import com.itheima.domain.Account;
import com.itheima.utils.JdbcUtils;

public class AccountDAOImpl implements IAccountDAO {

	// 添加帐户信息
	@Override
	public void addAccount(Account account) throws SQLException {

		QueryRunner runner = new QueryRunner();
		runner.update(JdbcUtils.getConnection(), "insert into account values(null,?,?,?,?)", account.getTotal(),
				account.getBalance(), account.getInterest(), account.getC().getId());
	}

	// 根据客户查询帐户
	@Override
	public Account findByCustomer(int id) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

		return runner.query("select * from account where c_id=?", new BeanHandler<Account>(Account.class), id);
	}

	// 修改帐户的余额
	@Override
	public void updateAccount(double balance, int id) throws Exception {
		QueryRunner runner = new QueryRunner();
		runner.update(JdbcUtils.getConnection(), "update account set balance=? where id=?", balance, id);
	}

}
