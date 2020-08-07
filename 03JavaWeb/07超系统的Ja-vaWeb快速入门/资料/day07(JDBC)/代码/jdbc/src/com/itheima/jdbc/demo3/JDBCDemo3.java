package com.itheima.jdbc.demo3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.itheima.jdbc.utils.JDBCUtils;

/**
 * JDBC的工具类的测试
 * @author jt
 *
 */
public class JDBCDemo3 {

	@Test
	/**
	 * 查询操作：使用工具类
	 */
	public void demo1(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			// 获得连接:
			conn = JDBCUtils.getConnection();
			// 创建执行SQL语句的对象:
			stmt = conn.createStatement();
			// 编写SQL:
			String sql = "select * from user";
			// 执行查询:
			rs = stmt.executeQuery(sql);
			// 遍历结果集:
			while(rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("username")+" "+rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// 释放资源:
			JDBCUtils.release(rs, stmt, conn);
		}
	}
}
