
public class Test1 {

	/**
	 * 
		1,1-6位字母或数字：
		2,手机号
		3,Email
		4,用户名. 字母数字下划线10位以内, 必须是字母开头
		5,密码. 任意字符, 6-16位
		6,分组,例如快快乐乐,乐呵乐呵
		7,手机号码,后边五位必须是相同的
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();
		//demo7();
		String regex1 = "1[34578]\\d{9}";
		String regex2 = "1[34578]\\d{4}(\\d)\\1{4}";
		System.out.println("13812300000".matches(regex2));
		System.out.println("15932166666".matches(regex2));
		System.out.println("13812345678".matches(regex2));
	}

	public static void demo7() {
		String regex = "(.)\\1+(.)\\2+";
		System.out.println("快快乐乐".matches(regex));
		System.out.println("高高兴兴".matches(regex));
		System.out.println("快快快乐乐乐".matches(regex));
		
		String regex2 = "(..)\\1";
		System.out.println("乐呵乐呵".matches(regex2));
		System.out.println("死啦死啦".matches(regex2));
	}

	public static void demo6() {
		//5,密码. 任意字符, 6-16位
		String regex = ".{6,16}";
		System.out.println("123456".matches(regex));
		System.out.println("abcde".matches(regex));
		System.out.println("1234567890987654".matches(regex));
		System.out.println("12345678909876543".matches(regex));
	}

	public static void demo5() {
		//4,用户名. 字母数字下划线10位以内, 必须是字母开头
		String regex = "[a-zA-Z]\\w{0,9}";
		System.out.println("0abcde".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("abcdef12345".matches(regex));
	}

	public static void demo4() {
		//3,Email   fengjia@itcast.cn
		//          fengjia@itcast.com.cn
		String regex = "[\\w-\\.]+@([\\w-]+\\.)+[a-z]{2,3}";
		System.out.println("fengjia@itcast.cn".matches(regex));
		System.out.println("2553868@qq.com".matches(regex));
		System.out.println("fengjia@itcast.cn".matches(regex));
	}

	public static void demo3() {
		//2,手机号
		String regex = "1[34578]\\d{9}";
		System.out.println("13898765432".matches(regex));
		System.out.println("01234567890".matches(regex));
		System.out.println("16123456789".matches(regex));
		System.out.println("159123456780".matches(regex));
	}

	public static void demo2() {
		//1,1-6位字母或数字：
		String regex = "[\\d[a-zA-Z]]{1,6}";
		System.out.println("123456".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("abcd".matches(regex));
	}

	public static void demo1() {
		//qq号码
		String regex = "[1-9]\\d{4,10}";
		System.out.println("2553868".matches(regex));
		System.out.println("012345".matches(regex));
		System.out.println("12345678987".matches(regex));
	}

}
