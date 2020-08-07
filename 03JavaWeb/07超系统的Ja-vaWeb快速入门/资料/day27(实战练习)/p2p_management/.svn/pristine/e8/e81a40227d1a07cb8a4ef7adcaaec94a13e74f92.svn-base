package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.IProductDAO;
import com.itheima.domain.Product;
import com.itheima.utils.JdbcUtils;

public class ProductDAOImpl implements IProductDAO {

	// 查询所有产品
	@Override
	public List<Product> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		return runner.query("select * from product", new BeanListHandler<Product>(Product.class));
	}

	// 产品添加
	@Override
	public void add(Product p) {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		try {
			runner.update("insert into product values(null,?,?,?,?,null)", p.getProNum(), p.getProName(),
					p.getProLimit(), p.getAnnualized());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 根据id查询
	@Override
	public Product findById(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		return runner.query("select * from product where id=?", new BeanHandler<Product>(Product.class), id);
	}

	// 修改
	@Override
	public void update(Product p) throws SQLException {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update product set proNum=?,proName=?,proLimit=?,annualized=? where id=?";
		runner.update(sql, p.getProNum(), p.getProName(), p.getProLimit(), p.getAnnualized(), p.getId());
	}

}
