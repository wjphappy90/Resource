/*
比较运算符也叫做关系运算符，用来代表两个数据之间的关系。

大于		>
小于		<
大于等于	>=
小于等于	<=
等于		==		【注意】两个等号连写，才是相等的意思！
不等于		!=

比较运算符结果一定是一个boolean值：成立true；不成立false
*/
public class Demo08Operator {
	public static void main(String[] args) {
		System.out.println(4 > 3); // true
		System.out.println(4 < 3); // false
		
		System.out.println("===================");
		
		System.out.println(10 >= 6); // true
		System.out.println(10 >= 10); // true
		System.out.println(10 >= 20); // false
		
		System.out.println("===================");
		
		System.out.println(10 <= 20); // true
		System.out.println(20 <= 20); // true
		System.out.println(20 <= 3); // false
		
		System.out.println("===================");
		
		// System.out.println(4 = 5); // 错误写法！这是赋值！赋值的左侧必须是一个变量！
		System.out.println(4 == 5); // false
		System.out.println(4 == 4); // true
		
		System.out.println("===================");
		
		System.out.println(4 != 5); // true
		System.out.println(4 != 4); // false
		
		System.out.println("===================");
		
		int a = 10;
		int b = 20;
		System.out.println(a == b); // false
		System.out.println(a != b); // true
		System.out.println(a <= b); // true
	}
}