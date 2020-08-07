package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.domain.CstCustomer;
import cn.itcast.utils.HibernateUtil;

public class CustomerDaoImpl implements ICustomerDao {

	public List<CstCustomer> findAllCustomer() {
		return HibernateUtil.getCurrentSession().createQuery("from CstCustomer").list();
	}
}
