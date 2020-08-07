package com.itheima.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.utils.HibernateUtil;

/**
 * 一对多的查询操作
 * 		OID查询，HQL查询，QBC查询，SQL查询
 * 		hibernate中的最后一种：对象导航查询。
 * 			当两个实体之间有关联关系时（关联关系可以是4种中的任意一种）,
 * 			我们通过调用getXXX方法即可实现查询功能（功能是由hibernate提供的）
 * 			例如：
 * 				customer.getLinkMans()就可以得到当前客户下的所有联系人
 * 				linkman.getCustomer()就可以得到当前联系人的所属客户
 * 	
 * class标签的lazy：它只能管load方法是否是延迟加载。
 * set标签的lazy：它管查询关联的集合对象是否是延迟加载。
 * many-to-one的lazy：它管查询关联的主表实体是否是立即加载。
 * 
 * @author zhy
 *
 */
public class HibernateDemo2 {

	/**
	 * 查询id为1的客户下所属联系人
	 * 一对多时，根据一的一方查询多的一方时，需要使用延迟加载。（默认配置即可）
	 */
	@Test
	public void test1(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, 1L);//查询id为1的客户
		System.out.println(c);
		Set<LinkMan> linkmans = c.getLinkmans();
		System.out.println(linkmans);
		tx.commit();
	}
	
	/**
	 * 查询id为5的联系人属于哪个客户
	 * 多对一时，根据多的一方查询一的一方时，不需要使用延迟加载，而是使用立即加载，需要配置一下
	 * 需要找到联系人的映射配置文件：在many-to-one标签上使用lazy属性。
	 * 		取值有：
	 * 			false：使用立即加载。
	 * 			proxy：是看load方法是延迟加载还是立即加载
	 * 		 no-proxy：不管
	 */
	@Test
	public void test2(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		LinkMan l = s.get(LinkMan.class, 5L);
		System.out.println(l);
		Customer c = l.getCustomer();
		System.out.println(c);
		tx.commit();
	}
	
	/**
	 * 关于load方法改为立即加载的方式
	 * 	 找到查询实体的映射配置文件，它的class标签上也有一个lazy属性。含义是：是否延迟加载
	 * 			true：延迟加载(默认值)
	 * 		   false：立即加载
	 */
	@Test
	public void test3(){
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.load(Customer.class, 1L);
		System.out.println(c);
		tx.commit();
	}
}
