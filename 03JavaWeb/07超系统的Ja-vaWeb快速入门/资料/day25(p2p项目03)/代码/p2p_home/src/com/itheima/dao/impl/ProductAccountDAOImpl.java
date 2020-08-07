package com.itheima.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import com.itheima.dao.IProductAccountDAO;
import com.itheima.domain.ProductAccount;
import com.itheima.utils.JdbcUtils;

public class ProductAccountDAOImpl implements IProductAccountDAO {

	// 投资记录添加
	@Override
	public void add(ProductAccount pa) throws Exception {

		QueryRunner runner = new QueryRunner();
		runner.update(JdbcUtils.getConnection(), "insert into product_account values(null,?,null,?,?,?,?)",
				pa.getPa_num(), pa.getC().getId(), pa.getP().getId(), pa.getMoney(), pa.getInterest());

	}

	// 查询客户购买的产品信息
	@Override
	public List<Object[]> findByCustomer(int id) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT pa.pa_num,p.proName,p.proLimit,p.annualized,pa.interest,c.c_name,pa.pa_date,pa.money FROM product_account pa,product p,customer c WHERE pa.c_id=c.id AND pa.p_id=p.id AND c.id=?";
		return runner.query(sql, new ArrayListHandler(), id);
	}

}
