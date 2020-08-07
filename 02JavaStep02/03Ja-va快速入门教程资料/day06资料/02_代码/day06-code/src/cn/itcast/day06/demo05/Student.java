package cn.itcast.day06.demo05;

/*
 * 构造方法也是一种方法，所以也可以进行方法重载（Overload）。
 * 重载：方法的名称相同，但是参数列表不同。
 * 
 * 构造方法重载的好处：
 * 定义一个无参数的构造方法，可以直接new对象。
 * 定义一个重载的全参数的构造方法，可以在new对象的同时方便对成员变量进行赋值。
 */
public class Student {
	
	private String name; // 姓名
	private int age; // 年龄
	
	public Student() {
		System.out.println("无参数的构造方法执行！");
	}
	
	public Student(int num) {
		System.out.println("有参数的构造方法执行！" + num);
	}
	
	public Student(String str, int num) {
		name = str;
		age = num;
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
