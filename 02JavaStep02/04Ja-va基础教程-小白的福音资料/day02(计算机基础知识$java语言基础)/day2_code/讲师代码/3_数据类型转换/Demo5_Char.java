class Demo5_Char {
	public static void main(String[] args) {
		char c = 'a';
		System.out.println(c);

		byte b = 100;
		char c1 = 97;		//0 - 65535
		System.out.println(c1);

		char c2 = 3;
		char c3 = 4;
		char c4 = 5;
		char c5 = 6;

		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);

		//char类型是否可以存储中文
		char c6 = '中';
		System.out.println(c6);
	}
}
