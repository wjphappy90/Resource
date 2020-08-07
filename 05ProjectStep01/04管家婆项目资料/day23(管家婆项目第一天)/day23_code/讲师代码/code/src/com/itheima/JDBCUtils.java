package com.itheima;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/gjp";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123";
	
	private static final int MAX_IDLE = 3;
	private static final int MAX_WAIT = 3000;
	private static final int MAX_ACTIVE = 5;
	private static final int INITIAL_SIZE = 10;
	
	private static BasicDataSource dataSource = new BasicDataSource();
	
	static{
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);//驱动类名
		dataSource.setUrl(URL);//连接数据库地址
		dataSource.setUsername(USERNAME);//用户名
		dataSource.setPassword(PASSWORD);//密码
		
		dataSource.setMaxIdle(MAX_IDLE);//连接池最大空闲连接个数
		dataSource.setMaxWait(MAX_WAIT);//连接池最大等待时间
		dataSource.setMaxActive(MAX_ACTIVE);//连接池最大连接个数
		dataSource.setInitialSize(INITIAL_SIZE);//连接池初始化连接个数
	}

	public static DataSource getDataSource(){
		return dataSource;
	}
}
