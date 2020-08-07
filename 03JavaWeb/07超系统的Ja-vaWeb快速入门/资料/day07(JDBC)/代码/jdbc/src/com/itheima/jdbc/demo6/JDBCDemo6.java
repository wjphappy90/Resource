package com.itheima.jdbc.demo6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import com.itheima.jdbc.utils.JDBCUtils;

/**
 * 批处理的操作
 * @author jt
 *
 */
public class JDBCDemo6 {
	@Test
	/**
	 * 批量插入记录:
	 * * 默认情况下MySQL批处理没有开启的，需要在url后面拼接一个参数即可。
	 */
	public void demo2(){
		// 记录开始时间:
		long begin = System.currentTimeMillis();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			// 获得连接:
			conn = JDBCUtils.getConnection();
			// 编写SQL语句：
			String sql = "insert into user values (null,?)";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			for(int i=1;i<=10000;i++){
				pstmt.setString(1, "name"+i);
				// 添加到批处理
				pstmt.addBatch();
				// 注意问题：
				// 执行批处理
				if(i % 1000 == 0){
					// 执行批处理:
					pstmt.executeBatch();
					// 清空批处理:
					pstmt.clearBatch();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pstmt, conn);
		}
		long end = System.currentTimeMillis();
		System.out.println((end-begin));
	}

	@Test
	/**
	 * 批处理基本操作
	 */
	public void demo1(){
		Connection conn = null;
		Statement stmt = null;
		try{
			// 获得连接:
			conn = JDBCUtils.getConnection();
			// 创建执行批处理对象:
			stmt = conn.createStatement();
			// 编写一批SQL语句：
			String sql1 = "create database test1";
			String sql2 = "use test1";
			String sql3 = "create table user(id int primary key auto_increment,name varchar(20))";
			String sql4 = "insert into user values (null,'aaa')";
			String sql5 = "insert into user values (null,'bbb')";
			String sql6 = "insert into user values (null,'ccc')";
			String sql7 = "update user set name = 'mmm' where id = 2";
			String sql8 = "delete from user where id = 1";
			// 添加到批处理
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			stmt.addBatch(sql4);
			stmt.addBatch(sql5);
			stmt.addBatch(sql6);
			stmt.addBatch(sql7);
			stmt.addBatch(sql8);
			// 执行批处理:
			stmt.executeBatch();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn);
		}
	}
	
}
