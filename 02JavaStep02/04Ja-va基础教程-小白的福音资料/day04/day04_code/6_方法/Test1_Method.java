/*
* A:案例演示
	* 需求：键盘录入两个数据，返回两个数中的较大值
* B:案例演示
	* 需求：键盘录入两个数据，比较两个数是否相等     
*/
import java.util.Scanner;
class Test1_Method {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);				//创建键盘录入对象
		System.out.println("请输入第一个整数:");
		int x = sc.nextInt();								//将键盘录入的整数存储在x中
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();								//将键盘录入的整数存储在y中

		//int max = getMax(x,y);
		//System.out.println(max);

		boolean b = isEquals(x,y);
		System.out.println(b);
	}

	/*
	返回连个整数的较大值
	1,明确返回值类型 int
	2,明确参数列表 int a,int b
	*/
	public static int getMax(int a,int b) {
		return a > b ? a : b;
	}

	/*
	判断两个整数是否相等
	1,明确返回值类型 boolean
	2,明确参数列表 int a,int b
	*/
	public static boolean isEquals(int a,int b) {		//isEquals 是否相等
		return a == b;
	}
}
