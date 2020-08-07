package com.itheima._test03.level03_01;

import java.util.HashSet;
import java.util.Random;

/*
 * 双色球规则:双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
 * 红色球号码从1—33中选择；蓝色球号码从1—16中选择.请随机生成一注双色球号码
 * */
public class Test01 {
	public static void main(String[] args) {
		// 1.创建Random随机数对象
		Random ran = new Random();

		// 2.创建HashSet用于保存不重复的红球
		HashSet<Integer> hs = new HashSet<>();

		// 3.循环判断红球数量是否小于6个
		while (hs.size() < 6) {
			// 4.球数量小于6个就产生一个红球.添加到HashSet中
			int num = ran.nextInt(33) + 1;
			hs.add(num);
		}

		// 5.在生成一个红球
		int blueBall = ran.nextInt(16) + 1;

		// 6.打印中奖号码
		System.out.println("双色球中奖号码:");
		System.out.print("红球是: ");

		for (Integer redBall : hs) {
			System.out.print(redBall + " ");
		}

		System.out.println();
		System.out.println("蓝球是: " + blueBall);
	}

}