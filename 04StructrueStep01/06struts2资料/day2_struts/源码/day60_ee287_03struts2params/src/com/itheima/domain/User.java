package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private String username;
	private Integer age;
	private Date birthday;
	private String hobby;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", birthday=" + birthday + ", hobby=" + hobby + "]";
	}
	
}
