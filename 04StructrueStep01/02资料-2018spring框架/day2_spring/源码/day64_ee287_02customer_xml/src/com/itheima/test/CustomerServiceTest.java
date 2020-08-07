package com.itheima.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
/**
 * 测试客户的业务层
 * @author zhy
 *
 */
public class CustomerServiceTest {

	@Test
	public void testFindAllCustomer() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		List<Customer> list = cs.findAllCustomer();
		for(Customer c : list){
			System.out.println(c);
		}
	}

	@Test
	public void testSaveCustomer() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		Customer c = new Customer();
		c.setCust_name("dbutils customer");
		cs.saveCustomer(c);
	}

	@Test
	public void testUpdateCustomer() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
		Customer c = cs.findCustomerById(94L);
		c.setCust_address("北京市顺义区");
		cs.updateCustomer(c);
	}

	@Test
	public void testDeleteCustomer() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
	}

	@Test
	public void testFindCustomerById() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
	}

}
