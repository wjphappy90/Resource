package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.dao.ILinkManDao;
import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.dao.impl.LinkManDaoImpl;
import cn.itcast.domain.CstCustomer;
import cn.itcast.domain.CstLinkMan;
import cn.itcast.service.ICustomerManagementService;
import cn.itcast.utils.HibernateUtil;

/**
 * 客户管理模块的业务层实现类
 * @author zhy
 */
public class CustomerManagementServiceImpl implements ICustomerManagementService {

	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	
	public List<CstCustomer> findAllCustomer() {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			List<CstCustomer> customers = customerDao.findAllCustomer();
			tx.commit();
			return customers;
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException(e);
		}
	}
}
