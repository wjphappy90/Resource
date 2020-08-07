import java.util.Scanner; // 1. 导包
/*
1. 导包
import java.util.Scanner;

2. 创建
格式：数据类型 变量名称 = new 数据类型();
代码：Scanner sc = new Scanner(System.in);

3. 使用
获取一个键盘输入的int数字
int num = sc.nextInt();
*/
public class Demo11ScannerInt {
	public static void main(String[] args) {
		// 2. 创建
		Scanner sc = new Scanner(System.in);
		
		// 3. 使用，获取键盘输入的int数字
		int num = sc.nextInt();
		num += 20; // num = num + 20;
		System.out.println("结果：" + num);
	}
}