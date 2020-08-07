package com.itheima.dbutils.demo1;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.itheima.jdbc.utils.JDBCUtils2;

/**
 * DBUtils的增删改的操作：
 * @author jt
 *
 */
public class DBUtilsDemo1 {

	@Test
	/**
	 * 添加操作
	 */
	public void demo1() throws SQLException{
		// 创建核心类：QueryRunner:
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		queryRunner.update("insert into account values (null,?,?)", "ddd",10000);
	}
	
	@Test
	/**
	 * 修改操作
	 */
	public void demo2() throws SQLException{
		// 创建核心类:
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		queryRunner.update("update account set name=?,money=? where id =?", "eee",20000,4);
	}
	
	@Test
	/**
	 * 删除操作
	 */
	public void demo3() throws SQLException{
		// 创建核心类:
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		queryRunner.update("delete from account where id = ?", 3);
	}
}
