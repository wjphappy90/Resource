package com.itheima;

import com.itheima.util.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

public class Service {
    private String id;
    private int num;

    public Service(String id,int num){
        this.id = id;
        this.num = num;
    }
    //控制单元
    public void service(){
//        Jedis jedis = new Jedis("127.0.0.1",6379);
        Jedis jedis = JedisUtils.getJedis();
        String value = jedis.get("compid:"+id);
        //判断该值是否存在
        try{
            if(value == null){
                //不存在，创建该值
                jedis.setex("compid:"+id,5,Long.MAX_VALUE-num+"");
            }else{
                //存在，自增，调用业务
                Long val = jedis.incr("compid:"+id);
                business(id,num-(Long.MAX_VALUE-val));
            }
        }catch (JedisDataException e){
            System.out.println("使用已经到达次数上限，请升级会员级别");
            return;
        }finally{
            jedis.close();
        }
    }
    //业务操作
    public void business(String id,Long val){
        System.out.println("用户:"+id+" 业务操作执行第"+val+"次");
    }
}

class MyThread extends Thread{
    Service sc ;
    public MyThread(String id,int num){
        sc = new Service(id,num);
    }
    public void run(){
        while(true){
            sc.service();
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("初级用户",10);
        MyThread mt2 = new MyThread("高级用户",30);
        mt1.start();
        mt2.start();
    }
}