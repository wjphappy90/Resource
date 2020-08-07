public class Demo17Loop {
	public static void main(String[] args) {
		int count = 0;
		
		for (int i = 1; i <= 300; i++) { // 循环300次，代表300个班级
		
			for (int j = 1; j <= 80; j++) { // 循环80次，代表每个班级80个学生
				count++;
			}
			
		}
		
		System.out.println("总人数：" + count);
	}
}