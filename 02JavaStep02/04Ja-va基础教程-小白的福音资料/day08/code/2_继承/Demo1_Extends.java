class Demo1_Extends {
	public static void main(String[] args) {
		Cat c = new Cat();
		c.color = "花";
		c.leg = 4;
		c.eat();
		c.sleep();

		System.out.println(c.leg  + "..." + c.color);
	}
}
/*
* A:继承(extends)
	* 让类与类之间产生关系,子父类关系 
* B:继承案例演示：
	* 动物类,猫类,狗类
	* 定义两个属性(颜色,腿的个数)两个功能(吃饭，睡觉)
* C:案例演示
	* 使用继承前
* D:案例演示
	* 使用继承后
*/
class Animal {
	String color;					//动物的颜色
	int leg;						//动物腿的个数

	public void eat() {				//吃饭的功能
		System.out.println("吃饭");
	}

	public void sleep() {			//睡觉的功能
		System.out.println("睡觉");
	}
}

class Cat extends Animal {
	
}

class Dog extends Animal {
	
}

/*
extends是继承的意思
Animal是父类
Cat和Dog都是子类
*/