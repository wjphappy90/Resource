package cn.itcast.day10.demo02;

// 计算器函数式接口
@FunctionalInterface
public interface Calculator {
	
	// 抽象方法的作用：求绝对值（如果是正数或者是0，那么仍然是本身；如果是负数，就要负负为正）
	int getAbs(int num);

}
