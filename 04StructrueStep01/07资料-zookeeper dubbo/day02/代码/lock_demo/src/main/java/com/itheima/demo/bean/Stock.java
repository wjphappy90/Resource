package com.itheima.demo.bean;

public class Stock {

    //库存为1
    private static int num = 1;

    public static boolean reduseStock(){

        if(num>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
            return true;
        }
         return false;
    }
}
