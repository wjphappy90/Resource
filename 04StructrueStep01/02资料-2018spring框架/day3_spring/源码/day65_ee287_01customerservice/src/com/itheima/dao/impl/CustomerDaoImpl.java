package com.itheima.dao.impl;

import java.util.List;

import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * 客户的持久层实现类
 * @author zhy
 *
 */
public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public List<Customer> findAllCustomer() {
		return HibernateUtil.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public void saveCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().delete(findCustomerById(customer.getCustId()));
	}

	@Override
	public Customer findCustomerById(Long custID) {
		return HibernateUtil.getCurrentSession().get(Customer.class,custID);
	}

	@Override
	public void updateCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().update(customer);
	}

}
