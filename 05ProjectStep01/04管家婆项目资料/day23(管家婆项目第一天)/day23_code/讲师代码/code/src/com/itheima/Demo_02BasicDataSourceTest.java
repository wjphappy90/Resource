package com.itheima;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/*
 * 测试，配置好的数据源对象
 * BasicDataSource
 * 使用Demo_01BasicDataSource类中，配置好的对象source
 * 
 * QueryRunner(DataSource ds) 
 */
public class Demo_02BasicDataSourceTest {
	public static void main(String[] args) throws SQLException {
		//创建QueryRunner对象，构造方法中，传递BasicDataSource类对象
		BasicDataSource source = Demo_01BasicDataSource.getSource();
		QueryRunner qr = new QueryRunner(source);
		
		List<Object[]> list = qr.query("SELECT * FROM GJP_LEDGER", new ArrayListHandler());
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object);
			}
			System.out.println();
		}
		System.out.println("=====================");
		DataSource dataSource = JDBCUtils.getDataSource();
		QueryRunner qr2 = new QueryRunner(dataSource);
		List<Object[]> list2 = qr2.query("SELECT * FROM GJP_LEDGER", new ArrayListHandler());
		for (Object[] objects : list2) {
			for (Object object : objects) {
				System.out.print(object);
			}
			System.out.println();
		}
	}
}
