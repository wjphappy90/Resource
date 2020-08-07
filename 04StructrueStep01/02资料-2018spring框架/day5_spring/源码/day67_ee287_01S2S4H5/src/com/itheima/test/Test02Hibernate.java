package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itheima.domain.Customer;

/**
 * 保证hibernate框架能够独立在web工程中运行
 * @author zhy
 *
 */
public class Test02Hibernate {

	public static void main(String[] args) {
		Customer c = new Customer();
		c.setCustName("ssh整合Customer");
		//1.加载配置文件
		Configuration cfg = new Configuration();
		cfg.configure();
		//2.根据配置文件创建SessionFactory
		SessionFactory factory = cfg.buildSessionFactory();
		//3.获取session
		Session session = factory.getCurrentSession();
		//4.开启事务
		Transaction tx = session.beginTransaction();
		//5.执行操作
		session.save(c);
		//6.提交/回滚事务
		tx.commit();
		//7.释放资源
//		session.close();
		factory.close();
	}
}
