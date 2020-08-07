class Demo3_Static {
	public static void main(String[] args) {
		//method();								//错误: 无法从静态上下文中引用非静态 方法 method()
		Demo3_Static.print();					//在主方法中调用本类的静态方法,可以省略类名.,系统会默认加上
		Demo3_Static d = new Demo3_Static();	//非静态方法在调用的时候必须创建对象调用
		d.method();
	}

	public void method() {					
		System.out.println("Hello World!");		
	}

	public static void print() {
		System.out.println("Hello World!");
	}
}
