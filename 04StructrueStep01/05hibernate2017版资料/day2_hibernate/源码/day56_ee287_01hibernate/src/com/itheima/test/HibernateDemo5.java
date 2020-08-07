package com.itheima.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.utils.HibernateUtil;

/**
 * hibernate中的HQL查询
 * 	涉及的对象：
 * 		Query
 *  如何获取该对象
 *  	session.createQuery(String hql)
 *  参数的含义：
 *  	使用hql语句查询数据库
 *  	hql语句的写法：把表名换成实体类名称，把字段名换成实体类的属性名称
 *  
 *  HQL查询能实现的使用Criteria查询也能实现，反之亦然。
 *  但是在hibernate官网上，推荐的查询方式是HQL。
 * @author zhy
 *
 */
public class HibernateDemo5 {

	//基本查询
	@Test
	public void test1(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.获取Query对象
		Query query = s.createQuery("from Customer");
		//2.获取结果集
		List list = query.list();
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
		//1.获取Query对象
		Query query = s.createQuery("from Customer where custName like ?  and  custLevel = ?");
		//给参数占位符赋值
		query.setString(0, "23");//hibernate的参数占位符是从0开始的
		query.setString(1, "%集%");
		//2.获取结果集
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	@Test
	public void test3(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.获取Query对象
		Query query = s.createQuery("from Customer where custName like :custName  and  custLevel = :custLevel ");//给参数起名需要使用 :参数名称
		//给参数占位符赋值
//		query.setString("custLevel", "23");
//		query.setString("custName", "%集%");
		
		query.setParameter("custLevel", "23");
		query.setParameter("custName", "%集%");
		//2.获取结果集
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	
	//排序查询
	@Test
	public void test4(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.获取Query对象
		Query query = s.createQuery("from Customer order by custId desc ");
		//2.获取结果集
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	
	//分页查询
	/**
	 *  mysql分页关键字
	 *  	limit
	 *  Limit的两个参数含义
	 *  	第一个：查询的开始记录索引
	 *  	第二个：每次查询的条数
	 * 	hibernate为我们提供了两个方法：
	 * 		setFirstResult：设置查询的开始记录索引
	 * 		setMaxResults：设置每次查询的条数
	 * 
	 * 不管是用什么数据库，涉及分页的都是这两个方法。
	 * 因为SQL语句的生成已经是hibernate的事了。
	 */
	@Test
	public void test5(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.获取Query对象
		Query query = s.createQuery("from Customer");
		query.setFirstResult(2);
		query.setMaxResults(2);
		//2.获取结果集
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	//统计查询
	/**
	 * 在HQL中使用聚合函数。
	 * 聚合函数：
	 * 	  count sum avg max min
	 */
	@Test
	public void test6(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.获取Query对象
		Query query = s.createQuery("select count(*) from Customer");
		//2.获取结果集
//		List list = query.list();
//		for(Object o : list){
//			System.out.println(o);
//		}
		Long count = (Long) query.uniqueResult();//当返回的结果唯一时，可以使用此方法。如果返回的结果不唯一，使用了此方法会抛异常。
		System.out.println(count);
		tx.commit();
	}
	
	
	//投影查询
	/**
	 * 当我们在查询实体时，只需要部分字段，而是全部。并且希望它的返回结果使用实体类来封装，而不是Object[]
	 * 这个时候我们称之为创建实体类的投影
	 * 
	 * 投影查询的用法：
	 * 		1.查询语句需要时使用new关键字
	 * 		2.在实体类中添加对应参数列表的构造函数
	 */
	@Test
	public void test8(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.获取Query对象
		Query query = s.createQuery("select new com.itheima.domain.Customer(custId,custName) from Customer");
		//2.获取结果集
		List list = query.list();
		for(Object o : list){
			System.out.println(o);
		}
		tx.commit();
	}
	
	
	
	@Test
	public void test7(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1.获取Query对象
		Query query = s.createQuery("select custId,custName from Customer");
		//2.获取结果集
		List<Object[]> list = query.list();
		for(Object[] os : list){
			System.out.println("-----数组中的内容-------");
			for(Object o : os){
				System.out.println(o);
			}
		}
		tx.commit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
