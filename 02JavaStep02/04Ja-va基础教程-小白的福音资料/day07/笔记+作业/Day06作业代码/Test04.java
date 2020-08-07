public class Test04 {
	public static void main(String[] args) {
		Dog a = new Dog();	//创建狗类对象
		a.setName("旺财");	//给狗姓名赋值
		a.setAge(3);		//给狗年龄赋值
		System.out.println(a.getName() +"---"+ a.getAge()); //打印狗信息
		a.eat();	//调用吃饭方法
		a.lookHome();	//调用看家的方法
	}
}
/*
狗类Dog
			属性:姓名name,年龄age
			行为:吃饭eat，看家lookHome
 */
class Dog{
	private String name;	//姓名
	private int age;		//年龄
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
	
	public void eat() {
		System.out.println("吃饭");
	}
	public void lookHome() {
		System.out.println("狗看家");
		
	}
}