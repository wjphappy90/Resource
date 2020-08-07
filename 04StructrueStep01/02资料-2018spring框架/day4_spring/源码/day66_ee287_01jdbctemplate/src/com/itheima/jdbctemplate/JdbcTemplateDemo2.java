package com.itheima.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的入门
 * @author zhy
 *
 */
public class JdbcTemplateDemo2 {

	public static void main(String[] args){
		//1.获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.跟id获取bean对象
		JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
		//3.执行操作
		jt.execute("insert into account(name,money)values('eee',2345)");
		
		
		
//-------------------------------------------------------------------		
		
//		//定义数据源
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/day66_ee287_spring");
//		ds.setUsername("root");
//		ds.setPassword("1234");
//		
//		//1.获取对象
////		JdbcTemplate jt = new JdbcTemplate(ds);
//		JdbcTemplate jt = new JdbcTemplate();
//		jt.setDataSource(ds);
//		//2.执行操作
//		jt.execute("insert into account(name,money)values('ddd',1234)");
	}

}
