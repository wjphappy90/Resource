package com.itheima.transaction.demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.itheima.jdbc.utils.JDBCUtils;

/**
 * 事务管理的测试类：
 * @author jt
 *
 */
public class TransactionDemo1 {

	@Test
	/**
	 * 完成转账的案例
	 */
	public void demo1(){
		Connection conn = null;
		PreparedStatement pstmt  = null;
		try{
			/**
			 * 完成转账代码：
			 * * 扣除某个账号的钱
			 * * 给另外一个账号加钱
			 */
			// 获得连接：
			conn = JDBCUtils.getConnection();
			// 开启事务
			conn.setAutoCommit(false);
			// 编写SQL语句：
			String sql = "update account set money = money + ? where name = ?";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			// 用aaa账号给bbb账号转1000元
			pstmt.setDouble(1, -1000);
			pstmt.setString(2, "aaa");
			// 执行SQL：扣除aaa账号1000元
			pstmt.executeUpdate();
			
			int i = 1 / 0;
			
			// 给bbb账号加1000
			pstmt.setDouble(1, 1000);
			pstmt.setString(2, "bbb");
			pstmt.executeUpdate();
			
			// 提交事务:
			conn.commit();
		}catch(Exception e){
			// 回滚事务:
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			JDBCUtils.release(pstmt, conn);
		}
	}
}
