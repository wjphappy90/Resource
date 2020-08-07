package com.itheima.sh.web;

import java.util.Scanner;

import com.itheima.sh.domain.Product;
import com.itheima.sh.service.ProductService;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/*
 * --------欢迎来到商品管理系统--------

输入以下命令进行操作：

C:添加商品 D:根据编号删除商品 DA:删除所有商品 I:根据商品编号查询商品信息 FA:查询所有商品信息 Q:退出

 */
public class ProductWeb {

	public static void main(String[] args) {
		// 创建键盘录入的对象
		Scanner sc = new Scanner(System.in);
		// 伪类让程序能够回到这里，我们使用循环
		while (true) {
			// 提示
			System.out.println("--------欢迎来到商品管理系统--------");
			System.out.println("输入以下命令进行操作：");
			System.out.println("C:添加商品 D:根据编号删除商品 DA:删除所有商品 I:根据商品编号查询商品信息 FA:查询所有商品信息 Q:退出");
			// 获取输入的信息
			String inputChoice = sc.nextLine();
			// 使用多分支进行选择
			switch (inputChoice.toUpperCase()) {
			case "C":
				// System.out.println("添加商品");
				// 调用方法向数据库中添加商品
				addProduct();
				break;
			case "D":
				// System.out.println("根据编号删除商品");
				// 根据编号删除商品
				deleteProductByPid();
				break;
			case "DA":
				System.out.println("删除所有商品 ");
				break;
			case "I":
				// System.out.println("根据商品编号查询商品信息");
				findProductsByPid();
				break;
			case "FA":
				// System.out.println("查询所有商品信息");
				// 调用方法 查询所有商品信息
				findAllProducts();
				break;
			case "Q":
				// System.out.println("退出");
				// break;
			default:
				// System.out.println("退出");
				System.out.println("谢谢光临");
				// 终止虚拟机
				System.exit(0);
				break;
			}
		}

	}

	// 根据编号删除商品
	public static void deleteProductByPid() {
		// 创建键盘录入的对象
		Scanner sc = new Scanner(System.in);
		try {
			//提示
			System.out.println("请输入要删除的商品编号：");
			//获取
			int pid = Integer.parseInt(sc.nextLine());
			//先到数据库中查询商品是否存在
			ProductService productService = new ProductService();
			//查询
			DBCursor cur = productService.findProductsByPid(pid);
			//判断
			if(cur.size() == 0)
			{
				System.out.println("对不起，没有您要删除商品");
				return;
			}
			//如果程序执行到这里，说明数据库中是存在该商品的
			//显示
			System.out.println("商品编号\t商品名称\t商品价格");
			while(cur.hasNext())
			{
				//取出商品
				DBObject product = cur.next();
				//输出
				System.out.println(product.get("pid")+"\t"+product.get("pname")+"\t"+product.get("price"));
			}
			//提示是否确定删除
			System.out.println("这么好的商品，您确定要删除吗?按y");
			//获取
			String yes = sc.nextLine();
			//判断
			if("y".equals(yes))
			{
				//说明确定删除
				productService.deleteProductByPid(pid);
				System.out.println("删除商品成功");
			}else
			{
				//说明取消删除
				System.out.println("取消删除");
			}
		} catch (Exception e) {
			System.out.println("根据商品编号查询商品失败"+e);
		}

	}

	// 添加商品
	public static void addProduct() {
		// 创建键盘录入的对象
		Scanner sc = new Scanner(System.in);
		try {
			// 提示
			System.out.println("请输入商品编号：");
			// 获取
			String pidStr = sc.nextLine();
			int pid = Integer.parseInt(pidStr);
			// 提示
			System.out.println("请输入商品名称：");
			// 获取
			String pname = sc.nextLine();
			// 提示
			System.out.println("请输入商品价格：");
			// 获取
			String priceStr = sc.nextLine();
			int price = Integer.parseInt(priceStr);
			// 创建Product类的对象
			Product p = new Product();
			// 封装数据
			p.setPid(pid);
			p.setPname(pname);
			p.setPrice(price);
			// 创建业务层对象
			ProductService productService = new ProductService();
			// 调用方法向业务层传递数据
			productService.addProduct(p);
			System.out.println("商品添加成功");
		} catch (Exception e) {
			System.out.println("添加商品失败" + e);
		}
	}

	// 根据商品编号查询商品信息
	public static void findProductsByPid() {
		// 创建键盘录入的对象
		Scanner sc = new Scanner(System.in);
		try {
			// 提示
			System.out.println("请输入要查询的商品编号：");
			// 获取
			String pidStr = sc.nextLine();
			// 强转
			int pid = Integer.parseInt(pidStr);
			// 创建业务层对象
			ProductService productService = new ProductService();
			// 调用方法根据录入商品pid到数据库中查询商品信息
			DBCursor cur = productService.findProductsByPid(pid);
			// 判断是否存在录入的pid对应的商品
			if (cur.size() != 0) {
				// 说明有该商品
				System.out.println("商品编号\t商品名称\t商品价格");
				// 遍历右边
				while (cur.hasNext()) {
					// 说明有数据
					// 取出商品
					DBObject product = cur.next();
					// 输出
					System.out.println(product.get("pid") + "\t" + product.get("pname") + "\t" + product.get("price"));
				}
			} else {
				System.out.println("对不起，没有您要查询的商品信息");
			}
		} catch (Exception e) {
			System.out.println("根据商品编号查询商品失败" + e);
		}

	}

	// 查询所有商品信息
	public static void findAllProducts() {
		// 创建业务层对象
		ProductService productService = new ProductService();
		try {
			// 调用方法获取所有商品信息
			DBCursor cur = productService.findAllProducts();
			// 根据cur判断数据库中是否含有数据
			if (cur.size() == 0) {
				// 说明没有数据
				System.out.println("对不起，数据库中没有您要查询的数据");
			} else {
				// 说明有数据 获取cur游标中的数据
				System.out.println("商品编号\t商品名称\t商品价格");
				while (cur.hasNext()) {
					// 获取商品 获取每一行 {"name":"BMW"}
					DBObject product = cur.next();
					// 输出
					System.out.println(product.get("pid") + "\t" + product.get("pname") + "\t" + product.get("price"));
				}
			}
		} catch (Exception e) {
			System.out.println("查询所有商品失败" + e);
		}
	}
}
