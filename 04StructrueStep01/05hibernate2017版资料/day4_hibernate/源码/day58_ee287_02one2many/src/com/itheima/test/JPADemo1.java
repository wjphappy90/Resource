package com.itheima.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.utils.JPAUtil;

/**
 * JPA中一对多的相关操作
 * @author zhy
 *
 */
public class JPADemo1 {
	
	/**
	 * 保存操作
	 * 	 创建一个客户和一个联系人
	 * 	建立客户和联系人的双向关联关系
	 *  先保存客户，再保存联系人
	 */
	@Test
	public void test1(){
		Customer c = new Customer();
		LinkMan l = new LinkMan();
		c.setCustName("JPA One To Many Customer");
		l.setLkmName("JPA One To Many LinkMan");
		
		c.getLinkmans().add(l);
		l.setCustomer(c);
		
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		em.persist(l);
		tx.commit();
		em.close();
	}
	
	/**
	 * 更新操作
	 * 	创建一个联系人
	 * 	查询id为5的客户
	 * 	为5这个客服分配该联系人
	 * 	更新客户
	 */
	@Test
	public void test2(){
		LinkMan l = new LinkMan();
		l.setLkmName("JPA One To Many LinkMan 2");
		
		
		
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer c = em.find(Customer.class, 5L);
		
		c.getLinkmans().add(l);
		l.setCustomer(c);
		
		tx.commit();
		em.close();
	}
	
	/**
	 * 删除操作
	 */
	@Test
	public void test3(){
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer c = em.find(Customer.class, 5L);
		em.remove(c);
		
		tx.commit();
		em.close();
	}
}
