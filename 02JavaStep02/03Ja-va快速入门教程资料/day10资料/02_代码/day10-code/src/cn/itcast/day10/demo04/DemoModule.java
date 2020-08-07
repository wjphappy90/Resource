package cn.itcast.day10.demo04;

import cn.itcast.book.Book; // 确实在book模块当中已经被导出，所以可以访问

// cn.itcast.book.secret这个包并没有被导出
// 所以就算依赖了book模块，也无法访问其中的没有导出的包
//import cn.itcast.book.secret.BookSecret; // 错误写法！

public class DemoModule {
	
	public static void main(String[] args) {
		Book.readBook();
		
//		BookSecret.bookSecretMethod();
	}

}
