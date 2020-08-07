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
public class CustomerServiceImpl implements ICustomerService {
	
	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public Customer findCustomerById(Long custId) {		
		return customerDao.findCustomerById(custId);
	}

}
