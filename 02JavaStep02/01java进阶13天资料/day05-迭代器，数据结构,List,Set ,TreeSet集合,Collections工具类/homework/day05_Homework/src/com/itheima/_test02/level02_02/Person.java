package com.itheima._test02.level02_02;

/*
 * 自定义人类:包含姓名,年龄,身高属性.私有成员变量,生成无参,有参构造方法,生成get/set方法.
 */
// 1.定义学人类生成类无参,有参构造方法,生成get/set方法.
public class Person {
	private String name;

	private int age;

	private double height;

	public Person() {
	}

	public Person(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public String getName() {
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
