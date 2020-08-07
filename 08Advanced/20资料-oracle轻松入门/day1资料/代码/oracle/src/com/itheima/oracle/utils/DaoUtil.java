package com.itheima.oracle.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtil {

	// 加载Oracle驱动
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin@192.168.56.102:1521:orcl", "water",
				"water");
		return connection;
	}

	/**
	 * 释放资源
	 * 
	 * @param rs
	 * @param stmt
	 * @param connection
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection connection) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
}
