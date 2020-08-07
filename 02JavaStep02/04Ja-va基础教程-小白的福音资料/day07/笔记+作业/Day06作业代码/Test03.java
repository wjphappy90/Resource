public class Test03 {
	public static void main(String[] args) {
		Animal a = new Animal();	//创建动物类对象
		a.setName("旺财");	//给动物姓名赋值
		a.setAge(3);		//给动物年龄赋值
		System.out.println(a.getName() +"---"+ a.getAge()); //打印动物信息
		a.eat();	//调用吃饭方法
	}
}
/*
 * 动物类Animal
			属性:姓名name,年龄age
			行为:吃饭eat
 */
class Animal{
	private String name;
	private int age;
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
	
}