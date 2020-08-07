package com.itheima.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.ICustomerService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs1 =(ICustomerService) ac.getBean("customerService");
//		System.out.println(cs);
//		cs.saveCustomer();
		
		ICustomerService cs2 =(ICustomerService) ac.getBean("customerService");
		System.out.println(cs1 == cs2);
	}

}
