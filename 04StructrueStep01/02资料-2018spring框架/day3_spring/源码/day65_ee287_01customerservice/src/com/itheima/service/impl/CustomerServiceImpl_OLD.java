package com.itheima.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.ICustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.utils.HibernateUtil;
/**
 * 客户的业务层实现类
 * @author zhy
 * 
 *事务控制在业务层的
 *//*
 *****此类的最大问题就是重复代码太多，没有使用抽取的思想*/
public class CustomerServiceImpl_OLD implements ICustomerService {
	
	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public List<Customer> findAllCustomer() {
		Session s = null;
		Transaction tx = null;
		try{
			//1.获取Session
			s = HibernateUtil.getCurrentSession();
			//2.开启事务
			tx = s.beginTransaction();
			//3.执行操作
			List<Customer> customers = customerDao.findAllCustomer();
			//4.提交事务
			tx.commit();
			//5.返回结果
			return customers;
		}catch(Exception e){
			//回滚事务
			tx.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session s = null;
		Transaction tx = null;
		try{
			//1.获取Session
			s = HibernateUtil.getCurrentSession();
			//2.开启事务
			tx = s.beginTransaction();
			//3.执行操作
			customerDao.saveCustomer(customer);
			//4.提交事务
			tx.commit();
		}catch(Exception e){
			//回滚事务
			tx.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session s = null;
		Transaction tx = null;
		try{
			//1.获取Session
			s = HibernateUtil.getCurrentSession();
			//2.开启事务
			tx = s.beginTransaction();
			//3.执行操作
			customerDao.deleteCustomer(customer);
			//4.提交事务
			tx.commit();
		}catch(Exception e){
			//回滚事务
			tx.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session s = null;
		Transaction tx = null;
		try{
			//1.获取Session
			s = HibernateUtil.getCurrentSession();
			//2.开启事务
			tx = s.beginTransaction();
			//3.执行操作
			customerDao.updateCustomer(customer);
			//4.提交事务
			tx.commit();
		}catch(Exception e){
			//回滚事务
			tx.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Customer findCustomerById(Long custId) {
		Session s = null;
		Transaction tx = null;
		try{
			//1.获取Session
			s = HibernateUtil.getCurrentSession();
			//2.开启事务
			tx = s.beginTransaction();
			//3.执行操作
			Customer customer = customerDao.findCustomerById(custId);
			//4.提交事务
			tx.commit();
			//5.返回结果
			return customer;
		}catch(Exception e){
			//回滚事务
			tx.rollback();
			throw new RuntimeException(e);
		}
	}

}