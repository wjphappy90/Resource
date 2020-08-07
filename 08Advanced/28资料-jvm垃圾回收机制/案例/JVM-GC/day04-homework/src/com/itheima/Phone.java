package com.itheima;
//李雷想买一个价值7988元的新手机，她的旧手机在二手市场能卖1500元，而手机专卖店推出以旧换新的优惠，
// 把她的旧手机交给店家，新手机就能够打8折优惠。为了更省钱，李雷要不要以旧换新？请在控制台输出。
public class Phone {
    public static void main(String[] args) {
        //二手市场李雷需要补差价
        int oldPrice = 1500;
        double price = (7998 - 1500) * 1.0;
        System.out.println("二手市场后李磊需要补的差价为: " + price);
        //以旧换新
        double newPrice = 7998 * 0.8;
        System.out.println("以旧换新的价格为: " + newPrice);
        if(newPrice < price){
            System.out.println("李磊应该以旧换新");
        }else {
            System.out.println("不应该以旧换新");
        }

    }
}
