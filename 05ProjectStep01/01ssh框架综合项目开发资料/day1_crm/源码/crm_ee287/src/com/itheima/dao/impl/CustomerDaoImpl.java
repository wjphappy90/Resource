package com.itheima.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
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

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Customer> findAll(DetachedCriteria dCriteria) {
		return (List<Customer>) hibernateTemplate.findByCriteria(dCriteria);
	}

	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}

}
