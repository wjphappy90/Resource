class Demo1_Student {
	public static void main(String[] args) {
		print(10);

		Student s = new Student();					//创建对象,并将对象的地址值赋值给s
		print(s);
	}

	public static void print(int x) {				//基本数据类型当作形式参数
		System.out.println(x);
	}

	public static void print(Student stu) {			//引用数据类型当作形式参数
		stu.name = "张三";
		stu.age = 23;
		stu.speak();
	}
}

/*
* A:方法的参数是类名public void print(Student s){}//print(new Student());
	* 如果你看到了一个方法的形式参数是一个类类型(引用类型)，这里其实需要的是该类的对象。
*/
class Student {
	String name;					//姓名
	int age;						//年龄

	public void speak() {
		System.out.println(name + "..." + age);
	}
}