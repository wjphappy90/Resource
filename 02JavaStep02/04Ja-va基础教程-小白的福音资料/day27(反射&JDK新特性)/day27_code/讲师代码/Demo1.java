class Demo1 {
	public static void main(String[] args) {
		/*Demo d = new Demo();
		d.print();

		Inter.method();*/

		Demo d = new Demo();
		d.run();
	}
}

interface Inter {
	public default void print() {
		System.out.println("Hello World");
	}

	public static void method() {
		System.out.println("static method");
	}
}

class Demo implements Inter {
	public void run() {
		int num = 10;							//JDK8,前面的final可以省略
		class Inner {
			public void fun() {
				System.out.println(num);
			}
		}

		Inner i = new Inner();
		i.fun();
	}
}