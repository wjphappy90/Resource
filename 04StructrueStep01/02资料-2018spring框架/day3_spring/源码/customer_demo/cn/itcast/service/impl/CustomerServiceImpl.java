package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.service.ICustomerService;
import cn.itcast.utils.HibernateUtil;
/**
 * 客户的业务层实现类
 * @author zhy
 * 事务必须在此控制
 * 业务层都是调用持久层的方法
 */
public class CustomerServiceImplOLD implements ICustomerService {

	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public void saveCustomer(Customer customer) {
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			customerDao.saveCustomer(customer);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Customer findCustomerById(Long custId) {
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			Customer c = customerDao.findCustomerById(custId);
			tx.commit();
			return c;
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Customer> findAllCustomer() {	
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			List<Customer> cs = customerDao.findAllCustomer();
			tx.commit();
			return cs;
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public void removeCustomer(Customer customer) {	
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			customerDao.removeCustomer(customer);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException(e);
		}
	}


	@Override
	public void updateCustomer(Customer customer) {
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.getCurrentSession();
			tx = s.beginTransaction();
			customerDao.updateCustomer(customer);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException(e);
		}
	}
}
