class Test2_Teacher {
	public static void main(String[] args) {
		BaseTeacher bt = new BaseTeacher("冯佳",18);
		bt.teach();
	}
}
/*
* 具体事物：基础班老师，就业班老师
	* 共性：姓名，年龄，讲课。
*/

abstract class Teacher {
	private String name;				//姓名
	private int age;					//年龄

	public Teacher(){}					//空参

	public Teacher(String name,int age) {//有参
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {	//设置姓名
		this.name = name;
	}

	public String getName() {			//获取姓名
		return name;
	}

	public void setAge(int age) {		//设置年龄
		this.age = age;
	}

	public int getAge() {				//获取年龄
		return age;
	}

	public abstract void teach();
}

class BaseTeacher extends Teacher {
	public BaseTeacher(){}					//空参

	public BaseTeacher(String name,int age) {//有参
		super(name,age);
	}

	public void teach() {
		System.out.println("我的姓名是:" + this.getName() + ",我的年龄是:" + this.getAge() + ",讲的内容是java基础");
	}
}