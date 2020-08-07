package com.itheima.utils;

import java.math.BigDecimal;

public class Demo {

	public static void main(String[] args) {
		// BigDecimal bg = new BigDecimal("1000.98");
		// BigDecimal sub = bg.subtract(new BigDecimal("100.90"));
		// System.out.println(sub);

		BigDecimal bd1 = new BigDecimal(1000);// 本金
		double interest = bd1.multiply(new BigDecimal(6.5)).multiply(new BigDecimal(20))
				.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)
				.divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double a = 1000 * 6.5 * 20 / 100 / 12;

		System.out.println(interest);
		System.out.println(a);

	}
}
