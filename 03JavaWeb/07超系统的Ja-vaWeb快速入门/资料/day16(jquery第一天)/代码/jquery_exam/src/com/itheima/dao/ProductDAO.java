package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Product;
import com.itheima.utils.JdbcUtils;

public class ProductDAO {

	// pageNo 页码
	// pageSize 每页条数
	public List<Product> findAll(int pageNo, int pageSize) throws SQLException {

		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

		return runner.query("select * from product limit ?,?", new BeanListHandler<Product>(Product.class),
				(pageNo - 1) * pageSize, pageSize);
	}

	// 查询总条数
	public int findAllCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		Long l = (Long) runner.query("select count(*) from product", new ScalarHandler());

		return l.intValue();
	}
}
