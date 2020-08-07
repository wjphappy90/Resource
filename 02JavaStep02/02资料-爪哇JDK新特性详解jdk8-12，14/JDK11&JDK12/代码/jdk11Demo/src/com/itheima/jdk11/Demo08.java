package com.itheima.jdk11;

import java.util.ArrayList;
import java.util.List;

public class Demo08 {
    public static void main(String[] args) {
        System.out.println("程序开始。。。");
        List<Garbage> lists = new ArrayList<>();
        int count = 0 ;
        while(true){
            lists.add(new Garbage(lists.size()));
            if(lists.size() == 1000000 && count == 0){
                lists.clear();
                count++;
            }
        }
        // System.out.println("程序结束。。。");
    }
}


class Garbage{
    private int num ;
    public Garbage(int num){
        this.num = num;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this+" is dying!");
    }
}