package cn.itcast.day09.demo02;

/*
 * 使用接口作为左侧类型的好处所在：
 * 屏蔽掉了右侧的个性特有的内容，达到隔离、统一的目的。
 * 
 * 面向接口编程：
 * 如果使用的功能，接口已经可以满足，那么就不在乎具体的类是谁，只在乎接口即可。
 */
public class Demo03InterfaceBetter {
	
	public static void main(String[] args) {
		Cat cat = new Cat(); // 创建了一只猫
		method(cat); // 将猫对象传递给方法，间接使用其中的eat和sleep方法。
		
		Dog dog = new Dog(); // 创建了一条狗
		method(dog);
		
		Animal animalA = cat;
		Animal animalB = dog;
	}
	
	// 使用接口作为参数类型，这样就不区分到底是猫还是狗。
	public static void method(Animal animal) {
		animal.eat();
		animal.sleep();
//		animal.watchHouse(); // 错误！无法调用狗专有的方法
//		animal.catchMouse(); // 错误！无法调用猫专有的方法
	}
	
}
