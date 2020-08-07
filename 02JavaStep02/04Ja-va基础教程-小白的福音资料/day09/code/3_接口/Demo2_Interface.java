class Demo2_Interface {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.print();
		System.out.println(Inter.num);
	}
}
/*
* 成员变量；只能是常量，并且是静态的并公共的。
			* 默认修饰符：public static final	三个关键字可以互相交换位置
			* 建议：自己手动给出。
	* 构造方法：接口没有构造方法。
	* 成员方法：只能是抽象方法。
			* 默认修饰符：public abstract
			* 建议：自己手动给出。
*/
interface Inter {
	public static final int num = 10;
	//public Inter(){}					接口中没有构造方法

	/*public void print() {				接口中不能定义非抽象方法
	
	}*/

	public abstract void print();
}

class Demo /*extends Object*/ implements Inter {	//一个类不写继承任何类,默认继承Object类
	public void print() {
		//num = 20;
		System.out.println(num);
	}

	public Demo() {
		super();
	}

}