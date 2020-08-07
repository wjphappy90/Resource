class Demo2_Abstract {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}

/*
* A:抽象类的成员特点
	* a:成员变量：既可以是变量，也可以是常量。abstract是否可以修饰成员变量?不能修饰成员变量
	* b:构造方法：有。
		* 用于子类访问父类数据的初始化。
	* c:成员方法：既可以是抽象的，也可以是非抽象的。
* B:案例演示
	* 抽象类的成员特点
* C:抽象类的成员方法特性：
	* a:抽象方法 强制要求子类做的事情。
	* b:非抽象方法 子类继承的事情，提高代码复用性。
*/

abstract class Demo {
	int num1 = 10;
	final int num2 = 20;

	public Demo(){}

	public void print() {
		System.out.println("111");
	}

	public abstract void method();
}

class Test extends Demo {
	public void method() {
		System.out.println("111");
	}
}