package com.itheima;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 使用数据库的连接池
 * DBCP连接池
 *   BasicDataSource 实现 javax.sql.DataSource接口
 */
public class Demo_01BasicDataSource {

	public static BasicDataSource getSource(){
		BasicDataSource source = new BasicDataSource();
		//BasicDataSource方法，设置必要参数
		//设置驱动程序
		source.setDriverClassName("com.mysql.jdbc.Driver");
		//设置数据库连接URL
		source.setUrl("jdbc:mysql://localhost:3306/gjp");
		//设置用户名和密码
		source.setUsername("root");
		source.setPassword("123");
		return source;
	}
}
