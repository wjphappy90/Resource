package com.itheima.test11;

import java.util.Arrays;
import java.util.Random;

public class DoubleColorBallUtil {
	// 产生双色球的代码
	public static String create() {
		String[] red = {"01","02","03","04","05","06","07","08","09","10",
				"11","12","13","14","15","16","17","18","19","20","21","22","23",
				"24","25","26","27","28","29","30","31","32","33"};
		//创建蓝球
		String[] blue = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16".split(",");
		boolean[] used = new boolean[red.length];
		Random r = new Random();
		String[] all = new String[7];
		for(int i = 0;i<6;i++) {
			int idx;
			do {
				idx = r.nextInt(red.length);//0-32
			} while (used[idx]);//如果使用了继续找下一个
			used[idx] = true;//标记使用了
			all[i] = red[idx];//取出一个未使用的红球
		}
		all[all.length-1] = blue[r.nextInt(blue.length)];
		Arrays.sort(all);
		return Arrays.toString(all);
	}
}
