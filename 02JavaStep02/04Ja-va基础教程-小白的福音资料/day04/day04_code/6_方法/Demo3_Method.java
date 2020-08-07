/*
* A:案例演示
	* 需求：根据键盘录入的行数和列数，在控制台输出星形
* B:方法调用：
	* 单独调用
	* 输出调用(错误)
	* 赋值调用(错误)
*/
import java.util.Scanner;
class Demo3_Method {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			//创建键盘录入对象
		System.out.println("请输入行数:");
		int row = sc.nextInt();							//将键盘录入的行数存储在row中
		System.out.println("请输入列数:");
		int column = sc.nextInt();						//将键盘录入的列数存储在column中
		
		//System.out.println(print(row,column));		//错误: 此处不允许使用 '空' 类型,返回值是void的方法不能输出调用
		//返回值是void的方法只能单独调用
		print(row,column);
	}

	/*
	在控制台输出矩形星形
	1,明确返回值类型,经分析没有具体的返回值类型,void
	2,明确参数列表int a,int b
	*/

	public static void print(int a,int b) {
		for (int i = 1;i <= a ;i++ ) {					//行数
			for (int j = 1;j <= b ;j++ ) {				//列数
				System.out.print("*");
			}
			System.out.println();
		}

		//return ;										//如果返回值类型是void,return可以省略,即使省略系统也会默认给加上,形式是return;
	}
}
