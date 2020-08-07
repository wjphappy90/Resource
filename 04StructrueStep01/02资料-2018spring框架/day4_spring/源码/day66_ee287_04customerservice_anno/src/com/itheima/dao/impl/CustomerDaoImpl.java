package com.itheima.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;


/**
 * 客户的持久层实现类
 * @author zhy
 *
 */
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {
	
	@Resource(name="session")
	private Session session;//保证它是当前线程的session就行


	@Override
	public List<Customer> findAllCustomer() {
		return session.createQuery("from Customer").list();
	}

	@Override
	public void saveCustomer(Customer customer) {
		session.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		session.delete(findCustomerById(customer.getCustId()));
	}

	@Override
	public Customer findCustomerById(Long custID) {
		return session.get(Customer.class,custID);
	}

	@Override
	public void updateCustomer(Customer customer) {
		session.update(customer);
	}

}
