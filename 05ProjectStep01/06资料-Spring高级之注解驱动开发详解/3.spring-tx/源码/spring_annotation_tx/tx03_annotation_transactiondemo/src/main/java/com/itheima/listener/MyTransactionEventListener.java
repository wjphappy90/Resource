package com.itheima.listener;

import com.itheima.event.MyApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Map;

/**
 * 事务的时间监听器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
public class MyTransactionEventListener {

    /**
     * 当事务提交之后执行
     * @param event
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void doSomething(MyApplicationEvent event){
        //1.从事件对象中获取事件源
        Map map = (Map)event.getSource();
        //2.输出
        System.out.println("事务提交了，"+map.get("sourceName")+"给"+map.get("targetName")+"转了"+String.valueOf(map.get("money"))+"钱！转账成功");
    }

    /**
     * 当事务回滚之后执行
     * @param event
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void otherSomething(MyApplicationEvent event){
        //1.从事件对象中获取事件源
        Map map = (Map)event.getSource();
        //2.输出
        System.out.println("事务回滚了，"+map.get("sourceName")+"给"+map.get("targetName")+"转了"+String.valueOf(map.get("money"))+"钱！转账失败");
    }
}
