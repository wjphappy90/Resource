package com.itheima.service;

public class UserServiceImpl implements IUserService {

	@Override
	public String addUser(String username, String password) {

		System.out.println("添加用户:" + username + "   " + password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "hello " + username;
	}

}
