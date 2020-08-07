package com.itheima.gjp.tools;


import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/gjp";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "123";
	
	private static final int MAX_IDLE = 3;
	private static final long MAX_WAIT = 5000;
	private static final int MAX_ACTIVE = 5;
	private static final int INITIAL_SIZE = 3;
	
	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
			
		dataSource.setMaxActive(MAX_IDLE);
		dataSource.setMaxWait(MAX_WAIT);
		dataSource.setMaxActive(MAX_ACTIVE);
		dataSource.setInitialSize(INITIAL_SIZE);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}

