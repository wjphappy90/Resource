package com.itheima.reflect;

public class User {

	public User() {
	}

	private User(String username) {
		this.username = username;
	}

	private String username;

	public String sayHello(String msg) {

		return "hello " + msg;
	}

	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
	
	public static void sum(Integer... args){
		int sum=0;
		for(int i=0;i<args.length;i++){
			sum+=args[i];
		}
		System.out.println(sum);
	}

}
