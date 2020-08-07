package cn.itcast.day09.demo02;

/*
 * 使用接口作为左侧类型的好处所在：
 * 屏蔽掉了右侧的个性特有的内容，达到隔离、统一的目的。
 */
public class Demo02Interface {
	
	public static void main(String[] args) {
		Cat cat = new Cat(); // 创建了一只猫
		method(cat); // 将猫对象传递给方法，间接使用其中的eat和sleep方法。
		
		Dog dog = new Dog(); // 创建了一条狗
		method(dog);
	}
	
	// 使用一个类作为参数类型，没问题
	public static void method(Cat cat) {
		cat.eat();
		cat.sleep();
	}
	
	public static void method(Dog dog) {
		dog.eat();
		dog.sleep();
	}

}
