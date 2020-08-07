package com.itheima.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.dataSource.MyDataSource;

public class DataSourceTest {

	public static void main(String[] args) throws Exception {
		int size = MyDataSource.getPoolSize();
		System.out.println("使用连接之前"+size);
		
		for(int i=0;i<10;i++){
			Connection conn = MyDataSource.getConnection();
			System.out.println(conn);
			conn.close();//此时不能关闭，必须把连接放回池里
		}
		
		int size1 = MyDataSource.getPoolSize();
		System.out.println("使用连接之后"+size1);
		
		for(int i=0;i<10;i++){
			Connection conn = MyDataSource.getConnection();
			System.out.println(conn);
			conn.close();//此时不能关闭，必须把连接放回池里
		}
	}

}
