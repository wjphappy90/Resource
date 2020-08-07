class Demo2_Operator {
	/*
	* a:单独使用：
		* 放在操作数的前面和后面效果一样。(这种用法是我们比较常见的)
	* b:参与运算使用：
		* 放在操作数的前面，先自增或者自减，然后再参与运算。
		* 放在操作数的后面，先参与运算，再自增或者自减。
	*/
	public static void main(String[] args) {
		//单独使用
		/*int a = 3;
		//a++;						//a = a + 1;
		++a;						//a = a + 1;
		System.out.println(a);*/

		//参与运算使用
		int a = 3;
		int b;

		//b = a++;					//当++在变量后面的时候,会先将变量中的值取出做赋值操作,然后再自身加1
		b = ++a;					//当++在变量前面的时候,会先自身加1,然后在将结果赋值
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
