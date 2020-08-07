class Demo1_Constant {						//constant 常量
	public static void main(String[] args) {
		/*
		* 字符串常量	用双引号括起来的内容
		* 整数常量		所有整数
		* 小数常量		所有小数
		* 字符常量		用单引号括起来的内容,里面只能放单个数字,单个字母或单个符号
		* 布尔常量		较为特殊，只有true和false
		* 空常量		    null(数组部分讲解)
		*/
		System.out.println("abc");		//字符串常量
		System.out.println(123);		//整数常量
		System.out.println(12.3);		//小数常量
		//System.out.println('10');		//''中必须放的是单个字符,10代表的是1字符和0字符
		//System.out.println('');		//''中什么也不放,也是不可以的,因为代表不了任何字符
		System.out.println(' ');		//带表空格字符
		System.out.println(true);		//boolean类只有两个值,true和false
		System.out.println(false);
	}
}
