class Demo3_Extends {
	public static void main(String[] args) {
		Son s = new Son();
		s.show();
	}
}
/*
* A:继承的注意事项
	* a:子类只能继承父类所有非私有的成员(成员方法和成员变量)
	* b:子类不能继承父类的构造方法，但是可以通过super(马上讲)关键字去访问父类构造方法。
	* c:不要为了部分功能而去继承
	* 项目经理 姓名 工号 工资 奖金
	* 程序员	姓名 工号 工资
*/

class Father {
	private String name;
	private void show() {
		System.out.println("Hello World!");
	}
}

class Son extends Father {
}