class Test1_Operator {
	public static void main(String[] args) {
		/*
		* A:案例演示
			* 比较两个整数是否相同
		* B:案例演示
			* 获取三个整数中的最大值
		*/

		//比较两个整数是否相同

		/*int x = 10;
		int y = 10;

		//boolean b = (x == y) ? true : false;
		boolean b = (x == y);
		System.out.println("b = " +  b);*/

		//获取三个整数中的最大值
		int a = 10;
		int b = 20;
		int c = 30;

		//先比较任意两个数的值,找出这两个数中的最大值
		int temp = (a > b) ? a : b;
		//用前两个数的最大值与第三个数比较,获取最大值
		int max = (temp > c) ? temp : c;
		System.out.println("max =" + max);
	}
}
