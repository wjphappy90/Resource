package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * 演示hibernate的update方法的问题
 * @author zhy
 *
 */
public class HibernateDemo7 {

	/**
	 * 需求：
	 * 	查询id为1的客户
	 * 	关闭session(清空了一级缓存和快照)
	 *  修改id为1的客户名称为：黑马程序员顺义校区
	 *  再次获取session,
	 *  再次查询id为1的客户，
	 *  更新刚才修改的客户。
	 */
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 1L);//持久态
		tx.commit();
		s.close();//关闭
		
		//修改客户信息
		c.setCustName("黑马程序员顺义校区");//脱管态
		
		Session s1 = HibernateUtil.openSession();
		Transaction tx1 = s1.beginTransaction();
		//再次查询
		Customer c1 = s1.get(Customer.class, 1L);//持久态
		//更新修改对象
		//s1.update(c);//把脱管态对象转成持久态
		s1.merge(c);
		tx1.commit();
		s1.close();
	}
}
