package com.itheima.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0数据源工具类
 * @author zhy
 *
 */
public class C3P0Util {

	//定义一个数据源对象
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	/* 当我们使用配置文件时，并且配置文件按照文档要求，放到顶层构建路径中，就可以不用设置参数的值
	 * static{
		try {
			ds = new ComboPooledDataSource();
			//ds = new ComboPooledDataSource("oracle");通过构造函数来指定读取配置文件中的哪段配置
			ds.setDriverClass("com.mysql.jdbc.Driver");             
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/ee_1122_day14");
			ds.setUser("root");                                  
			ds.setPassword("1234");
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化连接失败！");
		} 
	}*/
	
	//获取数据源
	public static DataSource getDataSource(){
		return ds;
	}
	
	
	//获取一个连接
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
