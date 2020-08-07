package com.itheima.service;

import org.junit.Test;

import com.itheima.utils.ProxyBuilder;

public class UserServiceTest {

	@Test
	public void test1(){
		//1.创建目标
		IUserService userService=new UserServiceImpl();
		
		//2.通过ProxyBuilder工具创建一个代理对象
		ProxyBuilder pb=new ProxyBuilder(userService);
		
		IUserService proxy = (IUserService) pb.createProxy();
		
		String str = proxy.addUser("tom", "123");
		
		System.out.println(str);
		
	}
}
