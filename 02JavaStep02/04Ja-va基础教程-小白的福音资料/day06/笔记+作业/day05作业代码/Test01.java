/**
 * 1.分析以下需求，并用代码实现：
 *	(1)定义一个int类型的二维数组
 *	(2)获取该二维数组最小元素，并输出
 * @author JX
 *
 */
public class Test01 {
	public static void main(String[] args) {
		//1.定义int类型的二维数组
		int[][] arr = {{10,20,30},{3,2,1},{4,5,6},{100,200,300}};
		//2.假设该int类型的二维数组中的第一个元素arr[0][0]是最小的
		int min = arr[0][0];
		//3.遍历二维数组中的每个一维数组
		for(int i=0;i<arr.length;i++) {
			//4.遍历当前一维数组中的每个元素，只要比min小，就将当前元素赋值给min
			for(int j=0;j<arr[i].length;j++) {
				if(min>arr[i][j]) {
					min = arr[i][j];
				}
			}
		}
		//4.打印最小值
		System.out.println("min="+min);
	}
}
