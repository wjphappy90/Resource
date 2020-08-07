package com.itheima.jdbc.demo4;

import org.junit.Test;

/**
 * SQL注入的漏洞
 * @author jt
 *
 */
public class JDBCDemo4 {

	@Test
	/**
	 * SQL注入漏洞的演示
	 */
	public void demo1(){
		UserDao userDao = new UserDao();
//		boolean flag = userDao.login("aaa", "123");
//		boolean flag = userDao.login("aaa' or '1=1", "asdfjklsd");
		boolean flag = userDao.login("aaa' -- ", "qweqwersdfsd");
		if(flag){
			System.out.println("登录成功!");
		}else{
			System.out.println("登录失败!");
		}
	}
}
