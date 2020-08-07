package cn.itcast.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String username;
	private Integer age;
	private String address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", age=" + age + ", address=" + address + "]";
	}
	
}
