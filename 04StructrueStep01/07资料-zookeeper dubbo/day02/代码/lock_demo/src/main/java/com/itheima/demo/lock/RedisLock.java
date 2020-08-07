package com.itheima.demo.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Component
public class RedisLock implements Lock {

    private static final String LOCK_NAME = "redis_stock_lock";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void lock() {
        while(true){
            //上锁 setnx
          //  Boolean isLock = redisTemplate.opsForValue().setIfAbsent("lockName", LOCK_NAME);
            Boolean isLock =  redisTemplate.opsForValue().setIfAbsent("lockName",LOCK_NAME,10,TimeUnit.SECONDS);
            //思考 锁过期怎么办？如何保证锁不过期 锁的自动续期 20 18 20 20
            if(isLock){
                return;
            }else{
                System.out.println("等待锁........");
            }
        }

    }


    @Override
    public void unlock() {
        // 删除指定的锁的key
        redisTemplate.delete("lockName");
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
