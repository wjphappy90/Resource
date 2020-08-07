package cn.itcast.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.User;

public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private List<User> users;//查询出来的用户集合
	
	private String result = "success";//在值栈里
	

	/**
	 * 处理用户列表查询
	 * @return
	 */
	public String list(){
		users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId(i+1L);
			user.setUsername("张三" + (i+1));
			user.setAge(20 + i);
			user.setAddress("上海" + (i+1));
			users.add(user);
		}
		return result;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
