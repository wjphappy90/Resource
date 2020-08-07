public class Test02 {
	public static void main(String[] args) {
		Person p = new Person();	//创建人类的对象
		p.setName("张三");			//给人的名字赋值
		p.setAge(18);				//给人的年龄赋值
		p.setGender("男");			//给人的性别赋值
		System.out.println(p.getName() + "---" + p.getAge() +"---"+ p.getGender());//打印人的信息
		p.study();
		p.sleep();
	}
}

class Person {
	private String name;//姓名
	private int age;	//年龄
	private String gender;//性别
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void study() {
		System.out.println("学习");
	}
	
	public void sleep() {
		System.out.println("睡觉");
	}
}
