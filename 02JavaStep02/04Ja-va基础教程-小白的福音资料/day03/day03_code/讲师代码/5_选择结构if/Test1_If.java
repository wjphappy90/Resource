import java.util.Scanner;
class Test1_If {
	public static void main(String[] args) {
		/*
		* A:练习1
		* 
				需求：键盘录入一个成绩，判断并输出成绩的等级。
				90-100 优
				80-89  良
				70-79  中
				60-69  及
				0-59   差
				
		* B:练习2
			* 需求：
				* 键盘录入x的值，计算出y的并输出。
				
				* x>=3	y = 2 * x + 1;
				* -1<x<3	y = 2 * x;
				* x<=-1	y = 2 * x - 1;
		*/
		Scanner sc = new Scanner(System.in);

		//需求：键盘录入一个成绩，判断并输出成绩的等级。
		/*System.out.println("请输入学生成绩范围在1到100之间");
		int x = sc.nextInt();

		if (x >= 90 && x <= 100) {
			System.out.println("优");
		}else if (x >= 80 && x <= 89 ) {
			System.out.println("良");
		}else if (x >= 70 && x <= 79 ) {
			System.out.println("中");
		}else if (x >= 60 && x <= 69 ) {
			System.out.println("及");
		}else if (x >= 0 && x <= 59 ) {
			System.out.println("差");
		}else {
			System.out.println("成绩录入错误");
		}*/

		//需求： 键盘录入x的值，计算出y的并输出
		System.out.println("请输入一个整数:");
		int x = sc.nextInt();
		int y = 0;
		if (x >= 3) {
			y = 2 * x + 1;
		}else if (x > -1 && x < 3) {
			y = 2 * x;
		}else if (x <= -1) {
			y = 2 * x - 1;
		}

		System.out.println(y);
	}
}
