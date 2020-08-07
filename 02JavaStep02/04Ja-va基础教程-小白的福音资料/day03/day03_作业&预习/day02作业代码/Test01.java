/**
 * 11.分析以下需求，并用代码实现：
 *	(1)已知一个三位数，请分别获取该三位数上每一位的数值
 *	(2)例如：123的个位、十位、百位，分别是3、2、1
 *	(3)打印格式"数字123的个位是 3, 十位是 2, 百位是 1"
 * @author JX
 *
 */
public class Test01 {
	public static void main(String[] args) {
		//1.定义int类型的变量i值为123
		int i = 123;
		//2.求出个位数字
		int ge = i%10;
		//3.求出十位数字
		int shi = i/10%10;
		//4.求出百位数字
		int bai = i/100;
		//5.按照格式打印
		System.out.println("数字"+i+"的个位是 "+ge+", 十位是 "+shi+", 百位是 "+bai);			
	}
}
