package com.heima.枚举2;

public class Demo1_Enum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		//demo3();
		Week3 mon = Week3.TUE;
		switch (mon) {
		case MON:
			System.out.println("星期一");
			break;
		case TUE:
			System.out.println("星期二");
			break;
		}
	}

	public static void demo3() {
		Week3 mon = Week3.MON;
		mon.show();
	}

	public static void demo2() {
		Week2 mon = Week2.MON;
		System.out.println(mon.getName());
	}

	public static void demo1() {
		Week mon = Week.MON;
		System.out.println(mon);
	}

}
