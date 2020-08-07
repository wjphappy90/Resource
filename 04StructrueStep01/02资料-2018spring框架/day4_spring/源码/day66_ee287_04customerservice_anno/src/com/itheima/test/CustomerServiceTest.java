package com.itheima.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;

import config.SpringConfiguration;

/**
 * 测试客户的业务层
 * @author zhy
 *
 */
public class CustomerServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
//		List list = cs.findAllCustomer();
//		for(Object o : list){
//			System.out.println(o);
//		}
		
		Customer c = new Customer();
		c.setCustName("ioc aop customer annotation without xml");
		cs.saveCustomer(c);
	}

}
