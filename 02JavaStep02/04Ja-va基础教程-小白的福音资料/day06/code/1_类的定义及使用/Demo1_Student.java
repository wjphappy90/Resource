class Demo1_Student {
	public static void main(String[] args) {
		//创建对象的格式:类名 对象名 = new 类名();
		//对象名:其实就是合法的标识符,如果是一个单词所有字母小写,如果是多个单词,从第二个单词开始首字母大写
		Student s = new Student();
		//* D:如何使用成员变量呢?
		//* 对象名.变量名
		s.name = "张三";
		s.age = 23;

		System.out.println(s.name + "..." + s.age);
		//* E:如何使用成员方法呢?
		//* 对象名.方法名(...)
		s.study();
		s.sleep();
	}
}


/*
* A:案例演示
	* 属性:姓名,年龄,性别
	* 行为:学习,睡觉

* B:我们如何描述现实世界事物
	* 属性	就是该事物的描述信息(事物身上的名词)
	* 行为	就是该事物能够做什么(事物身上的动词)
* C:Java中最基本的单位是类,Java中用class描述事物也是如此
	* 成员变量	就是事物的属性
	* 成员方法	就是事物的行为
* D:定义类其实就是定义类的成员(成员变量和成员方法)
	* a:成员变量	和以前定义变量是一样的，只不过位置发生了改变。在类中，方法外。
	* b:成员方法	和以前定义方法是一样的，只不过把static去掉，后面在详细讲解static的作用。
*/

class Student {
	String name;						//姓名
	int age;							//年龄
	String gender;						//性别

	public void study() {				//定义学习的方法
		System.out.println("学生学习");
	}

	public void sleep() {				//定义睡觉的方法
		System.out.println("学生睡觉");
	}
}