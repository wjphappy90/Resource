public class Demo11ForVsWhile {
	public static void main(String[] args) {
		for (int a = 1; a <= 5; a++) {
			System.out.println(a);
		}
		// 变量a是定义在for循环内部的，超出了for循环的范围，外面无法使用
		// System.out.println(a); // 错误写法！
		
		System.out.println("=================");
		int b = 1; // 定义在while循环的外面，本来就在外面
		while (b <= 5) {
			System.out.println(b);
			b++;
		}
		
		System.out.println("=================");
		
		System.out.println(b); // 正确写法！
	}
}