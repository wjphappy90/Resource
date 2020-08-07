package com.itheima.web.action;

import java.util.Map;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 请求参数封装
 * 	复杂类型的封装：Map集合封装
 * 	复杂类型的封装都需要基于第二种情况实现
 * 
 * @author zhy
 *
 */
public class Demo5Action extends ActionSupport {

	private Map<String,User> users;

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}



	/**
	 * 动作方法
	 * @return
	 */
	public String demo5(){
		System.out.println(users);
		return SUCCESS;
	}
	
}
