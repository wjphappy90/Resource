public class Demo15BreakVsContinue {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 4) {
				// break; // 一旦执行，整个循环立刻结束。
				continue; // 一旦执行，当前次循环结束，但是马上开始下一次循环。
			}
			System.out.println(i);
		}
	}
}