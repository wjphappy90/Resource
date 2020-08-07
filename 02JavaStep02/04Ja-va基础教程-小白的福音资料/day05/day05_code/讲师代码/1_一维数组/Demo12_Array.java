/*
* A:案例演示
	* 数组元素查找(查找指定元素第一次在数组中出现的索引)
*/
class Demo12_Array {
	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77};
		int index = getIndex(arr,88);
		System.out.println(index);
	}

	/*
	查找元素索引
	1,返回值类型int
	2,明确参数列表,int[] arr,int value
	*/

	public static int getIndex(int[] arr,int value) {
		for (int i = 0;i < arr.length ;i++ ) {				//数组的遍历
			if (arr[i] == value) {							//如果数组中的元素与查找的元素匹配
				return i;
			}

		}
		return -1;
		
	}
}
