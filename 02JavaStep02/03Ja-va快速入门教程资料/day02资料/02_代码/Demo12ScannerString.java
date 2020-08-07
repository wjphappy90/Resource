import java.util.Scanner;

/*
1. 导包：import java.util.Scanner;
2. 创建：Scanner sc = new Scanner(System.in);
3. 使用：String str = sc.next();
*/
public class Demo12ScannerString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入第一个字符串：");
		String str1 = sc.next(); // 第一次输入
		System.out.println("字符串1：" + str1);
		
		System.out.println("请输入第二个字符串：");
		String str2 = sc.next(); // 第二次输入
		System.out.println("字符串2：" + str2);
	}
}