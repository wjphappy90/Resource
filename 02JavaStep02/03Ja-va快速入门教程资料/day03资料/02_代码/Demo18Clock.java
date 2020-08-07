public class Demo18Clock {
	public static void main(String[] args) {
		for (int hour = 0; hour < 24; hour++) { // 外层循环，循环24次，代表小时

			
			for (int minute = 0; minute < 60; minute++) { // 内层循环，循环60次，代表分钟
				System.out.println(hour + "点" + minute + "分");
			}
			
			
		}
	}
}