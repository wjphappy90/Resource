package cn.itcast.day10.demo01;

// 保姆接口
@FunctionalInterface
public interface Sitter {
	
	// 保姆的工作，就是生米煮成熟饭
	void work(String food);

}
