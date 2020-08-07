class Test01 {
	public static void main(String[] args) {	
		//创建基础班老师对象
		BasicClassTeache bct = new BasicClassTeache("小宝",27);
		//调用讲课方法
		bct.teach();
		
		//创建就业班老师对象
		EmploymentClassTeacher ect = new EmploymentClassTeacher("大宝",28);
		//调用讲课方法
		ect.teach();
	}
}

abstract class Teacher{
	private String name;	//姓名
	private int age;		//年龄
	
	
	public Teacher() {		//空参
	}

	public Teacher(String name, int age) {//有参
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
	
	public abstract void teach();
}

//基础班老师类
class BasicClassTeache extends Teacher{
	public BasicClassTeache() {		//空参
	}

	public  BasicClassTeache(String name, int age) {//有参
		super(name, age);
	}
	
	public void teach() {	//讲课方法
		System.out.println("基础班老师讲JavaSE");
	}

}

//就业班老师类
class EmploymentClassTeacher extends Teacher{
	public EmploymentClassTeacher() {		//空参
	}

	public EmploymentClassTeacher(String name, int age) {//有参
		super(name, age);
	}
	public void teach() {	//讲课方法
		System.out.println("就业班老师讲Android");
	}
}