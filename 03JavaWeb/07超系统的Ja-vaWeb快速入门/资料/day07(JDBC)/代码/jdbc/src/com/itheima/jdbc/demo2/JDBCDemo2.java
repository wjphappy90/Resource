package com.itheima.jdbc.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * JDBC的CRUD的操作
 * @author jt
 *
 */
public class JDBCDemo2 {
	@Test
	/**
	 * 查询一条记录
	 */
	public void demo5(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获得连接
			conn = DriverManager.getConnection("jdbc:mysql:///web_test3", "root", "abc");
			// 执行SQL
			// 创建执行SQL语句对象:
			stmt = conn.createStatement();
			// 编写SQL:
			String sql = "select * from user where id = 4";
			rs = stmt.executeQuery(sql);
			// 判断就可以:
			if(rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("username")+" "+rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// 资源释放：
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				rs = null;
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				stmt = null;
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
	
	@Test
	/**
	 * 查询多条记录
	 */
	public void demo4(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获得连接
			conn = DriverManager.getConnection("jdbc:mysql:///web_test3", "root", "abc");
			// 执行操作
			// 创建执行SQL语句的对象:
			stmt = conn.createStatement();
			// 编写SQL:
			String sql = "select * from user";
			// 执行SQL:
			rs = stmt.executeQuery(sql);
			// 遍历结果集:
			while(rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("username")+" "+rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// 资源释放：
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				rs = null;
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				stmt = null;
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
	
	@Test
	/**
	 * 删除操作的代码实现
	 */
	public void demo3(){
		Connection conn = null;
		Statement stmt = null;
		try{
			// 注册驱动:
			Class.forName("com.mysql.jdbc.Driver");
			// 获得连接:
			conn = DriverManager.getConnection("jdbc:mysql:///web_test3", "root", "abc");
			// 创建执行SQL语句对象:
			stmt = conn.createStatement();
			// 编写SQL:
			String sql = "delete from user where id = 5";
			// 执行SQL:
			int num = stmt.executeUpdate(sql);
			if(num > 0){
				System.out.println("删除用户成功！！！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// 资源释放：
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				stmt = null;
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}

	@Test
	/**
	 * 修改操作的代码实现
	 */
	public void demo2(){
		Connection conn = null;
		Statement stmt  = null;
		try{
			// 注册驱动:
			Class.forName("com.mysql.jdbc.Driver");
			// 获得连接
			conn = DriverManager.getConnection("jdbc:mysql:///web_test3", "root", "abc");
			// 执行操作:
			// 创建执行SQL语句的对象:
			stmt = conn.createStatement();
			// 编写SQL语句：
			String sql = "update user set password='abc',nickname='旺财' where id = 5";
			// 执行SQL语句:
			int num = stmt.executeUpdate(sql);
			if(num > 0){
				System.out.println("修改用户成功!!!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// 资源释放：
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				stmt = null;
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
	
	@Test
	/**
	 * 保存操作的代码实现
	 */
	public void demo1(){
		Connection conn = null;
		Statement stmt = null;
		try{
			// 注册驱动:
			Class.forName("com.mysql.jdbc.Driver");
			// 获得连接:
			conn = DriverManager.getConnection("jdbc:mysql:///web_test3", "root", "abc");
			// 执行操作:
			// 创建执行SQL语句对象:
			stmt = conn.createStatement();
			// 编写SQL语句:
			String sql = "insert into user values (null,'eee','123','阿黄',21)";
			// 执行SQL语句:
			int num = stmt.executeUpdate(sql);
			if(num > 0){
				System.out.println("保存用户成功!!!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// 资源释放：
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				stmt = null;
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}
