package com.itheima.jdbc.demo4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itheima.jdbc.utils.JDBCUtils;

/**
 * 用户的登录的功能
 * @author jt
 *
 */
public class UserDao {
	
	/**
	 * 完成用户登录的方法：解决SQL注入漏洞
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username,String password){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 定义一个变量:
		boolean flag = false;
		try{
			// 获得连接:
			conn = JDBCUtils.getConnection();
			// 编写SQL语句:
			String sql = "select * from user where username = ? and password = ?";
			// 预编译SQL
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// 执行SQL语句:
			rs = pstmt.executeQuery();
			if(rs.next()){
				// 说明根据用户名和密码可以查询到这条记录
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, pstmt, conn);
		}
		return flag;
	}

/*	*//**
	 * 用户登录的方法
	 * @param username
	 * @param password
	 * @return
	 *//*
	public boolean login(String username,String password){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 定义一个变量:
		boolean flag = false;
		try{
			// 获得连接:
			conn = JDBCUtils.getConnection();
			// 完成登录功能:
			// 创建执行SQL语句的对象：
			stmt = conn.createStatement();
			// 编写SQL语句:
			String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
			// 执行SQL:
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				// 说明根据用户名和密码可以查询到这条记录
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return flag;
	}*/
}
