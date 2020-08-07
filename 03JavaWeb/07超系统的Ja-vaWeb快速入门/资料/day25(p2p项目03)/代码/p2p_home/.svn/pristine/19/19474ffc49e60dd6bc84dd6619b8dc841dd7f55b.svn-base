package com.itheima.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.IProductDAO;
import com.itheima.domain.Product;
import com.itheima.utils.JdbcUtils;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public Product findById(int pid) throws SQLException {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		return runner.query("select * from product where id=?", new BeanHandler<Product>(Product.class), pid);
	}

}
