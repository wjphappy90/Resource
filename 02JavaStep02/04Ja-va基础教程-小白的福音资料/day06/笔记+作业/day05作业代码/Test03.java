import java.util.Scanner;

/**
 * 4.分析以下需求，并用代码实现：
 *	(1)键盘录入6个int类型的数据存数数组arr中
 *	(2)将arr数组中的内容反转
 *	(3)将翻转后的数组角标为奇数的互相交换 1和3换, 3和5换,以此类推
 *	(4)最后将数组最后一个角标为奇数的元素 和数组中第一个角标为奇数的元素交换
 *	(5)打印最终的数组(实现了1-4步之后的数组)
 *	(6)如：用户输入的6个int数字为[1,2,3,4,5,6],最后输出的结果为[6, 5, 4, 1, 2, 3]
 * @author JX
 *
 */
public class Test03 {
	public static void main(String[] args) {
		//1.通过键盘录入获取数组
		int[] arr = getArrayByKeyBoard();
		//2.按照要求给数组加密
		getSecurityArray(arr);
		//3.打印数组内容
		print(arr);		
	}	
	//1.通过键盘录入6个int类型的数字并存入数组中
	public static int[] getArrayByKeyBoard() {
		int[] arr = new int[6];
		Scanner sc = new Scanner(System.in);
		System.out.println("请依次输入6个整数：");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}
	//2.数组反转
	public static void reverseArray(int[] arr) {
		int startIndex = 0;//最开始的索引
		int endIndex = arr.length-1;//最后的索引	
		
		for(;startIndex<=endIndex;startIndex++,endIndex--) {			
			swap(arr,startIndex,endIndex);
		}		
	}	
	//3.交换arr数组中角标为startIndex和endIndex的元素
	private static void swap(int[] arr, int startIndex, int endIndex) {
		int temp = arr[startIndex];
		arr[startIndex] = arr[endIndex];
		arr[endIndex] = temp;
	}
	//4.数组的反转 反转后的数组 角标为奇数的互相换 1 和3换 3和 5换以此类推 
	public static void reverseArrayByIndex(int[] arr){
		//i=1,j=3;i=3,j=5;i=5,j=7
		for(int i=1,j=i+2;i<arr.length&&j<arr.length;i+=2,j+=2) {
			swap(arr,i,j);
		}
		
	}
	//5.然后数组最后一个角标为奇数的元素 和数组中第一个角标为奇数的元素交换
	private static void swap(int[] arr){
		//数组中的最后一个为奇数的角标
		int lastIndex = (arr.length-1)%2==0?arr.length-2:arr.length-1;
		swap(arr,1,lastIndex);
	}
	//6.打印数组，如果长度为0，打印[],如果数组为null,打印null，否则打印格式如：[1, 2, 3, 4, 5, 6]
	public static void print(int[] arr){
		//如果数组为null,打印null
		if(arr==null) {
			System.out.println("null");
			return;
		}
		//如果长度为0，打印[]
		if(0==arr.length) {
			System.out.println("[]");
			return;
		}
		System.out.print("[");
		for(int i =0;i<arr.length;i++) {				
			System.out.print(arr[i]);
			if(i!=arr.length-1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
	//7.直接获取加密后的数组
	public static void getSecurityArray(int[] arr) {
		//1.数组反转
		reverseArray(arr);
		//2.将翻转后的数组角标为奇数的互相交换 1和3换, 3和5换,以此类推
		reverseArrayByIndex(arr);
		//3.然后数组最后一个角标为奇数的元素 和数组中第一个角标为奇数的元素交换
		swap(arr);
	}
}
