class Test1_Animal {
	public static void main(String[] args) {
		Cat c = new Cat("加菲",8);
		System.out.println(c.getName() + "..." + c.getAge());
		c.eat();
		c.catchMouse();

		Dog d = new Dog("八公",30);
		System.out.println(d.getName() + "..." + d.getAge());
		d.eat();
		d.lookHome();
	}
}
/*
* A:案例演示
	* 具体事物：猫，狗
	* 共性：姓名，年龄，吃饭
	* 猫的特性:抓老鼠
	* 狗的特性:看家
*/
abstract class Animal {
	private String name;				//姓名
	private int age;					//年龄

	public Animal(){}					//空参

	public Animal(String name,int age) {//有参
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
}

class Cat extends Animal {
	public Cat(){}					//空参

	public Cat(String name,int age) {//有参
		super(name,age);
	}

	public void eat() {
		System.out.println("猫吃鱼");
	}

	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal {
	public Dog(){}					//空参

	public Dog(String name,int age) {//有参
		super(name,age);
	}

	public void eat() {
		System.out.println("狗吃肉");
	}

	public void lookHome() {
		System.out.println("看家");
	}
}