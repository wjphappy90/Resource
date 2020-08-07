/*
* A:案例演示
	* 键盘录入练习：键盘录入两个数据，比较这两个数据是否相等
* B:案例演示
	* 键盘录入练习：键盘录入三个数据，获取这三个数据中的最大值
*/
import java.util.Scanner;							//导包
class Test3_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		//创建键盘录入对象

		//键盘录入练习：键盘录入两个数据，比较这两个数据是否相等
		/*System.out.println("请输入第一个整数:");
		int x = sc.nextInt();						//将键盘录入的数据存储在x中
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();						//将键盘录入的数据存储在y中

		//boolean b = (x == y)? true : false;
		boolean b = (x == y);
		System.out.println(b);*/

		//键盘录入练习：键盘录入三个数据，获取这三个数据中的最大值
		System.out.println("请输入第一个整数:");
		int x = sc.nextInt();						//将键盘录入的数据存储在x中
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();						//将键盘录入的数据存储在y中
		System.out.println("请输入第三个整数:");
		int z = sc.nextInt();						//将键盘录入的数据存储在y中

		//定义临时变量记录住比较出前两个变量中的最大值
		int temp = (x > y) ? x : y;
		//将比较后的结果与第三个变量中的值比较,比较出三个数中的最大值
		int max = (temp > z) ? temp : z;
		System.out.println(max);
	}
}
