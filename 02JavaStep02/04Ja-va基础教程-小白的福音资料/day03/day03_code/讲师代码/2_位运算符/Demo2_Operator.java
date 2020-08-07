class Demo2_Operator {
	public static void main(String[] args) {
		/*
		* 位异或运算符的特点

		* ^的特点：一个数据对另一个数据位异或两次，该数本身不变。
		*/

		//System.out.println(5 ^ 10 ^ 10);
		//System.out.println(5 ^ 10 ^ 5);

		/*
		* 请自己实现两个整数变量的交换(不需要定义第三方变量)
		* 注意：以后讲课的过程中，我没有明确指定数据的类型，默认int类型。
		*/

		int x = 10;
		int y = 5;

		//需要第三方变量,开发推荐用这种
		/*int temp;
		temp = x;
		x = y;
		y = temp;*/

		//不需要定义第三方变量,有弊端,有可能会超出int的取值范围
		/*x = x + y;				//10 + 5 = 15
		y = x - y;				//15 - 5 = 10
		x = x - y;				//15 - 10 = 5*/

		//不需要第三方变量,通过^来做
		x = x ^ y;				// 10 ^ 5 
		y = x ^ y;				// 10 ^ 5 ^ 5	y = 10
		x = x ^ y;				// 10 ^ 5 ^ 10  x = 5

		System.out.println("x = " + x + ",y = " + y);
	}
}
