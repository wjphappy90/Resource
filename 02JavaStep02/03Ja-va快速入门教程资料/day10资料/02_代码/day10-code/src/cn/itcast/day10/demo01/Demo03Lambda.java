package cn.itcast.day10.demo01;

/*
 * 在某些场景之下，Lambda表达式要做的事情，其实在另外一个地方已经写过了。
 * 那么此时如果通过Lambda表达式重复编写相同的代码，就是浪费。
 * 那么如何才能复用已经存在的方法逻辑呢？
 * 
 * 如果Lambda表达式需要做的事情，在另外一个类当中已经做过了，那么就可以直接拿过来替换Lambda。
 * 方法引用的写法：
 * 
 * 通过类名称引用静态方法，格式：
 * 类名称::静态方法名
 */
public class Demo03Lambda {
	
	public static void main(String[] args) {
		hireSitter(        food -> System.out.println("将" + food + "做成可口的食物。")        );
		
		hireSitter(        Cook::makeFood                );
	}
	
	// 雇佣一个保姆，并且让他去做饭
	public static void hireSitter(Sitter sitter) {
		sitter.work("白菜");
	}

}
