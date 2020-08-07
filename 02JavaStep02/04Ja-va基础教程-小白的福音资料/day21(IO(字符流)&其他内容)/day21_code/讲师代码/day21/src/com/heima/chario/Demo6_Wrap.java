package com.heima.chario;

public class Demo6_Wrap {

	/**
	 * @param args
	 * 装饰设计模式的好处是:
	 * 耦合性不强,被装饰的类的变化与装饰类的变化无关
	 */
	public static void main(String[] args) {
		HeiMaStudent hms = new HeiMaStudent(new Student());
		hms.code();
	}

}

interface Coder {
	public void code();
}

class Student implements Coder {

	@Override
	public void code() {
		System.out.println("javase");
		System.out.println("javaweb");
	}
	
}

class HeiMaStudent implements Coder {
	//1,获取被装饰类的引用
	private Student s;						//获取学生引用
	
	//2,在构造方法中传入被装饰类的对象
	public HeiMaStudent(Student s) {
		this.s = s;
	}

	//3,对原有的功能进行升级
	@Override
	public void code() {
		s.code();
		System.out.println("ssh");
		System.out.println("数据库");
		System.out.println("大数据");
		System.out.println("...");
	}
}
