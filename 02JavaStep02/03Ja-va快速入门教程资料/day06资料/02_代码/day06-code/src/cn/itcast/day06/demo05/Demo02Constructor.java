package cn.itcast.day06.demo05;

public class Demo02Constructor {
	
	public static void main(String[] args) {
		// 调用无参数的构造方法来创建对象
		Student one = new Student();
		
		// 调用有参数的构造方法来创建对象
		Student two = new Student(18);
		System.out.println("============");
		
		Student stu = new Student();
		stu.setName("赵丽颖");
		stu.setAge(20);
		System.out.println("姓名：" + stu.getName() + "，年龄：" + stu.getAge());
		System.out.println("============");
		
		// 直接在new的时候通过构造方法给成员变量赋值
		Student stu2 = new Student("柳岩", 18);
		System.out.println("姓名：" + stu2.getName() + "，年龄：" + stu2.getAge());
		// 改变成员变量的值
		stu2.setAge(19);
		System.out.println("姓名：" + stu2.getName() + "，年龄：" + stu2.getAge());
	}

}
