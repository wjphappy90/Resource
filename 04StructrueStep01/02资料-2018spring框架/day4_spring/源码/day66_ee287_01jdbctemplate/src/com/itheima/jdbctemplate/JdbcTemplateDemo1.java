package com.itheima.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的最基本用法
 * @author zhy
 *
 */
public class JdbcTemplateDemo1 {

	public static void main(String[] args){
		//定义数据源
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/day66_ee287_spring");
		ds.setUsername("root");
		ds.setPassword("1234");
		
		//1.获取对象
//		JdbcTemplate jt = new JdbcTemplate(ds);
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		//2.执行操作
		jt.execute("insert into account(name,money)values('ddd',1234)");
	}

}
