package cn.itcast.day09.demo02;

/*
 * 如果要想使用定义好的接口，必须有一个接口的“实现类”。
 * 定义实现类格式为：
 * 
 * public class 实现类名称 implements 接口名称 {
 * 		// 一定要覆盖重写所有的抽象方法
 * }
 * 
 * 什么是覆盖重写（Override）抽象方法？
 * 1. 将接口当中的抽象方法抄写过来
 * 2. 去掉abstract关键字
 * 3. 写上大括号方法体
 * 
 * Cat就是Animal接口的实现类，Cat类实现了Animal接口。
 */
public class Cat implements Animal {
	
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public void sleep() {
		System.out.println("猫睡觉");
	}
	
	// 这是一个Cat自己特有的方法，接口当中并没有定义
	public void catchMouse() {
		System.out.println("猫抓老鼠");
	}

}
