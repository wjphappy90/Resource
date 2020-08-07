/*
* A:案例演示
	* 需求：猜数字小游戏(数据在1-100之间)
*/
import java.util.Scanner;
class Test1_GuessNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);				//创建键盘录入对象
		System.out.println("请输入一个整数,范围在1-100之间");
		int guessNum = (int)(Math.random() * 100) + 1;		//心里想的随机数
		while (true) {										//因为需要猜很多次,所以用无限循环
			int result = sc.nextInt();						//大家猜的数
			if (result > guessNum) {						//如果你们猜的数大于了我心里想的数
				System.out.println("大了");					//提示大了
			} else if (result < guessNum) {					//如果你们猜的数小于了我心里想的数
				System.out.println("小了");					//提示小了
			} else {										//如果既不大也不小
				System.out.println("中了");					//中了
				break;
			}
		}
	}
}

