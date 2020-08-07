class Test1_Operator {
	public static void main(String[] args) {
		//第一题
		/*int a = 10;
		int b = 10;
		int c = 10;
	
		a = b++;					//a = 10 ,b = 11
		c = --a;					//a = 9, c = 9			
		b = ++a;					//a = 10, b = 10	
		a = c--;					//a = 9, c = 8			
		
		System.out.println("a = " + a + ",b = " + b + ",c = " + c);*/

		//第二题
		/*int x = 4;
		//		4	+	6+	60
		int y = (x++)+(++x)+(x*10);

		System.out.println("x = " + x + ",y = " +  y);*/

		//第三题问哪句会报错,为什么 
		byte b = 10;
		//b++;					//b = (byte)(b + 1)
		b = b + 1;				//当byte与int进行混合运算的时候,会提升为int类型,两个int相加的结果还是int,赋值给byte会损失精度
		System.out.println("b = " + b);
		
	}
}
