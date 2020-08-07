package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * hibernate的主键生成策略
 * @author zhy
 *
 */
public class HibernateDemo1 {
	/**
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		c.setCustName("黑马287期");
		
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
		session.close();

	}
}
