package cn.itcast.day06.demo02;

public class Demo03PhoneThree {
	
	public static void main(String[] args) {
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
		System.out.println("====================================");
		
		// 将one当中存储的地址值赋值交给two一份
		Phone two = one;
		System.out.println(two.brand); // 苹果
		System.out.println(two.price); // 8388.0
		System.out.println(two.color); // 深空灰
		System.out.println("===================");
		
		two.brand = "三星";
		two.price = 4999.0;
		two.color = "深邃蓝";
		System.out.println(two.brand); // 三星
		System.out.println(two.price); // 4999.0
		System.out.println(two.color); // 深邃蓝
		System.out.println("===================");
		
		two.call("欧巴"); // 给欧巴打电话
		two.sendMessage(); // 群发短信
	}

}
