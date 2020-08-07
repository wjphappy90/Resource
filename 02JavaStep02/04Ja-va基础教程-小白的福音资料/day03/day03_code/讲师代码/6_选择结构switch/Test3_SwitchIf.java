import java.util.Scanner;
class Test3_SwitchIf {
	public static void main(String[] args) {
		/*

		* 键盘录入月份，输出对应的季节
		一年有四季
		3,4,5春季
		6,7,8夏季
		9,10,11秋季
		12,1,2冬季
		*/
		Scanner sc = new Scanner(System.in);	//创建键盘录入对象
		System.out.println("请输入月份");
		int month = sc.nextInt();				//将键盘录入的结果存储在month
		/*switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println(month + "月是春季");
		break;
		case 6:
		case 7:
		case 8:
			System.out.println(month + "月是夏季");
		break;
		case 9:
		case 10:
		case 11:
			System.out.println(month + "月是秋季");
		break;
		case 12:
		case 1:
		case 2:
			System.out.println(month + "月是冬季");
		break;
		default:
			System.out.println("对不起没有对应的季节");
		break;
		}*/

		//用if语句来完成月份对应季节
		if (month > 12 || month < 1) {
			System.out.println("对不起没有对应的季节");
		}else if (month >= 3 && month <= 5) {
			System.out.println(month + "月是春季");
		}else if (month >= 6 && month <= 8) {
			System.out.println(month + "月是夏季");
		}else if (month >= 9 && month <= 11) {
			System.out.println(month + "月是秋季");
		}else {
			System.out.println(month + "月是冬季");
		}
	}
}
