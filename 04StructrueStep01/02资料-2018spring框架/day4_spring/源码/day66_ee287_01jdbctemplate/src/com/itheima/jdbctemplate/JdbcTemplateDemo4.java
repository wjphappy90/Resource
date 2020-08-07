package com.itheima.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;

/**
 * JdbcTemplate在dao中的用法
 * @author zhy
 *
 */
public class JdbcTemplateDemo4 {

	public static void main(String[] args){
		//1.获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.跟id获取bean对象
		IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao2");
		//3.执行操作
		Account account = accountDao.findAccountById(1);
		System.out.println(account);
//		account.setMoney(4567f);
//		accountDao.updateAccount(account);
	}

}
