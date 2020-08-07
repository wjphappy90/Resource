package com.itheima.test;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.utils.JPAUtil;

/**
 * JPA的查询操作
 * 
 * 	它可以使用对象导航的方式
 * @author zhy
 *
 */
public class JPADemo2 {
	
	/**
	 * 根据客户查询客户下的联系人
	 */
	@Test
	public void test1(){
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//1.查询id为1的客户
		Customer c = em.find(Customer.class, 1l);
		System.out.println(c);
		//查询当前客户下的联系人
		Set<LinkMan> linkmans = c.getLinkmans();
		System.out.println(linkmans);
		
		tx.commit();
		em.close();
	}
	
	/**
	 * 根据联系人，查询联系人的所属客户
	 */
	@Test
	public void test2(){
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//1.查询id为1的客户
		LinkMan l = em.find(LinkMan.class, 1l);
		System.out.println(l);
		//查询当前客户下的联系人
		Customer c = l.getCustomer();
		System.out.println(c);
		
		tx.commit();
		em.close();
	}
}
