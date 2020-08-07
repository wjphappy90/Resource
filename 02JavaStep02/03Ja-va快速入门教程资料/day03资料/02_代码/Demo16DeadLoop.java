/*
死循环：就是永远停不下来的循环。

标准格式：
while (true) {
	循环体
}

扩展格式：
for (;;) {
	循环体
}

死循环也叫做“永真循环”。
*/
public class Demo16DeadLoop {
	public static void main(String[] args) {
		// 死循环的标准格式
		while (true) {
			System.out.println("I Love Java!");
		}
		
		
		
		// System.out.println("===================");
		// for (;/*true*/;) {
		// 	System.out.println("I Love Java Teacher!");
		// }
	}
}