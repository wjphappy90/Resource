public class Test05 {
	public static void main(String[] args) {
		Cat a = new Cat();	//创建猫类对象
		a.setName("旺财");	//给猫姓名赋值
		a.setAge(3);		//给猫年龄赋值
		System.out.println(a.getName() +"---"+ a.getAge()); //打印猫信息
		a.eat();	//调用吃饭方法
		a.catchMouse();//调用抓老鼠的方法
	}
}
/*
猫类Cat
			属性:姓名name,年龄age
			行为:吃饭eat，抓老鼠catchMouse
 */
class Cat{
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
	public void catchMouse() {
		System.out.println("猫抓老鼠");
		
	}
}