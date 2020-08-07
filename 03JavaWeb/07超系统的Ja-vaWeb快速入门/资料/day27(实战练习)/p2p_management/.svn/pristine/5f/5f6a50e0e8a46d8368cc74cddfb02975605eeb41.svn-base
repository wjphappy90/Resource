package com.itheima.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.IUserDAO;
import com.itheima.domain.User;
import com.itheima.utils.JdbcUtils;

public class UserDAOImpl implements IUserDAO {

	// 根据用户名与密码查询用户
	@Override
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
		// 使用dbutils完成查询操作
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

		return runner.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),
				username, password);
	}

}
