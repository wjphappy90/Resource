import java.util.Scanner;						//导入包中的类Scanner
class Test2_Scanner {
	/*
	* A:案例演示
		* 键盘录入练习：键盘录入两个数据，并对这两个数据求和，输出其结果
	* B:案例演示
		* 键盘录入练习：键盘录入两个数据，获取这两个数据中的最大值

	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	//创建键盘录入对象
		
		//键盘录入练习：键盘录入两个数据，并对这两个数据求和，输出其结果
		/*System.out.println("请输入第一个整数:");
		int x = sc.nextInt();					//将键盘录入的数据存储在x中
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();					//将键盘录入的数据存储在y中
		int sum = x + y;
		System.out.println(sum);*/

		//键盘录入练习：键盘录入两个数据，获取这两个数据中的最大值
		System.out.println("请输入第一个整数:");
		int x = sc.nextInt();					//将键盘录入的数据存储在x中
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();					//将键盘录入的数据存储在y中

		int max = (x > y) ? x : y;				//获取x和y中的最大值
		System.out.println("max = " + max);
	}
}
