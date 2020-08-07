package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import com.itheima.dao.IProductExpirationDAO;
import com.itheima.utils.JdbcUtils;

public class ProductExpirationDAOImpl implements IProductExpirationDAO {

	//查询投资信息与购买产品信息
	@Override
	public List<Object[]> findExpiration() throws SQLException {

		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		return runner.query(
				"SELECT p.proLimit,pa.interest,pa.pa_date ,pa.c_id FROM product p,product_account pa WHERE p.id=pa.p_id",
				new ArrayListHandler());
	}

	// 累加帐户中的收益
	@Override
	public void updateCustomerAccountInterest(double interest, int id) throws SQLException {

		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update account set interest=interest+? where c_id=?";
		runner.update(sql, id);
	}

}
