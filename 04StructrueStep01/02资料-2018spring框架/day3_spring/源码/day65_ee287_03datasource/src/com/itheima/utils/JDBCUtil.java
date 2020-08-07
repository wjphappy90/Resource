package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 数据库操作相关的工具类
 * @author zhy
 *
 */
public class JDBCUtil {
	
	//使用ResourceBundle读取资源文件
	private static ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	//使用静态代码块进行赋值
	static{
		driver = bundle.getString("DRIVER");
		url = bundle.getString("URL");
		user = bundle.getString("USER");
		password = bundle.getString("PASSWORD");
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 释放资源
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void release(ResultSet rs,Statement st,Connection conn){
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(st != null){
			try{
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
