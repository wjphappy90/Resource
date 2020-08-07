package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	// 使用c3p0连接池
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>(); // 相当
																				// 一个Map<Thread,value>

	public static DataSource getDataSource() {
		return dataSource;
	}

	// 获取与线程绑定的Connection对象
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();// get方法底层是使用 get(Thread.currentThread())
		if (con == null) {
			con = dataSource.getConnection();
			tl.set(con); // 相当 set(Thread.currentThread(),con)
		}
		return con;
	}

	// 开启事务
	public static void startTransaction() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.setAutoCommit(false); // 设置手动事务
		}
	}

	// 事务回滚
	public static void rollback() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.rollback();
		}
	}

	// 事务提交
	public static void commit() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.commit();
		}
	}

	// 关闭connection
	public static void close() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.close();
		}
	}
}
