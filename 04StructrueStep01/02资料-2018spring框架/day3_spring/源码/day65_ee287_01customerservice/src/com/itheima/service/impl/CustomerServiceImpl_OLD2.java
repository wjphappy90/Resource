package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.ICustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.utils.HibernateUtil;
import com.itheima.utils.TransactionManager;
/**
 * 客户的业务层实现类
 * @author zhy
 * 
 *事务控制在业务层的
 */
/*****此类中我们使用抽取的思想，但是仍然会有很多重复代码*/
public class CustomerServiceImpl_OLD2 implements ICustomerService {
	
	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public List<Customer> findAllCustomer() {
		try{
			//1.开启事务
			TransactionManager.beginTransaction();
			//3.执行操作
			List<Customer> customers = customerDao.findAllCustomer();
			//4.提交事务
			TransactionManager.commit();
			//5.返回结果
			return customers;
		}catch(Exception e){
			//回滚事务
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void saveCustomer(Customer customer) {
		try{
			//1.开启事务
			TransactionManager.beginTransaction();
			//3.执行操作
			customerDao.saveCustomer(customer);
			//4.提交事务
			TransactionManager.commit();
		}catch(Exception e){
			//回滚事务
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		try{
			//1.开启事务
			TransactionManager.beginTransaction();
			//3.执行操作
			customerDao.deleteCustomer(customer);
			//4.提交事务
			TransactionManager.commit();
		}catch(Exception e){
			//回滚事务
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		try{
			//1.开启事务
			TransactionManager.beginTransaction();
			//3.执行操作
			customerDao.updateCustomer(customer);
			//4.提交事务
			TransactionManager.commit();
		}catch(Exception e){
			//回滚事务
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Customer findCustomerById(Long custId) {		
		try{
			//1.开启事务
			TransactionManager.beginTransaction();
			//3.执行操作
			Customer customer = customerDao.findCustomerById(custId);
			//4.提交事务
			TransactionManager.commit();
			//5.返回结果
			return customer;
		}catch(Exception e){
			//回滚事务
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}
	}

}
