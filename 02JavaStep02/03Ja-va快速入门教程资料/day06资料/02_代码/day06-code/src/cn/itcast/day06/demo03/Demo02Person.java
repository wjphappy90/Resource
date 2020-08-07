package cn.itcast.day06.demo03;

public class Demo02Person {
	
	public static void main(String[] args) {
		Person person = new Person();
		
		person.show(); // 我叫null，今年0岁。
		
		person.name = "赵丽颖";
//		person.age = 30; // 错误写法！private的内容不能直接访问
		person.setAge(25);
		
		person.show(); // 我叫赵丽颖，今年25岁。
	}

}
