import java.util.Scanner;

/*
题目：键盘输入三个int数字，然后求出其中的最大值。

思路：
1. 大于符号是一个用于两个数据的符号，不能同时用于三个数据。
2. 数学思维：遇到未知的问题，要将其转换成为已知的问题，问题的拆解。

步骤：
1. 首先求出a和b当中的最大值（和上一道题一样）
2. 拿着ab当中的最大值（中间量）继续和第三个c进行比较，从而得到最终结果。

也就是：三个无法同时比较，那么两两比较即可。
*/
public class Demo06MaxThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入第一个数字：");
		int a = sc.nextInt();
		System.out.println("请输入第二个数字：");
		int b = sc.nextInt();
		System.out.println("请输入第三个数字：");
		int c = sc.nextInt();
		
		// 首先比较一下前两个数字当中谁大，获得一个中间量
		int temp;
		if (a > b) {
			temp = a;
		} else {
			temp = b;
		}
		
		// 继续让中间量和第三个c进行比较，得到最终结果
		int max;
		if (temp > c) {
			max = temp;
		} else {
			max = c;
		}
		
		System.out.println("最大值：" + max);
	}
}