package com.itheima.datasource.demo1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * 使用装饰者增强Connection中的close方法
 * @author jt
 *
 */
public class MyConnectionWrapper extends ConnectionWrapper{

	private Connection conn;
	private List<Connection> connList;

	public MyConnectionWrapper(Connection conn,List<Connection> connList) {
		super(conn);
		this.conn = conn;
		this.connList= connList;
	}
	
	// 增强某个方法:
	@Override
	public void close() throws SQLException {
//		super.close();
		// 归还连接：
		connList.add(conn);
	}

}
