/*
		for(int x=1; x<=10; x++) {
			if(x%3==0) {
				//在此处填写代码
			}
			System.out.println(“Java基础班”);
		}
		
		我想在控制台输出2次:“Java基础班“
		我想在控制台输出7次:“Java基础班“
		我想在控制台输出13次:“Java基础班“	
*/
class Test1 {
	public static void main(String[] args) {
		for(int x=1; x<=10; x++) {
			if(x%3==0) {
				//break;						//我想在控制台输出2次:“Java基础班“
				//continue;						//我想在控制台输出7次:“Java基础班“
				System.out.println("Java基础班");//我想在控制台输出13次:“Java基础班“	
			}
			System.out.println("Java基础班");
		}
	}
}
