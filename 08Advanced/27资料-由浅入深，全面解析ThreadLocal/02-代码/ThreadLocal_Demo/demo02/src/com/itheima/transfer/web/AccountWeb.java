package com.itheima.transfer.web;

import com.itheima.transfer.service.AccountService;

public class AccountWeb {

    public static void main(String[] args) {
        // 模拟数据 : Jack 给 Rose 转账 100
        String outUser = "Jack";
        String inUser = "Rose";
        int money = 100;

        AccountService as = new AccountService();
        boolean result = as.transfer(outUser, inUser, money);

        if (result == false) {
            System.out.println("转账失败!");
        } else {
            System.out.println("转账成功!");
        }

    }
}
