package cn.itcast.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceTest {

	@Test
	public void testFindOne() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
		CustomerService service = (CustomerService) classPathXmlApplicationContext.getBean("customerService");
		service.findOne("1");
	}

}
