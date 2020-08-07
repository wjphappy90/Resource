class Test2_DataTypeConversion {
	public static void main(String[] args) {
		float f = 12.3f;
		long x = 12345;

		//f = x;						//隐式转换
		//System.out.println(f);

		x = (long)f;					//强制转换
		System.out.println(x);

		/*
		float占4个字节
		IEEE 754
		32个二进制位
		1位代表是符号位
		8位代表指数位
		00000000 - 11111111
		0 - 255
		0代表0
		255代表无穷大
		1 - 254

		-126 - 127
		23位代表尾数位
		*/
	}
}
