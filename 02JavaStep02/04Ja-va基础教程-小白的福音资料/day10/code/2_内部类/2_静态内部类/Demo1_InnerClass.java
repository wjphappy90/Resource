class Demo1_InnerClass {
	public static void main(String[] args) {
		//外部类名.内部类名 对象名 = 外部类名.内部类对象;
		Outer.Inner oi = new Outer.Inner();
		oi.method();

		Outer.Inner2.print();
	}
}

class Outer {
	static class Inner {
		public void method() {
			System.out.println("method");
		}
	}

	static class Inner2 {
		public static void print() {
			System.out.println("print");
		}
	}
}