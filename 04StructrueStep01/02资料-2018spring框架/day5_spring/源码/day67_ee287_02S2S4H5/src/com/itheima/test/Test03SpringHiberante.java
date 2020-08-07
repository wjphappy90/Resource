package com.itheima.test;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;

/**
 * 测试spring和hibernate整合之后是否可用
 * @author zhy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bean.xml"})
public class Test03SpringHiberante {

	@Autowired
	private ICustomerService cs;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Test
	public void testSessionThread(){
//		Session s1 = hibernateTemplate.getSessionFactory().getCurrentSession();
//		Session s2 = hibernateTemplate.getSessionFactory().getCurrentSession();
		Session s1 = hibernateTemplate.getSessionFactory().openSession();
		Session s2 = hibernateTemplate.getSessionFactory().openSession();
		System.out.println(s1 == s2);
	}
	
	
	@Test
	public void testSave(){
		Customer c = new Customer();
		c.setCustName("spring hibernate customer123");
		cs.saveCustomer(c);
		
	}
	
	@Test
	public void testFindAll(){
		List list = cs.findAllCustomer();
		for(Object o : list){
			System.out.println(o);
		}
	}
}
