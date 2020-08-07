package cn.itcast.day06.demo04;

public class Demo01Person {
	
	public static void main(String[] args) {
		Person person = new Person();
		
		// 设置自己的名字叫做王健林
		person.name = "王健林";
		
		// 和对方王思聪打招呼
		person.sayHello("王思聪");
	}

}
