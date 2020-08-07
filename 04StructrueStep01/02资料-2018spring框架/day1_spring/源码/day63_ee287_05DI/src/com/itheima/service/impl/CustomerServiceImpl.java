package com.itheima.service.impl;

import java.util.Date;

import com.itheima.service.ICustomerService;

/**
 * 客户的业务层实现类
 * @author zhy
 *
 */
public class CustomerServiceImpl implements ICustomerService {

	private String driver;
	private Integer port;
	private Date today;
	//以上三个类成员，没有具体的实际意义，只是用于演示注入。
	

	public CustomerServiceImpl(String driver, Integer port, Date today) {
		this.driver = driver;
		this.port = port;
		this.today = today;
	}

	@Override
	public void saveCustomer() {
		System.out.println("业务层调用持久层"+driver+","+port+","+today);
	}




}
