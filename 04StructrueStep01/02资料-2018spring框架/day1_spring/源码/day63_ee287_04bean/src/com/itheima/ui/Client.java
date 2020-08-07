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
	 * ClassPahtXmlApplicationContext：它是只能加载类路径下的配置文件			我们用这个
	 * FileSystemXmlApplicationContext：它是可以加载磁盘任意位置的配置文件
	 * 
	 * Bean创建的两种规则：
	 * 	BeanFactory:
	 * 		提供的是一种延迟加载思想来创建bean对象。bean对象什么时候用什么时候创建
	 *  ApplicationContext
	 *  	提供的是一种立即加载思想来创建bean对象。只要一解析完配置文件，就立马创建bean对象。
	 * 
	 * Bean的三种创建方式：
	 * 	 第一种方式：调用默认无参构造函数创建				此种方式用的最多
	 * 			默认情况下，如果类中没有默认无参构造函数，则创建失败，会报异常
	 *  第二种方式：使用静态工厂中的方法创建对象
	 *  		需要使用bean标签的factory-method属性，指定静态工厂中创建对象的方法
	 * 	第三种方式：使用实例工厂中的方法创建
	 * Bean的作用范围：
	 * 		它是可以通过配置的方式来调整作用范围。
	 * 		配置的属性：bean标签的scope属性。
	 * 		属性的取值：
	 * 			singleton：单例的（默认值）
	 * 			prototype：多例的（当我们让spring接管struts2的action创建时，action必须配置此值）
	 * 			request：作用范围是一次请求，和当前请求的转发。
	 * 			session：作用范围是一次会话。
	 * 			globalsession ：作用范围是一次全局会话。
	 * Bean的生命周期：
	 * 		涉及bean标签的两个属性：
	 * 			init-method
	 * 			destroy-method
	 * 		单例：
	 *  		出生：容器创建，对象就出生了。
	 *  		活着：只要容器在，对象就一直存在。
	 *  		死亡：容器销毁，对象消亡。
	 * 		多例：
	 * 			出生：每次使用时，创建对象
	 * 			活着：只要对象在使用中，就一直活着
	 * 			死亡：当对象长时间不使用，并且也没有别的对象引用时，由java的垃圾回收器回收。
	 * @param args
	 */
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//1.获取容器
//		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.根据bean的id获取对象
		ICustomerService cs1 = (ICustomerService) ac.getBean("customerService");
//		ICustomerService cs = (ICustomerService) ac.getBean("staticCustomerService");
//		ICustomerService cs = (ICustomerService) ac.getBean("instanceCustomerService");
		
		ICustomerService cs2 = (ICustomerService) ac.getBean("customerService");
		cs1.saveCustomer();
//		System.out.println(cs1 == cs2);
		ac.close();
	}
	
	
//	@SuppressWarnings("all")
//	public static void main(String[] args) {
//		//1.获取容器
//		Resource resource = new ClassPathResource("bean.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		//2.根据bean的id获取对象
//		ICustomerService cs = (ICustomerService) factory.getBean("customerService");
//		
//		cs.saveCustomer();
//	}

}
