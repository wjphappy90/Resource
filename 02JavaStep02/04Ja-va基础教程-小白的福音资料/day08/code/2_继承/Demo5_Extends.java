class Demo5_Extends {
	public static void main(String[] args) {
		Son s = new Son();
	}
}
/*
* A:案例演示
	* 子类中所有的构造方法默认都会访问父类中空参数的构造方法
* B:为什么呢?
	* 因为子类会继承父类中的数据，可能还会使用父类的数据。
	* 所以，子类初始化之前，一定要先完成父类数据的初始化。
	
	* 其实：
		* 每一个构造方法的第一条语句默认都是：super() Object类最顶层的父类。
*/

class Father extends Object {
	public Father() {
		super();
		System.out.println("Father 的构造方法");
	}
}

class Son extends Father {
	public Son() {
		super();							//这是一条语句,如果不写,系统会默认加上,用来访问父类中的空参构造
		System.out.println("Son 的构造方法");
	}
}