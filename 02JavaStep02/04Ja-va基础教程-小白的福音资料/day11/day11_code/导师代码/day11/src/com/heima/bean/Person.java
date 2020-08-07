package com.heima.bean;

public class Person extends Object{

	private String name;
	private int age;

	public Person() {   					//alt + shift + s 再 + c 生成空参构造
		super();
	}

	public Person(String name, int age) {  	//alt + shift + s 再 + o 根据本地字段(成员变量)生成有参构造
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {				//alt + shift + s 再 + r 生成get和set方法
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
