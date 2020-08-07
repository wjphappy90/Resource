package cn.itcast.day06.demo07;

public class Person {

	private String name; // 姓名
	private int age; // 年龄

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sayHello(String name) {
		System.out.println(name + "，你好。" + "我叫" + this.name + "，今年" + this.age + "岁。");
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

}
