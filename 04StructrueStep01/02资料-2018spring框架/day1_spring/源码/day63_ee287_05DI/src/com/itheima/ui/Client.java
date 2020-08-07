package com.itheima.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.ICustomerService;

/**
 * spring的入门案例
 * @author zhy
 *
 */
public class Client {
	
	/**
	 * @param args
	 */
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.根据bean的id获取对象
//		ICustomerService cs1 = (ICustomerService) ac.getBean("customerService");
//		ICustomerService cs2 = (ICustomerService) ac.getBean("customerService2");
		ICustomerService cs3 = (ICustomerService) ac.getBean("customerService3");
		cs3.saveCustomer();

	}
	
	


}
