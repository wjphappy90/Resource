package cn.itcast.day09.demo02;

public class Dog implements Animal {
	
	public void eat() {
		System.out.println("狗吃骨头");
	}
	
	public void sleep() {
		System.out.println("狗睡觉");
	}
	
	// 特有方法
	public void watchHouse() {
		System.out.println("狗看家");
	}

}
