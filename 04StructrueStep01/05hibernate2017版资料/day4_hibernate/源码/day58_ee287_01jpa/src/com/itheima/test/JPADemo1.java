package com.itheima.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.JPAUtil;

/**
 * JPA的入门案例
 * 	JPA操作数据库（单表操作）
 * @author zhy
 *
 */
public class JPADemo1 {

	//保存
	@Test
	public void test1(){
		//创建客户对象
		Customer c = new Customer();
		c.setCustName("JPA Customer");
		
		//1.获取EntityManager对象
		EntityManager em = JPAUtil.createEntityManager();
		//2.获取事务对象，并开启事务
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.执行保存操作
		em.persist(c);
		//4.提交事务
		tx.commit();
		//5.关闭资源
		em.close();
	}
	
	
	//查询一个实体	立即加载
	@Test
	public void test2(){
		//1.获取EntityManager对象
		EntityManager em = JPAUtil.createEntityManager();
		//2.获取事务对象，并开启事务
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.执行更新操作（需要把更新的对象先查询出来）
		Customer c = em.find(Customer.class, 1L);
		System.out.println(c);
		//4.提交事务
		tx.commit();
		//5.关闭资源
		em.close();
	}
	
	
	//查询一个实体	延迟加载
	@Test
	public void test2_1(){
		//1.获取EntityManager对象
		EntityManager em = JPAUtil.createEntityManager();
		//2.获取事务对象，并开启事务
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.执行更新操作（需要把更新的对象先查询出来）
		Customer c = em.getReference(Customer.class, 1L);
		System.out.println(c);
		//4.提交事务
		tx.commit();
		//5.关闭资源
		em.close();
	}
	
	
	//更新操作
	@Test
	public void test3(){	
		//1.获取EntityManager对象
		EntityManager em = JPAUtil.createEntityManager();
		//2.获取事务对象，并开启事务
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.执行更新操作（需要把更新的对象先查询出来）
		Customer c = em.find(Customer.class, 1L);
		//修改客户的地址为：顺义区
		c.setCustAddress("顺义区");
		//4.提交事务
		tx.commit();
		//5.关闭资源
		em.close();
	}
	
	//更新的另一种操作方式
	//merge是合并  （两个实体合并）
	@Test
	public void test4(){	
		//1.获取EntityManager对象
		EntityManager em = JPAUtil.createEntityManager();
		//2.获取事务对象，并开启事务
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.执行更新操作（需要把更新的对象先查询出来）
		Customer c = em.find(Customer.class, 1L);
		//修改客户的地址为：顺义区
		c.setCustAddress("北京市顺义区");
		
		em.merge(c);
		//4.提交事务
		tx.commit();
		//5.关闭资源
		em.close();
	}
	
	//删除操作
	@Test
	public void test5(){	
		//1.获取EntityManager对象
		EntityManager em = JPAUtil.createEntityManager();
		//2.获取事务对象，并开启事务
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.执行更新操作（需要把更新的对象先查询出来）
		Customer c = em.find(Customer.class, 1L);
		//删除操作
		em.remove(c);
		
		//4.提交事务
		tx.commit();
		//5.关闭资源
		em.close();
	}
	
	/*
	 * 查询所有
	 * 
	 * 	涉及的对象是：
	 * 		JPA的Query
	 * 	如何获取该对象：
	 * 		EntityManager的createQuery(String jpql)
	 * 	参数含义：
	 * 		JPQL：Java Persistence Query Language
	 * 		他的写法和HQL很相似。也是把表名换成类名，把字段名换成属性名称
	 * 		它在写查询所有时，不能直接用		from 实体类
	 * 		需要使用select关键字
	 * 			select c from Customer c
	 */
	@Test
	public void test6(){	
		//1.获取EntityManager对象
		EntityManager em = JPAUtil.createEntityManager();
		//2.获取事务对象，并开启事务
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3.获取JPA的查询对象Query
		Query query = em.createQuery("select c from Customer c where custName like ? and custLevel = ? ");
		//给占位符赋值
		query.setParameter(1, "%集%");
		query.setParameter(2,"23");
		//执行方法获取结果集
		List list = query.getResultList();
		for(Object o : list){
			System.out.println(o);
		}
		//4.提交事务
		tx.commit();
		//5.关闭资源
		em.close();
	}
	
}
