package com.itheima.service.impl;

import com.itheima.dao.ICustomerDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.ICustomerService;

/**
 * 客户的业务层实现类
 * @author zhy
 *
 */
public class CustomerServiceImpl implements ICustomerService {

//	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	private ICustomerDao customerDao = (ICustomerDao) BeanFactory.getBean("CUSTOMERDAO");
	
	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
		customerDao.saveCustomer();
	}

}
