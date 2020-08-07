/*
continue语句基本含义：一旦执行，跳过当前次循环的剩余内容，马上开始下一次。
分析：什么叫做“当前次循环的剩余内容”？
*/
public class Demo14ContinueNotice {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 4) {
				continue;
			}
			System.out.println(i); // 这个输出语句就是循环体剩余内容
		}
		System.out.println("======================");
		
		int i = 1;
		while (i <= 10) {
			if (i == 4) {
				System.out.println("即将执行continue语句");
				continue;
			}
			System.out.println(i); // 这一行就是循环体剩余内容
			i++; // 步进表达式，这也是循环体剩余内容，也会被continue跳过。
		}
	}
}