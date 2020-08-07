package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * hibernate的一级缓存
 * @author zhy
 *
 */
public class HibernateDemo2 {
	
	/**
	 *  证明一级缓存确实存在
	 */
	@Test
	public void test1(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//1.根据id查询客户
		Customer c1 = s.get(Customer.class,1L);//先去数据库查询，并且把查询的结果存入了一级缓存之中
		System.out.println(c1);
		//2.根据id再次查询客户
		Customer c2 = s.get(Customer.class,1L);//先去一级缓存中看看有没有，如果有的话，直接拿过来用，如果没有的话，再去查询。
		System.out.println(c2);
		System.out.println(c1==c2);//true
		tx.commit();
		s.close();//session关闭，一级缓存就消失了
	}
	
	/**
	 * 
	 */
	@Test
	public void test2(){
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		//1.根据id查询客户
		Customer c5 = s.get(Customer.class,5L);
		System.out.println(c5.getCustAddress());//输出客户的地址：北京市顺义区

		//2.修改客户的地址为  黑马程序员顺义校区
		c5.setCustAddress("黑马程序员顺义校区");
		
		System.out.println(c5.getCustAddress());//输出客户的地址：黑马程序员顺义校区
		
		//没有写update语句
		tx.commit();
		s.close();//session关闭，一级缓存就消失了
		
		//打印c5的address，这个c5能不能用   答案是可以使用。
		System.out.println(c5.getCustAddress());//此时输出是什么  北京市顺义区 | 黑马程序员顺义校区
	}
}
