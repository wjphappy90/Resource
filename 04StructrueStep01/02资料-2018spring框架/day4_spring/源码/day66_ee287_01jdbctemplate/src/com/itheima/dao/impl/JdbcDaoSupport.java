//package com.itheima.dao.impl;
//
//import javax.sql.DataSource;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class JdbcDaoSupport {
//
//	private JdbcTemplate jdbcTemplate;
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//	
//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}
//	
//	public void setDataSource(DataSource dataSource){
//		//判断jdbcTemplate是否为null
//		if(jdbcTemplate == null){
//			createJdbcTemplate(dataSource);
//		}
//	}
//	
//	private void createJdbcTemplate(DataSource dataSource) {
//		jdbcTemplate = new JdbcTemplate(dataSource);
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	
//
//}
