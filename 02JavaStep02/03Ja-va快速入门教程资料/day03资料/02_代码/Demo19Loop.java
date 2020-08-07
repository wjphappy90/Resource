/*
1. break和continue只能默认作用于所属层次的循环
2. 如果希望写在内层，但是作用于外层循环，那怎么办？

标签名称: for (...) {			 	// 外层
	for (...) {			// 内层
		break 标签名称;
	}
}

标签名称：这就是一个自定义的标识符。
*/
public class Demo19Loop {
	public static void main(String[] args) {
		int count = 0;
		
		label: for (int i = 1; i <= 10; i++) { // 外层循环10次
			
			// if (i == 3) {
			// 	continue;
			// }
		
			for (int j = 1; j <= 5; j++) { // 内层循环5次
				// if (j == 3) { // 如果内层循环出现了数字3
				// 	continue;
				// }
				
				if (j == 3) {
					break label;
				}
				count++;
			}
		}
		
		System.out.println("总次数：" + count);
	}
}