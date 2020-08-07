package com.itheima._test02.level02_01;
/*
 * 自定义学生类:包含姓名,年龄,成绩属性.私有成员变量,生成无参,有参构造方法,生成get/set方法.
 */
// 1.定义学生类生成类无参,有参构造方法,生成get/set方法.
public class Student {
	private String name;

	private int age;

	private double score;

	public Student() {
	}

	public Student(String name, int age, double score) {
		this.name = name;
		this.age = age;
		this.score = score;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
