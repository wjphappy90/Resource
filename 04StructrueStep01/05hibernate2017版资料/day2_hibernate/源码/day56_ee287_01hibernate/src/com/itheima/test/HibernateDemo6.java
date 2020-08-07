package com.itheima.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * hibernate中的QBC查询
 * 	QBC的全称：Query By Criteria 
 *  它是一种更加面向对象的查询方式，它把生成语句的过程全都融入到方法之中了
 * @author zhy
 *
 */
public class HibernateDemo6 {

	//基本查询
	@Test
	public void test1(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//获取Criteria对象
		Criteria c = s.createCriteria(Customer.class);
		//获取结果集
		List list = c.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	//条件查询
	@Test
	public void test2(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//获取Criteria对象
		Criteria c = s.createCriteria(Customer.class);
		//使用criteria对象的add方法来添加条件
		c.add(Restrictions.eq("custLevel","23"));
		c.add(Restrictions.like("custName", "%集%"));
		//获取结果集
		List list = c.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	//排序查询
	@Test
	public void test3(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//获取Criteria对象
		Criteria c = s.createCriteria(Customer.class);
		//添加排序
		c.addOrder(Order.desc("custId"));
		//获取结果集
		List list = c.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	//分页查询
	/**
	 * QBC的分页查询和HQL的分页查询所用的方法和方法的含义都是一模一样的
	 */
	@Test
	public void test4(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//获取Criteria对象
		Criteria c = s.createCriteria(Customer.class);
		//设置分页条件
		c.setFirstResult(2);
		c.setMaxResults(2);
		//获取结果集
		List list = c.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	//统计（投影）查询
	@Test
	public void test5(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//获取Criteria对象
		Criteria c = s.createCriteria(Customer.class);
		//设置使用聚合函数
//		c.setProjection(Projections.rowCount());
		c.setProjection(Projections.count("custId"));
		//获取结果集
//		List list = c.list();
//		for(Object o : list){
//			System.out.println(o);
//		}
		Long count = (Long)c.uniqueResult();
		System.out.println(count);
		tx.commit();
	}
	
	
	
	//离线查询
	@Test
	public void testServlet(){
		//1.获取离线对象，不需要Session
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//2.封装查询条件
		dc.add(Restrictions.eq("custLevel", "23"));
		dc.add(Restrictions.like("custName","%集%"));
		
		List list = testService(dc);
		for(Object o : list){
			System.out.println(o);
		}
	}

	private List testService(DetachedCriteria dc) {
		Session s = null;
		Transaction tx  = null;
		try{
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			List list = testDao(dc);
			tx.commit();
			return list;
		}catch(Exception e){
			tx.rollback();
		}
		return null;
		
	}

	private List testDao(DetachedCriteria dc) {
		Session s = HibernateUtil.getCurrentSession();
		//把离线对象转成在线对象
		Criteria c = dc.getExecutableCriteria(s);
		
		return  c.list();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
