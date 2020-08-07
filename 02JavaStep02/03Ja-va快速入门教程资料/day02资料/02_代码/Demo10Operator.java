/*
逻辑运算符当中的与（&）、或（|）这两个运算符可以双写：

短路与：&&
短路或：||

1. 短路：如果左侧已经可以判断到最终的结果，那么右侧将不再执行。（省事儿的效果）
2. 凡是用到了与、或这两个逻辑运算的时候，都非常推荐使用双写。因为双写有可能提高代码执行的效率。
3. 只有与、或才能双写，亦或、非不能双写。
*/
public class Demo10Operator {
	public static void main(String[] args) {
		System.out.println(3 < 2 & 10 < 20); // false，一个符号，左右都会执行
		System.out.println(3 < 2 && 10 < 20); // false，双写，左边如果可以判断最终结果，右侧的表达式不会执行
		System.out.println("==================");
		
		int num1 = 100;
		System.out.println(3 > 10 && ++num1 < 200); // false
		System.out.println(num1); // 100
		System.out.println("==================");
		
		int num2 = 20;
		System.out.println(3 < 10 || ++num2 > 3); // true
		System.out.println(num2); // 20
		System.out.println("==================");
		
		int num3 = 300;
		System.out.println(3 > 10 || ++num3 < 1000); // true
		System.out.println(num3); // 301
	}
}