class Demo4_DataTypeConversion {
	public static void main(String[] args) {
		//System.out.println('a' + 1);			//98,因为有ASCII码表,a字符对应的是int类型的97
		//System.out.println((char)('a' + 1));

		System.out.println("hello"+'a'+1);		//任何数据类型用+与字符串相连接都会产生新的字符串
		System.out.println('a'+1+"hello");

		System.out.println(" 5 + 5 = " + (5 + 5));
	}
}
