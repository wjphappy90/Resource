package cn.itcast.day09.demo05;

// 注意！不管写不写@FunctionalInterface，只要是有且仅有一个抽象方法的接口，就是函数式接口！
@FunctionalInterface
public interface MyInter {
	
	// 作用：将参数++，然后返回结果
	int singlePlus(int num);

}
