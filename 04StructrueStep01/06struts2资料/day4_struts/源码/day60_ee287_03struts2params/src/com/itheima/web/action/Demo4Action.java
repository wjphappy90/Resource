package com.itheima.web.action;

import java.util.List;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 请求参数封装
 * 	复杂类型的封装：List集合封装
 * 	复杂类型的封装都需要基于第二种情况实现
 * 
 * @author zhy
 *
 */
public class Demo4Action extends ActionSupport {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * 动作方法
	 * @return
	 */
	public String demo4(){
		System.out.println(users);
		return SUCCESS;
	}
	
}
