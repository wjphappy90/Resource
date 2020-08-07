package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * 使用JPA配置映射
 * 使用Hibernate操作
 * @author zhy
 *
 */
public class HibernateDemo1 {

	/**
	 * 保存
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCustName("hibernate jpa customer");
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(c);
		tx.commit();
	}
	
	/**
	 * 查询一个
	 */
	@Test
	public void test2(){
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 6L);
		System.out.println(c);
		tx.commit();
	}
	
	/**
	 * 修改
	 */
	@Test
	public void test3(){
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 6L);
		c.setCustAddress("顺义区");
		tx.commit();
	}
	
	/**
	 * 删除操作
	 */
	@Test
	public void test4(){
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 6L);
		s.delete(c);
		tx.commit();
	}
}
