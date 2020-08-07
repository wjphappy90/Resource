class Test5_Animal {
	public static void main(String[] args) {
		Cat c1 = new Cat("花",4);
		System.out.println(c1.getColor() + "..." + c1.getLeg());
		c1.eat();
		c1.catchMouse();

		Dog d1 = new Dog("黑",2);
		System.out.println(d1.getColor() + "..." + d1.getLeg());
		d1.eat();
		d1.lookHome();
	}
}
/*
* A:猫狗案例分析
* B:案例演示
	* 猫狗案例继承版
	* 属性:毛的颜色,腿的个数
	* 行为:吃饭
	* 猫特有行为:抓老鼠catchMouse
	* 狗特有行为:看家lookHome
*/

class Animal {
	private String color;					//毛的颜色
	private int leg;						//腿的个数

	public Animal(){}

	public Animal(String color,int leg) {
		this.color = color;
		this.leg = leg;
	}

	public void setColor(String color) {	//设置颜色
		this.color = color;
	}

	public String getColor() {				//获取颜色
		return color;
	}

	public void setLeg(int leg) {			//设置腿的个数
		this.leg = leg;
	}

	public int getLeg() {					//获取腿的个数
		return leg;
	}

	public void eat() {						//吃饭
		System.out.println("吃饭");
	}
}

class Cat extends Animal {
	public Cat() {}							//空参构造

	public Cat(String color,int leg) {		//有参构造
		super(color,leg);
	}

	public void eat() {						//吃鱼
		System.out.println("猫吃鱼");
	}

	public void catchMouse() {				//抓老鼠
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal {
	public Dog() {}							//空参构造

	public Dog(String color,int leg) {		//有参构造
		super(color,leg);
	}

	public void eat() {						//吃肉
		System.out.println("狗吃肉");
	}

	public void lookHome() {				//看家
		System.out.println("看家");
	}
}