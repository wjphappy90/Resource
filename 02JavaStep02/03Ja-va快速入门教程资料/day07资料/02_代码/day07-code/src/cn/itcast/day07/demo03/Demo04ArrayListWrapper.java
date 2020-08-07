package cn.itcast.day07.demo03;

import java.util.ArrayList;

/*
 * 集合泛型必须是引用类型，不能是基本类型。
 * 如果一定存储基本数据，那么就要使用基本类型对应的“包装类”（全都位于java.lang包下，有8种）
 * 
 * 基本类型	对应的包装类
 * byte		Byte
 * short	Short
 * int		Integer		【特殊】
 * long		Long
 * float	Float
 * double	Double
 * char		Character	【特殊】
 * boolean	Boolean
 * 
 * 从JDK 1.5开始，基本类型可以和对应的包装类进行自动装箱拆箱。
 * 装箱：基本类型 --> 包装类
 * 拆箱：包装类 --> 基本类型
 */
public class Demo04ArrayListWrapper {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(100);
		list.add(200);
		list.add(300);
		
		int result = list.get(1);
		System.out.println(result); // 200
	}

}
