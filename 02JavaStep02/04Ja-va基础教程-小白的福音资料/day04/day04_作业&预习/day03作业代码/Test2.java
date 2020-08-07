public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	//创建键盘录入对象		
		//键盘录入练习：键盘录入两个数据，获取这两个数据中的最小值
		System.out.println("请输入第一个整数:");
		int x = sc.nextInt();					//将键盘录入的数据存储在x中
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();					//将键盘录入的数据存储在y中
		int min = (x < y) ? x : y;				//获取x和y中的最小值
		System.out.println("min = " + min);
	}
}