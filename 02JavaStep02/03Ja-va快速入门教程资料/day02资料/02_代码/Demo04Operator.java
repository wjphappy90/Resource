/*
对于整数来说，如果使用除法（/）那么只看商，不看余数。
如果只希望看余数的话，则需要使用取模运算符：%。

注意，只有对整数进行取模运算，才有数学当中“余数”的意义。
*/
public class Demo04Operator {
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		System.out.println(a / b); // 结果是3，只看商，不看余数
		// 如果就是希望看看余数，那么就用取模运算符
		System.out.println(a % b); // 1
	}
}