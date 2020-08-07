package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * jdbc操作
 * @author zhy
 *
 */
public class JdbcDemo1 {
	
	/**
	 * 程序的耦合：
	 * 	调用者和被调用者的依赖关系
	 * 我们在开发中遵循的原则：
	 * 		编译时不依赖，运行时才依赖。
	 * 解决依赖关系：
	 * 		使用反射创建类对象
	 * 使用反射创建类对象引发的新问题：
	 * 		使用配置文件，通过读取配置文件来反射创建类对象
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//1.注册驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//2.获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day58_ee287_jpa", "root", "1234");
		//3.获取操作数据库的预处理对象
		PreparedStatement pstm = conn.prepareStatement("select * from cst_customer");
		//4.执行sql语句并获取返回结果
		ResultSet rs = pstm.executeQuery();
		//5.封装结果集
		while(rs.next()){
			System.out.println(rs.getString("cust_name"));
		}
		//6.释放资源
		rs.close();
		pstm.close();
		conn.close();
	}

}
