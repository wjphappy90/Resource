class Demo2_DataType {
	public static void main(String[] args) {
		/*
		* a:作用域问题
			* 同一个区域不能使用相同的变量名 
		* b:初始化值问题
			* 局部变量在使用之前必须赋值 
		* c:一条语句可以定义几个变量
			* int a,b,c...; 
		*/
		/*int x = 10;
		int x = 20;

		System.out.println(x);

		int y;

		y = 10;
		System.out.println(y);*/

		int a,b,c,d,e;

		a = 10;
		b = 20;
		c = 30;
		d = 40;
		e = 50;

		System.out.println(a);

		int x = 10;
		int y = 20;
		int z = 30;
	}
}
