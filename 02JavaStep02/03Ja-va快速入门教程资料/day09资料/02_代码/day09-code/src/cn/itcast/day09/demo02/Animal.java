package cn.itcast.day09.demo02;

/*
 * 如何定义一个抽象方法：
 * 
 * public abstract 返回值类型 方法名称(参数类型 参数名称);
 * 
 * 注意：
 * 1. 接口中的抽象方法，修饰如果写必须是：public abstract
 * 2. 接口中的抽象方法，修饰符可以省略不写，默认就是：public abstract
 * 3. 抽象方法只有方法头，不能有方法体大括号。
 */
public interface Animal {
	
	// 定义了一个抽象方法：吃东西
	public abstract void eat();
	
	// 定义了另一个抽象方法：睡觉
	// 省略了public abstract也照样是抽象方法
	/*public abstract*/ void sleep();

}
