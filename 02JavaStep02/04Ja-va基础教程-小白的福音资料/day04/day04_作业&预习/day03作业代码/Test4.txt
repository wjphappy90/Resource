import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int x = sc.nextInt();
		int y;
		if(x<0) {
			y = -1;
		} else if(x==0) {
			y = 0;
		} else {
			y = 1;
		}
		System.out.println("x="+x+",y="+y);
	}
}
