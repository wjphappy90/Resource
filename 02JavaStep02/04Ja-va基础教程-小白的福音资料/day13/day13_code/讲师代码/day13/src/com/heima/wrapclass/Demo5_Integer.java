package com.heima.wrapclass;


public class Demo5_Integer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i1 = new Integer(97);
		Integer i2 = new Integer(97);
		System.out.println(i1 == i2);				//false
		System.out.println(i1.equals(i2));			//true
		System.out.println("-----------");
	
		Integer i3 = new Integer(197);
		Integer i4 = new Integer(197);
		System.out.println(i3 == i4);				//false
		System.out.println(i3.equals(i4));			//true
		System.out.println("-----------");
	
		Integer i5 = 127;
		Integer i6 = 127;
		System.out.println(i5 == i6);				//true
		System.out.println(i5.equals(i6));			//true
		System.out.println("-----------");
	
		Integer i7 = 128;
		Integer i8 = 128;
		System.out.println(i7 == i8);
		System.out.println(i7.equals(i8));			//true
		
		/*
		 * -128到127是byte的取值范围,如果在这个取值范围内,自动装箱就不会新创建对象,而是从常量池中获取
		 * 如果超过了byte取值范围就会再新创建对象
		 * 
		 * public static Integer valueOf(int i) {
		        assert IntegerCache.high >= 127;
		        if (i >= IntegerCache.low && i <= IntegerCache.high)			//i>= -128 && i <= 127
		            return IntegerCache.cache[i + (-IntegerCache.low)];
		        return new Integer(i);
		    }
		 */
	}

}
