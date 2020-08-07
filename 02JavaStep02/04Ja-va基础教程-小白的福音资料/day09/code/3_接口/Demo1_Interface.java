class Demo1_Interface {
	public static void main(String[] args) {
		//Inter i = new Inter();		//接口不能被实例化,因为调用抽象方法没有意义
		Inter i = new Demo();			//父类引用指向子类对象
		i.print();
	}
}
/*
* A:接口概述
	* 从狭义的角度讲就是指java中的interface
	* 从广义的角度讲对外提供规则的都是接口 
* B:接口特点
	* a:接口用关键字interface表示	
		* interface 接口名 {}
	* b:类实现接口用implements表示
		* class 类名 implements 接口名 {}
	* c:接口不能实例化
		* 那么，接口如何实例化呢?
		* 按照多态的方式来实例化。
	* d:接口的子类
		* a:可以是抽象类。但是意义不大。
		* b:可以是具体类。要重写接口中的所有抽象方法。(推荐方案)
* C:案例演示
	* 接口特点
*/

interface Inter {
	public abstract void print();					//接口中的方法都是抽象的
}

class Demo implements Inter {
	public void print() {
		System.out.println("print");
	}
}