package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * hibernate的对象状态
 * @author zhy
 *
 */
public class HibernateDemo3 {
	/**
	 */
	@Test
	public void test1(){
		Customer c = new Customer();//瞬时状态
		c.setCustName("黑马287期_对象状态_测试查不查");
		
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.save(c);//持久化状态
//		Customer c1 = session.get(Customer.class, c.getCustId());
//		System.out.println(c1);
		tx.commit();//提交事务。没有提交事务之前，数据库不会有记录的。
		session.close();//没session

		c.setCustAddress("北京市顺义区");//脱管状态(脱离了session的管理)
		
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		s1.update(c);//持久化状态
		tx1.commit();
		s1.close();//session关闭了
		
		System.out.println(c);//脱管状态
	}
	
	
	/**
	 * saveOrUpdate
	 */
	@Test
	public void test2(){
		Customer c = new Customer();//瞬时状态
		c.setCustName("黑马287期_saveOrUpdate");
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		s1.saveOrUpdate(c);
		tx1.commit();
		s1.close();
	}
	
	@Test
	public void test3(){
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		Customer c = s1.get(Customer.class, 9L);//持久化状态		
		tx1.commit();
		s1.close();
		
		c.setCustAddress("顺义校区");
		System.out.println(c);//脱管状态
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(c);//持久化状态
		tx.commit();
		session.close();
	}
}
