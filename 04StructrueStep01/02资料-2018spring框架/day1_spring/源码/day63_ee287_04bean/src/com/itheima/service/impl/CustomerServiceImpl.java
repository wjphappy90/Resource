package com.itheima.service.impl;

import com.itheima.service.ICustomerService;

/**
 * 客户的业务层实现类
 * @author zhy
 *
 */
public class CustomerServiceImpl implements ICustomerService {

	public CustomerServiceImpl() {
		System.out.println("bean对象创建了");
	}
	
	public void init(){
		System.out.println("对象初始化了");
	}
	
	public void destroy(){
		System.out.println("对象销毁了");
	}

	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层");
	}

}
