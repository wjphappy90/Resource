class Demo4_Return {
	public static void main(String[] args) {
		for (int i = 1;i <= 10 ;i++ ) {
			if (i == 4) {				
				//break;						//停止循环
				return;							//返回的意思,用来返回方法
			}
		}

		System.out.println("循环结束了");
	}
}
