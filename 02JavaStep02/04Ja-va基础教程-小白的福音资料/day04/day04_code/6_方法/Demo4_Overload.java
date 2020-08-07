/*
重载:方法名相同,参数列表不同,与返回值类型无关
重载的分类
1,参数个数不同
2,参数类型不同
	顺序不同
*/
class Demo4_Overload {						//overload重载
	public static void main(String[] args) {
		double sum1 = add(10,20.1);
		System.out.println(sum1);

		int sum2 = add(10,20,30);
		System.out.println(sum2);

		double sum3 = add(12.3,13);
		System.out.println(sum3);
	}

	/*
	求两个整数的和
	1,返回值类型int
	2,参数列表 int a,int b
	*/

	public static double add(int a,double b) {
		return a + b;
	}

	/*
	求三个整数的和
	1,返回值类型int
	2,参数列表 int a,int b,int c
	*/

	public static int add(int a,int b,int c) {
		return a + b + c;
	}

	/*
	求两个小数的和
	1,返回值类型double
	2,参数列表 double a,double b
	*/

	public static double add(double a,int b) {
		return a + b;
	}
}
