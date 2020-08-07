package com.itheima.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
/**
 * 客户的业务层实现类
 * @author zhy
 * 
 *事务控制在业务层的
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
	
	@Resource(name="customerDao")
	private ICustomerDao customerDao;
	

	@Override
	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		int i=1/0;
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
