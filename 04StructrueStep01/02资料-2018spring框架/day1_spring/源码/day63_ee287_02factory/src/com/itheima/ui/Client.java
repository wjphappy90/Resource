package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 * @author zhy
 *
 */
public class Client {

	public static void main(String[] args) {
//		ICustomerService customerService = new CustomerServiceImpl();
		for(int i=0;i<5;i++){
			ICustomerService customerService = (ICustomerService) BeanFactory.getBean("CUSTOMERSERVICE");
			System.out.println(customerService);
		}
		//customerService.saveCustomer();
	}

}
