class Test02 {
	public static void main(String[] args) {
		//创建基础班学生对象
		BasicClassStudent bct = new BasicClassStudent("大表哥",20);
		//调用学习方法
		bct.study();
		
		//创建就业班学生对象
		EmploymentClassStudent ect = new EmploymentClassStudent("隔壁小王",21);
		//调用学习方法
		ect.study();
	}
}

abstract class Student{
	private String name;	//姓名
	private int age;		//年龄
	
	public Student() {		//空参
	}

	public Student(String name, int age) {//有参
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {	//设置姓名
		this.name = name;
	}
	public String getName() {			//获取名字
		return name;
	}
	public int getAge() {				//设置年龄
		return age;
	}
	public void setAge(int age) {		//获取年龄
		this.age = age;
	}
	
	public abstract void study();		//抽象的学习方法
}

//基础班学生类
class BasicClassStudent extends Student{
	public BasicClassStudent() {		//空参
	}

	public BasicClassStudent(String name, int age) {//有参
		super(name, age);
	}
	
	public void study() {				
		System.out.println("基础班学生学JavaSE");
	}

}

//就业班学生类
class EmploymentClassStudent extends Student{
	public EmploymentClassStudent() {		//空参
	}

	public EmploymentClassStudent(String name, int age) {//有参
		super(name, age);
	}
	
	public void study() {
		System.out.println("就业班学生学Android");
	}
}