class Demo2_InnerClass {
	public static void main(String[] args) {
		//Outer.Inner oi = new Outer().new Inner();
		//oi.method();

		Outer o = new Outer();
		o.print();
	}
}

class Outer {
	private int num = 10;
	private class Inner {
		public void method() {
			System.out.println(num);
		}
	}

	public void print() {
		Inner i = new Inner();
		i.method();
	}
}