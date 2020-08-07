import java.util.Scanner;

// 标准的if-else语句
public class Demo03IfElse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个整数：");
		int num = sc.nextInt(); // 获取键盘输入的一个int数字
		
		// 如何判断一个整数是奇数还是偶数？
		if (num % 2 == 0) { // 如果num除以2得到的余数是0，说明是偶数
			System.out.println("偶数");
		} else {
			System.out.println("奇数");
		}
	}
}