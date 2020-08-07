package cn.itcast.day07.demo03;

import java.util.ArrayList;

/*
 * 集合可以存放任何一种引用类型，包含我们自定义的Person类对象。
 */
public class Demo05ArrayListCustom {
	
	public static void main(String[] args) {
		// 首先创建几个Person对象
		Person one = new Person("迪丽热巴", 18);
		Person two = new Person("古力娜扎", 19);
		Person three = new Person("玛尔扎哈", 200);
		
		// 准备一个集合，用来存放多个Person对象
		ArrayList<Person> list = new ArrayList<>();
		
		// 将对象添加到集合当中
		list.add(one);
		list.add(two);
		list.add(three);
		
		// 遍历集合
		for (int i = 0; i < list.size(); i++) {
			Person per = list.get(i);
			System.out.println("姓名：" + per.getName() + "，年龄：" + per.getAge());
		}
	}

}
