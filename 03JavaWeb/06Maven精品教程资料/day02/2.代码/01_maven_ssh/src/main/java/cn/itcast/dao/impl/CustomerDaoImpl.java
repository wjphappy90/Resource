package cn.itcast.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	public Customer findOne(String custId) {
		return this.getHibernateTemplate().get(Customer.class, custId);
	}

	
}
