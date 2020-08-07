package com.itheima.dbutils.demo2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import com.itheima.dbutils.domain.Account;
import com.itheima.jdbc.utils.JDBCUtils2;

/**
 * DBUtils的查询操作
 * @author jt
 *
 */
public class DBUtilsDemo2 {

	@Test
	/**
	 * 查询一条记录的操作
	 */
	public void demo1() throws SQLException{
		// 创建核心类:
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		// 执行查询:
		Account account = queryRunner.query("select * from account where id = ?", new ResultSetHandler<Account>(){

			@Override
			public Account handle(ResultSet rs) throws SQLException {
				Account account = new Account();
				if(rs.next()){
					account.setId(rs.getInt("id"));
					account.setName(rs.getString("name"));
					account.setMoney(rs.getDouble("money"));
				}
				return account;
			}
			
		}, 1);
		System.out.println(account);
	}
	
	@Test
	/**
	 * 查询多条记录
	 */
	public void demo2() throws SQLException{
		// 创建核心类:
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		// 执行查询:
		List<Account> list = queryRunner.query("select * from account", new ResultSetHandler<List<Account>>(){
			@Override
			public List<Account> handle(ResultSet rs) throws SQLException {
				// 创建一个集合用于封装数据:
				List<Account> list = new ArrayList<Account>();
				while(rs.next()){
					// 将结果集中的数据封装到对象中
					Account account = new Account();
					account.setId(rs.getInt("id"));
					account.setName(rs.getString("name"));
					account.setMoney(rs.getDouble("money"));
					// 将这个对象存入到list集合：
					list.add(account);
				}
				return list;
			}
		});
		// 使用集合:
		for (Account account : list) {
			System.out.println(account);
		}
	}
}
