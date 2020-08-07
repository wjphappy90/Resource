package com.heima.test;

public class Test3 {

	/**
	 * * A:案例演示
	* public void setProperty(Object obj, String propertyName, Object value){}，
	* 此方法可将obj对象中名为propertyName的属性的值设置为value。
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Student s = new Student("张三", 23);
		System.out.println(s);
		
		Tool t = new Tool();
		t.setProperty(s, "name", "李四");
		System.out.println(s);
	}

}

class Student {
	private String name;
	private int age;
	public Student() {
		super();
		
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}