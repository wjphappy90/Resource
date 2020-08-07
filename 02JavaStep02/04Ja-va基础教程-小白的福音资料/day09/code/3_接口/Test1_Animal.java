class Test1_Animal {
	public static void main(String[] args) {
		Cat c = new Cat("加菲",8);
		c.eat();
		c.sleep();

		JumpCat jc = new JumpCat("跳高猫",3);
		jc.eat();
		jc.sleep();
		jc.jump();
	}
}

/*
* A:案例演示
	* 动物类：姓名，年龄，吃饭，睡觉。
	* 猫和狗
	* 动物培训接口：跳高
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

	public abstract void eat();			//吃饭

	public abstract void sleep();		//睡觉
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

	public void sleep() {
		System.out.println("侧着睡");
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