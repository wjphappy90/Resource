package com.itheima.datasource.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.itheima.jdbc.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0连接池的测试
 * @author jt
 *
 */
public class C3P0Demo1 {
	@Test
	/**
	 * 采用配置文件的方式：
	 */
	public void demo2(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			// 获得连接：从连接池中获取：
			// 创建连接池：//创建连接池默认去类路径下查找c3p0-config.xml
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			// 从连接池中获得连接:
			conn = dataSource.getConnection();
			// 编写SQL：
			String sql = "select * from account";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			// 执行SQL：
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("money"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, pstmt, conn);
		}
	}

	@Test
	/**
	 * 手动设置参数的方式:
	 */
	public void demo1(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			// 获得连接：从连接池中获取：
			// 创建连接池：
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			// 设置连接参数:
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql:///web_test4");
			dataSource.setUser("root");
			dataSource.setPassword("abc");
			// 从连接池中获得连接:
			conn = dataSource.getConnection();
			// 编写SQL：
			String sql = "select * from account";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			// 执行SQL：
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("money"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, pstmt, conn);
		}
	}
}
