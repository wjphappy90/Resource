package cn.itcast.day06.demo01;

/*
 * 定义一个类，用来模拟现实事物“学生”。
 * 
 * 学生事物有两个组成部分：
 * 属性：姓名、年龄
 * 行为：吃饭、睡觉、学习
 * 
 * 对应到类当中也是两个组成部分：
 * 成员变量（属性）：
 * 		String name; // 姓名
 * 		int age; // 年龄
 * 成员方法（行为）：
 * 		public void eat() {...} // 吃饭
 * 		public void sleep() {...} // 睡觉
 * 		public void study() {...} // 学习
 */
public class Student {
	
	// 成员变量
	String name; // 姓名
	int age; // 年龄
	
	// 成员方法
	public void eat() {
		System.out.println("吃饭饭！");
	}
	
	public void sleep() {
		System.out.println("睡觉觉！");
	}
	
	public void study() {
		System.out.println("学习！");
	}

}
