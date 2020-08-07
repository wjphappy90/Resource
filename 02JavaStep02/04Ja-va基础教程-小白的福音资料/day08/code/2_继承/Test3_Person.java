class Test3_Person {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
/*
* 使用继承前的学生和老师案例
	* 属性:姓名,年龄
	* 行为:吃饭
	* 老师有特有的方法:讲课
	* 学生有特有的方法:学习
*/

class Student {
	private String name;					//姓名
	private int age;						//年龄

	public Student() {}						//空参构造

	public Student(String name,int age) {	//有参构造
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {		//设置姓名
		this.name = name;
	}

	public String getName() {				//获取姓名
		return name;
	}

	public void setAge(int age) {			//设置年龄
		this.age = age;
	}

	public int getAge() {					//获取年龄
		return age;
	}

	public void eat() {						//吃饭
		System.out.println("学生吃饭");
	}

	public void study() {					//学习
		System.out.println("学生学习");
	}
}

class Teacher {
	private String name;					//姓名
	private int age;						//年龄

	public Teacher() {}						//空参构造

	public Teacher(String name,int age) {	//有参构造
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {		//设置姓名
		this.name = name;
	}

	public String getName() {				//获取姓名
		return name;
	}

	public void setAge(int age) {			//设置年龄
		this.age = age;
	}

	public int getAge() {					//获取年龄
		return age;
	}

	public void eat() {						//吃饭
		System.out.println("老师吃饭");
	}

	public void teach() {					//学习
		System.out.println("老师讲课");
	}
}