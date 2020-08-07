package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.event.MyApplicationEvent;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private TransactionTemplate transactionTemplate;


    @Override
    public void transfer(String sourceName, String targetName, Double money) {

        transactionTemplate.execute(new TransactionCallback<Object>() {
            /**
             * 业务的核心代码都是写在此方法内部的
             * @param status
             * @return
             */
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try{
                    //1.根据名称查询转出账户
                    Account source = accountDao.findByName(sourceName);
                    //2.根据名称查询转入账户
                    Account target = accountDao.findByName(targetName);
                    //3.转出账户减钱
                    source.setMoney(source.getMoney() - money);
                    //4.转入账户加钱
                    target.setMoney(target.getMoney() + money);
                    //5.更新转出账户
                    accountDao.update(source);

                    //模拟转账异常
                    int i = 1 / 0;

                    //6.更新转入账户
                    accountDao.update(target);

                    //发布事件（转账完成了）
                }finally {
                    Map map = new HashMap<>();
                    map.put("sourceName",sourceName);
                    map.put("targetName",targetName);
                    map.put("money",money);
                    applicationEventPublisher.publishEvent(new MyApplicationEvent(map));
                }
                return null;
            }
        });
    }

}
