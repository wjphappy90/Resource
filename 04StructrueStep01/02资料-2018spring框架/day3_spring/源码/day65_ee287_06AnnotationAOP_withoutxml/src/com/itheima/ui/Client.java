package com.itheima.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.service.ICustomerService;

import config.SpringConfiguration;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		cs.saveCustomer();
		
	}

}
