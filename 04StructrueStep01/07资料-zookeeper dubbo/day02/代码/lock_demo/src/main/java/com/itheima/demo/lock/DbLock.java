package com.itheima.demo.lock;

import com.itheima.demo.bean.LockRecord;
import com.itheima.demo.mapper.LockRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Component
public class DbLock implements Lock {

    private static final String LOCK_NAME = "db_lock_stock";


    @Autowired
    private LockRecordMapper lockRecordMapper;

    //上锁
    @Override
    public void lock() {
        while(true){
            if(tryLock()){
                //向锁表中插入一条记录
                LockRecord lockRecord = new LockRecord();
                lockRecord.setLockName(LOCK_NAME);
                lockRecordMapper.insertSelective(lockRecord);
                return;
            }else{
                System.out.println("等待锁.......");
            }
        }
    }

    //尝试获取锁
    @Override
    public boolean tryLock() {
        //查询lockRecord的记录
        Example example = new Example(LockRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("lockName",LOCK_NAME);
        LockRecord lockRecord = lockRecordMapper.selectOneByExample(example);
        if(lockRecord==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    //释放锁的操作
    @Override
    public void unlock() {
        Example example = new Example(LockRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("lockName",LOCK_NAME);
        lockRecordMapper.deleteByExample(example);
    }

    @Override
    public Condition newCondition() {
        return null;
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }
}
