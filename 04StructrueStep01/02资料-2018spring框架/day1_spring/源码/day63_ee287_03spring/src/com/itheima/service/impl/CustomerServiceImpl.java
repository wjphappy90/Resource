package com.itheima.service.impl;

import com.itheima.dao.ICustomerDao;
import com.itheima.service.ICustomerService;

/**
 * 客户的业务层实现类
 * @author zhy
 *
 */
public class CustomerServiceImpl implements ICustomerService {


	private ICustomerDao customerDao = null;	
	
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
		customerDao.saveCustomer();
	}

}
