package com.itheima.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;

/**
 * 测试客户的业务层
 * @author zhy
 *
 */
public class CustomerServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		List list = cs.findAllCustomer();
		for(Object o : list){
			System.out.println(o);
		}
		
//		Customer c = new Customer();
//		c.setCustName("ioc aop customer");
//		cs.saveCustomer(c);
	}

}
