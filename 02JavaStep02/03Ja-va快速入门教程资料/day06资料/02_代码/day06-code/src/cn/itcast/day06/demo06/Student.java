package cn.itcast.day06.demo06;

/*
 * 如何定义一个“标准的类”？
 * 
 * 1. 所有的成员变量都需要使用private关键字私有化。
 * 2. 为每一个成员变量编写一对儿Getter Setter方法。
 * 3. 编写一个无参数的构造方法。
 * 4. 编写一个全参数的构造方法。
 * 
 * POJO：Plain Old Java Object
 */
public class Student {

	// 成员变量
	private String name; // 姓名
	private int age; // 年龄

	// 无参数的构造方法
	public Student() {
	}

	// 全参数的构造方法
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Getters Setter
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

}
