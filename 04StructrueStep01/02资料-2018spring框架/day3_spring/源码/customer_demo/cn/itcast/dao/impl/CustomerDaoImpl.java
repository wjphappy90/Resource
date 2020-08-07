package cn.itcast.dao.impl;

import java.util.List;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.utils.HibernateUtil;

/**
 * 客户的持久层实现类
 * @author zhy
 *
 */
public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public void saveCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().save(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return HibernateUtil.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public void removeCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().delete(customer);
	}
	

	@Override
	public Customer findCustomerById(Long custId) {
		return HibernateUtil.getCurrentSession().get(Customer.class,custId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		HibernateUtil.getCurrentSession().update(customer);
	}

}
