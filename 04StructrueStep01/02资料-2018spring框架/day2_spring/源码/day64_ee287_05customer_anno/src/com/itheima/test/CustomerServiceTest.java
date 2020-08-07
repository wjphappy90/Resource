package com.itheima.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;

import config.SpringConfiguration;
/**
 * 测试客户的业务层
 * @author zhy
 * spring整合junit
 * 	第一步：拷贝spring提供的整合jar包
 * 		spring-test-4.2.4.RELEASE.jar
 *  第二步：使用junit提供的一个注解，把原有的main函数替换掉，换成spring提供的
 *  	@RunWith
 *  	要换的类：SpringJunit4ClassRunner
 *  第三步：使用spring提供的的注解告知spring，配置文件或者注解类所在的位置
 *  	@ContextConfiguration
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfiguration.class})
public class CustomerServiceTest {

	@Autowired
	private ICustomerService cs = null;
	
	@Test
	public void testFindAllCustomer() { 
		List<Customer> list = cs.findAllCustomer();
		for(Customer c : list){
			System.out.println(c);
		}
	}

	@Test
	public void testSaveCustomer() {
		Customer c = new Customer();
		c.setCust_name("dbutils customer annotation");
		cs.saveCustomer(c);
	}

	@Test
	public void testUpdateCustomer() {
		Customer c = cs.findCustomerById(94L);
		c.setCust_address("北京市顺义区");
		cs.updateCustomer(c);
	}

	@Test
	public void testDeleteCustomer() {
		cs.deleteCustomer(95L);
	}

	@Test
	public void testFindCustomerById() {
		Customer c = cs.findCustomerById(94L);
		System.out.println(c);
	}

}
