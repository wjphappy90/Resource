class Demo3_Final {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.print();
	}
}
/*
* A:final修饰变量的初始化时机
	* 显示初始化 
	* 在对象构造完毕前即可
*/

class Demo {
	final int num;						//成员变量的默认初始化值是无效值
	
	public Demo() {
		num = 10;
	}
	public void print() {
		System.out.println(num);
	}
}