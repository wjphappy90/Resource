/*
* A:什么是匿名对象
	* 没有名字的对象 
* B:匿名对象应用场景
	* a:调用方法，仅仅只调用一次的时候。
		* 那么，这种匿名调用有什么好处吗?
			* 节省代码 
		* 注意：调用多次的时候，不适合。匿名对象调用完毕就是垃圾。可以被垃圾回收器回收。
	* b:匿名对象可以作为实际参数传递
* C:案例演示
	* 匿名对象应用场景
*/
class Demo2_Car {
	public static void main(String[] args) {
		/*Car c1 = new Car();			//创建有名字的对象
		c1.run();
		c1.run();

		new Car().run();			//匿名对象调用方法
		new Car().run();	*/		//匿名对象只适合对方法的一次调用,因为调用多次就会产生多个对象,不如用有名字的对象	
	
		//匿名对象是否可以调用属性并赋值?有什么意义?
		/*
		匿名对象可以调用属性,但是没有意义,因为调用后就变成垃圾
		如果需要赋值还是用有名字对象
		*/
		new Car().color = "red";
		new Car().num = 8;
		new Car().run();
	}
}

class Car {
	String color;			//颜色
	int num;				//轮胎数

	public void run() {
		System.out.println(color + "..." + num);
	}
}
