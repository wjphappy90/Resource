package com.itheima.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.itheima.utils.JPAUtil;

/**
 * JPA中使用C3P0连接池
 * @author zhy
 *
 */
public class JPADemo2 {
	
	/**
	 * 验证c3p0连接池是否配置成功
	 */
	@Test
	public void test1(){
		//1.获取jpa中的操作对象
		EntityManager em = JPAUtil.createEntityManager();
		//2.
		Session session = em.unwrap(Session.class);
		//3.执行session的doWork方法
		session.doWork(new Work() {
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.println(conn.getClass().getName());
			}
		});
	}
	
	@Test
	public void test2(){
		//1.获取jpa中的操作对象
		EntityManager em1 = JPAUtil.createEntityManager();
		EntityManager em2 = JPAUtil.createEntityManager();
		System.out.println(em1 == em2);
	}
}
