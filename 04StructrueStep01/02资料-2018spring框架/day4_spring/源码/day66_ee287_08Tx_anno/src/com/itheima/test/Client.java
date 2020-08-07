package com.itheima.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.service.IAccountService;

import config.SpringConfiguration;

/**
 * 测试类
 * @author zhy
 *
 */
public class Client {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		IAccountService accountService = (IAccountService) ac.getBean("accountService");
//		Account account = accountService.findAccountById(1);
//		System.out.println(account);
		accountService.transfer("aaa", "bbb", 100f);
	}

}
