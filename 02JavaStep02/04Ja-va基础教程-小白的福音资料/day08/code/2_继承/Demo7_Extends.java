class Demo7_Extends {
	public static void main(String[] args) {
		Son s = new Son();
		s.print();
		s.method();
	}
}
/*
* a:不同名的方法
* b:同名的方法
*/

class Father {
	public void print() {
		System.out.println("Fu print");
	}
}

class Son extends Father {
	public void method() {
		System.out.println("Zi Method");
	}

	public void print() {
		super.print();							//super可以调用父类的成员方法
		System.out.println("Zi print");
	}
}