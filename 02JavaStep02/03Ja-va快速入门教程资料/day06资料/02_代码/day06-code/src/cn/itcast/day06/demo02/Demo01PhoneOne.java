package cn.itcast.day06.demo02;

/*
 * 如何使用定义好的类？
 * 
 * 类就是一种引用数据类型，使用起来可以分成三个步骤：
 * 
 * 1. 导包
 * 如果需要使用的目标类，和当前类（含有main方法）位于同一个包下的，那么可以省略导包不写。
 * 否则需要使用import导包语句。
 * 
 * 2. 创建
 * 类名称 对象名 = new 类名称();
 * 
 * 3. 使用
 * 使用成员变量：对象名.成员变量名
 * 调用成员方法：对象名.成员方法名(参数)
 */
public class Demo01PhoneOne {
	
	public static void main(String[] args) {
		// 根据Phone类创建了一个手机对象，名叫one。
		Phone one = new Phone();
		
		// 访问成员变量的默认值
		System.out.println(one.brand); // null
		System.out.println(one.price); // 0.0
		System.out.println(one.color); // null
		System.out.println("===================");
		
		one.brand = "苹果";
		one.price = 8388.0;
		one.color = "深空灰";
		System.out.println(one.brand); // 苹果
		System.out.println(one.price); // 8388.0
		System.out.println(one.color); // 深空灰
		System.out.println("===================");
		
		// 调用成员方法
		one.call("乔布斯"); // 给乔布斯打电话
		one.sendMessage(); // 群发短信
	}

}
