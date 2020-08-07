package com.itheima.test03;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingReceipt {
	
	// 定义集合存储商品
	static ArrayList<GoodsItem> items = new ArrayList<GoodsItem>();
	// 定义集合存储用户购买的商品项
	static ArrayList<GoodsItem> shoppingCar = new ArrayList<GoodsItem>();

	public static void main(String[] args) {
		// 初始化商
		initGoodsItems();
		// 打印欢迎语句
		System.out.println("\t欢迎使用超市购物系统");
		// 创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		// 循环使用购物系统
		while(true){
			System.out.println("请输入你要进行的操作：\n1:购买商品\t 2:结算并打印小票\t3:退出系统");
			int optNumber = sc.nextInt();
			switch (optNumber) {
				case 1: // 购买商品
					buyGoods();
					break;
				case 2: // 打印小票
					printTicket();
					break;
				case 3:
					System.out.println("感谢您使用超市购物系统,欢迎下次光临,拜拜");
					// 退出购物系统
					System.exit(0);
					break;
				default:
					System.out.println("你输入的数字有误,请重新输入");
					break;
			}
		}
	}
	
	/*
	 * 打印小票
	 */
	public static void printTicket(){
		// 判断是否已经购买了商品
		if(shoppingCar.size() == 0) {
			System.out.println("您还没购买任何商品,无法结算,请先购买！！");
			return;
		}
		System.out.println("------------------------------");
		
		// 票头
		System.out.println("\t欢迎光临");
		System.out.println("名称\t售价\t数量\t金额");
		System.out.println("------------------------------");
		
		// 记录总数量
		int totalNumber = 0;
		// 记录总价格
		double totalMoney = 0;
		// 票体
		for (int index = 0; index < shoppingCar.size(); index++) {
			// 获得每一个商品项
			GoodsItem goodsItem = shoppingCar.get(index);
			totalNumber += goodsItem.getNumber();
			totalMoney += goodsItem.getMoney();
			System.out.println(goodsItem.getName()+"\t"+goodsItem.getPrice()+
					"\t"+goodsItem.getNumber()+"\t"+goodsItem.getMoney());
		}
		System.out.println("------------------------------");
		// 票尾
		System.out.println(shoppingCar.size()+"项商品");
		System.out.println("共计:"+totalNumber+"件");
		System.out.println("共:"+totalMoney+"元");
		System.out.println("------------------------------");
		// 清空集合
		shoppingCar.clear();
	}

	/*
	 * 购买商品
	 */
	public static void buyGoods() {
		System.out.println("------------------------------");
		System.out.println("\t商品列表");
		System.out.println("商品id\t名称\t单价\t计价单位");
		// 展示所有商品项
		for (int index = 0; index < items.size(); index++) {
			// 获取每一个商品项
			GoodsItem goodsItem = items.get(index);
			System.out.println(goodsItem.getId()+"\t"+goodsItem.getName()+"\t"
			+goodsItem.getPrice()+"\t"+goodsItem.getUnit());
		}
		System.out.println("------------------------------");
		System.out.println("请输入您要购买的商品项(输入格式:商品id-购买数量),输入end表示购买结束。");
		// 创建键盘输入对象
		Scanner sc = new Scanner(System.in);
		while(true){
			// 接收用户输入
			String str = sc.nextLine();
			if(str.equals("end")){ // 结束购买
				System.out.println("购买结束");
				break;
			} else {
				String[] strs = str.split("-");
				if(strs.length != 2) {
					System.out.println("你输入的购买姿势不对,请换个姿势再来一次(格式:商品id-购买数量)");
					continue;
				}
				// 获得商品id
				String id = strs[0];
				// 获得商品数量
				int number = Integer.parseInt(strs[1]);
				// 根据商品id获得商品项
				GoodsItem item = findGoodsItemById(id);
				if(item != null) {
					item.setNumber(number);
					item.setMoney(number * item.getPrice());
					// 添加商品到购物车
					addItemToShoppingCar(item);
				} else {
					// 用户输入的商品id不存在
					System.out.println("您输入的商品id不存在,请重新输入!!");
				}
			}
		}
	}
	
	/*
	 * 添加商品到购物车
	 */
	public static void addItemToShoppingCar(GoodsItem item){
		// 遍历购物车中的所有商品项
		for (int index = 0; index < shoppingCar.size(); index++) {
			// 获取每一个商品项
			GoodsItem goodsItem = shoppingCar.get(index);
			if(goodsItem.getId().equals(item.getId())){
				goodsItem.setNumber(goodsItem.getNumber() + item.getNumber());
				goodsItem.setMoney(goodsItem.getPrice() * goodsItem.getNumber());
				return;
			}
		}
		// 将要够购买的商品项添加集合中
		shoppingCar.add(item);
	}

	/*
	 * 根据商品项id查找商品
	 */
	public static GoodsItem findGoodsItemById(String id){
		// 遍历所有商品项
		for (int index = 0; index < items.size(); index++) {
			// 获取每一个商品项
			GoodsItem goodsItem = items.get(index);
			if(goodsItem.getId().equals(id)){
				// 创建购买商品对象
				return new GoodsItem(goodsItem.getName(), id, goodsItem.getPrice(), 0, goodsItem.getUnit(), 0);
			}
		}
		return null;
	}
	
	/*
	 * 初始化商项
	 */
	public static void initGoodsItems() {
		// 创建多个商品项
		GoodsItem item1 = new GoodsItem("少林核桃", "001", 15.5, 0, "斤", 0);
		GoodsItem item2 = new GoodsItem("尚康饼干", "002", 14.5, 0, "包", 0);
		GoodsItem item3 = new GoodsItem("移动硬盘", "003", 345, 0, "个", 0);
		GoodsItem item4 = new GoodsItem("高清无码", "004", 199, 0, "G", 0);
		// 将商品项添加到集合中
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
	}
}
