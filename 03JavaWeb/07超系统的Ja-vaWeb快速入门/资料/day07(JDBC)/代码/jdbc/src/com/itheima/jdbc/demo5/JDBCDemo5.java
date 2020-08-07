package com.itheima.jdbc.demo5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.itheima.jdbc.utils.JDBCUtils;

/**
 * JDBC的CRUD的操作：PreparedStatement对象
 * @author jt
 *
 */
public class JDBCDemo5 {
	@Test
	/**
	 * 查询操作
	 */
	public void demo4(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			// 获得连接:
			conn = JDBCUtils.getConnection();
			// 编写SQL:
			String sql = "select * from user";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			// 执行SQL:
			rs = pstmt.executeQuery();
			// 遍历结果集:
			while(rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("username")+" "+rs.getString("password")+" "+rs.getString("nickname"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, pstmt, conn);
		}
	}
	
	@Test
	/**
	 * 删除操作
	 */
	public void demo3(){
		Connection conn = null;
		PreparedStatement pstmt  = null;
		try{
			// 获得连接：
			conn = JDBCUtils.getConnection();
			// 编写SQL语句:
			String sql = "delete from user where id = ?";
			// 预编译SQL
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			pstmt.setInt(1, 4);
			// 执行SQL:
			int num = pstmt.executeUpdate();
			if(num > 0){
				System.out.println("删除成功！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pstmt, conn);
		}
	}
	
	@Test
	/**
	 * 修改操作
	 */
	public void demo2(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			// 获得连接:
			conn = JDBCUtils.getConnection();
			// 编写SQL语句:
			String sql = "update user set username = ?,password =?,nickname=?,age = ? where id = ?";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			pstmt.setString(1, "abc");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "旺旺");
			pstmt.setInt(4, 23);
			pstmt.setInt(5, 6);
			// 执行SQL：
			int num = pstmt.executeUpdate();
			if(num > 0){
				System.out.println("修改成功！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pstmt, conn);
		}
	}

	@Test
	/**
	 * 保存操作
	 */
	public void demo1(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			// 获得连接:
			conn = JDBCUtils.getConnection();
			// 编写SQL语句:
			String sql = "insert into user values (null,?,?,?,?)";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			pstmt.setString(1, "eee");
			pstmt.setString(2, "abc");
			pstmt.setString(3, "旺财");
			pstmt.setInt(4, 32);
			// 执行SQL
			int num = pstmt.executeUpdate();
			if(num > 0){
				System.out.println("保存成功！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pstmt, conn);
		}
	}
}
