package cn.itcast.day10.demo02;

/*
 * Lambda的分析：
 * 1. 拿到一个参数
 * 2. 将这个参数交给了println方法去用
 * 
 * 问题：既然Lambda就是拿到参数，原封不动地交给println去使用。
 * 那么为什么不能直接交给println，而中间不用Lambda？
 * Lambda在这种场景当中，要做的事情，就是打印。而打印的功能在println当中已经有了。
 * 
 * 这时候，可以使用方法引用。
 * 扩展一点：System.out其实就是一个JDK当中已经创建好的对象，而println就是System.out对象当中的成员方法
 * 
 * 对象名::成员方法名
 * System.out::println
 * 
 * 小节：
 * 1. 一定要有函数式接口，才能使用Lambda。
 * 2. 对于重复的Lambda场景，可以使用方法引用来进行简化。
 */
public class Demo03Monitor {
	
	public static void main(String[] args) {
		// 首先使用Lambda，间接调用println方法
		useMonitor(str -> System.out.println(str));
		
		// 使用方法引用，直接交给了println方法引用去处理
		useMonitor(System.out::println);
	}
	
	public static void useMonitor(Monitor monitor) {
		monitor.show("Hello, World!");
	}

}
