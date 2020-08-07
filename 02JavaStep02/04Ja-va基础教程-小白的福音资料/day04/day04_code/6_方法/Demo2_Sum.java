/*
* A:如何写一个方法
	* 1,明确返回值类型
	* 2,明确参数列表 
* B:案例演示
	* 需求：求两个数据之和的案例
* C:方法调用图解
*/
class Demo2_Sum {
	public static void main(String[] args) {
		/*int a = 10;
		int b = 20;
		int sum = a + b;
		System.out.println(sum);

		int c = 30;
		int d = 40;
		int sum2 = c + d;
		System.out.println(sum2);*/

		int sum = add(10,20);
		System.out.println(sum);

		//add(30,40);						//有返回值方法的单独调用,没有意义
		System.out.println(add(30,40));		//这样调用是可以,but如果需要用这个结果不推荐这样调用

		//盘子 = 炒菜(地沟油,苏丹红,镉大米,烂白菜);
	}

	/*
	求两个整数的和
	1,整数的和结果应该还是整数
	2,有两个未知内容参与运算

	如何写方法
	1,明确返回值类型
	2,明确参数列表

	* 修饰符：目前就用 public static。后面我们再详细的讲解其他的修饰符。
		* 返回值类型：就是功能结果的数据类型。
		* 方法名：符合命名规则即可。方便我们的调用。
		* 参数：
			* 实际参数：就是实际参与运算的。
			* 形式参数；就是方法定义上的，用于接收实际参数的。
		* 参数类型：就是参数的数据类型
		* 参数名：就是变量名
		* 方法体语句：就是完成功能的代码。
		* return：结束方法的。
		* 返回值：就是功能的结果，由return带给调用者。
	*/
	public static int add(int a,int b) {			//int a = 10,int b = 20
		int sum = a + b;
		return sum;									//如果有返回值必须用return语句带回
	}

	/*
	盘子 炒菜(油,调料,米,菜) {
		炒菜的动作
		return 一盘菜;
	}
	*/

}
