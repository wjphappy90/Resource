class Demo1_DataType {							//DataType数据类型			
	public static void main(String[] args) {
		//整数类型
		byte b = 10;			//占一个字节,-128 到 127
		short s = 20;			//占两个字节
		int i = 30;				//占四个字节			整数默认的数据类型就是int类型
		long x = 8888888888L;	//占八个字节	如果long类型后面加L进行标识最好加大L,因为小l太像一了
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(x);

		//System.out.println(12345 + 54321l);

		//浮点类型
		float f = 12.3F;		//占四个字节
		double d = 33.4;		//占八个字节			小数默认的数据类型是double,double类型后面也可以用D或d标识,但是一般不加
		System.out.println(f);
		System.out.println(d);

		//字符类型
		char c = 'a';			//占两个字节
		System.out.println(c);

		//布尔类型
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1);
		System.out.println(b2);
	}
}
