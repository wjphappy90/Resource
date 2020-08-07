class Test05 {
	public static void main(String[] args) {
		Cat c = new Cat("加菲",8);	//创建猫类对象，并使用有参构造初始化属性值
		c.eat();					//调用猫的吃方法
		c.sleep();					//调用睡觉方法

		JumpCat jc = new JumpCat("跳高猫",3);//创建会跳猫类的对象，并使用有参构造初始化属性值
		jc.eat();					//调用跳猫的吃的方法
		jc.sleep();					//调用睡觉的方法
		jc.jump();					//调用跳猫的跳的方法
	}
}

/*
* 已知动物类（姓名，年龄，吃饭，睡觉），它有两个子类，分别是猫类和狗类。
		不同的是猫吃鱼，狗吃肉。
		经过马戏团的培训后，部分猫会跳高，部分狗也会跳高。

*/

abstract class Animal {
	private String name;				//姓名
	private int age;					//年龄

	public Animal() {}					//空参构造

	public Animal(String name,int age) {//有参构造
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

	public void sleep() {				//睡觉
		System.out.println("动物睡觉");
	}
	public abstract void eat();			//吃饭
	
}

interface Jumping {						//跳高的接口
	public void jump();
}

class Cat extends Animal {
	public Cat() {}					//空参构造

	public Cat(String name,int age) {//有参构造
		super(name,age);
	}

	public void eat() {
		System.out.println("猫吃鱼");
	}


}

class JumpCat extends Cat implements Jumping {
	public JumpCat() {}					//空参构造

	public JumpCat(String name,int age) {//有参构造
		super(name,age);
	}

	public void jump() {
		System.out.println("猫跳高");
	}
}

class Dog extends Animal {
	public Dog() {}					//空参构造

	public Dog(String name,int age) {//有参构造
		super(name,age);
	}

	public void eat() {
		System.out.println("狗吃肉");
	}

	
}

class JumpDog extends Dog implements Jumping {
	public JumpDog() {}					//空参构造

	public JumpDog(String name,int age) {//有参构造
		super(name,age);
	}

	public void jump() {
		System.out.println("狗跳高");
	}
}