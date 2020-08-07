package com.itheima.test11;

public class LuckDraw implements Runnable {
	// 员工人数
	private int number = 100;

	public void run() {
		// 获得线程的名字
		String name = Thread.currentThread().getName();
		// 定义变量统计人数
		int count = 0;
		// 开始进场抽奖,
		while (true) {
			synchronized (this) {
				// 首先判断number,大于0才能抽奖
				if (number > 0) {
					// 使用工具类生成一个彩票号码给这个员工
					String dc = DoubleColorBallUtil.create();
					// 输出抽中的彩票号
					System.out.println("编号为: " + number + " 的员工 从"+name+"入场! 拿到的双色球彩票号码是: " + dc);
					// 进入一个员工,少一个员工
					number--;
					// 计数加一
					count ++;
					// 休眠
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					// 抽奖完毕,大于前后门入场的员工人数
					// 从后门入场的员工总共: 13 位员工
					// 从前门入场的员工总共: 87 位员工
					System.out.println("从" + name + "入场的员工总共: " + count + " 位员工");
					break;
				}
			}
		}
	}
}
