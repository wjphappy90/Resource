package cn.itcast.day06.demo07;

public class DemoPerson {
	
	public static void main(String[] args) {
		Person yaSe = new Person(); // 默认构造
		yaSe.setName("亚瑟");
		yaSe.setAge(20);
		
		Person houYi = new Person("后羿", 18); // 有参构造
		
		// 首先让亚瑟和后羿打招呼
		// 预期效果应该是：后羿，你好。我叫亚瑟，今年20岁。
		yaSe.sayHello(houYi.getName());
		
		// 然后让后羿和亚瑟打招呼
		// 预期小国英国是：亚瑟，你好。我叫后羿，今年18岁。
		houYi.sayHello(yaSe.getName());
	}

}
