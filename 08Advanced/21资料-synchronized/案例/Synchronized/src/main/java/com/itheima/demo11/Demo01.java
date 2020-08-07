package com.itheima.demo11;

import java.util.Hashtable;

public class Demo01 {
    public static void main(String[] args) {
        Hashtable hs = new Hashtable();
        hs.put("aa", "bb");
        hs.put("xx", "yy");
        hs.get("a");
        hs.remove("b");


    }

    public void test01() {
        synchronized (Demo01.class) {

        }
    }

    public void test02() {
        synchronized (Demo01.class) {

        }
    }
}
