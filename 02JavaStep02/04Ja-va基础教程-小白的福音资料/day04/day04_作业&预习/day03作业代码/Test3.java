public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		//创建键盘录入对象
		//键盘录入练习：键盘录入三个数据，获取这三个数据中的最小值
		System.out.println("请输入第一个整数:");
		int x = sc.nextInt();						//将键盘录入的数据存储在x中
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();						//将键盘录入的数据存储在y中
		System.out.println("请输入第三个整数:");
		int z = sc.nextInt();						//将键盘录入的数据存储在y中
		//定义临时变量记录住比较出前两个变量中的最小值
		//int temp = (x < y) ? x : y;
		//将比较后的结果与第三个变量中的值比较,比较出三个数中的最小值
		//int min = (temp < z) ? temp : z;
		//用一条三元运算符搞定
		int min = ((x < y) ? x : y)<z?((x < y) ? x : y):z;
		System.out.println("min="+min);
	}
}
