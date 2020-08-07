/**
 * 3.分析以下需求，并用代码实现：
 *	(1)定义一个int类型的一维数组，内容为{6,2,9,15,1,5,20,7,18}
 *	(2)将数组最大元素与最后一位元素进行交换,最小元素与第一位元素进行交换，并打印数组
 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) {
		int[] arr = {6,2,9,15,1,5,20,7,18};
		int maxIndex = getMaxOrMinIndex(arr, true); // 获取最大值索引
		int minIndex = getMaxOrMinIndex(arr, false); // 获取最小值索引
		printArr(arr, maxIndex, minIndex); // 交换并打印
	}
	//定义交换数组最大元素与最后一位元素进行交换,最小元素与第一位元素进行交换，并打印数组
	public static void printArr(int[] arr, int maxIndex, int minIndex) {
		/*
		//数组最大元素与最后一位元素进行交换
		int temp = arr[maxIndex]; 
		arr[maxIndex] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;
		//最小元素与第一位元素进行交换
		temp = arr[0]; // 交换最小元素
		arr[0] = arr[minIndex];
		arr[minIndex] = temp;
		*/
		//数组最大元素与最后一位元素进行交换
		swap(arr,maxIndex,arr.length-1);
		swap(arr,minIndex,0);
		for (int i : arr) { // 遍历数组输出
			System.out.print(i + " ");
		}
	}
	//定义交换数组指定位置的元素的方法
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//定义方法获取数组中的最大值或者最小值对应的索引，flag为"true"表示求最大值的索引，flag为false表示求最小值的索引
	//可以将获取最大值索引和最小值索引的方法写成下面的方法，但是建议分开写
	public static int getMaxOrMinIndex(int[] arr, boolean flag) {
		// 假设数组的第一个元素为最值
		int index = 0; 
		for (int i = 0; i < arr.length; i++) { // 遍历数组
			if (flag) { // 最大值
				if (arr[index] < arr[i]) {
					index = i;
				}
			} else {
				if (arr[index] > arr[i]) { // 最小值
					index = i;
				}
			}
		}
		return index; // 返回最值索引
	}

}
