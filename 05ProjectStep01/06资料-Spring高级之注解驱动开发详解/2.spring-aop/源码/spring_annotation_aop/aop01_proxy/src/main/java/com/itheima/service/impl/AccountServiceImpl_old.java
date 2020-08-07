package com.itheima.service.impl;

/**
 * 账户的业务层实现
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
/*

@Service
public class AccountServiceImpl_old implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionManager transactionManager;

    @Override
    public void save(Account account) {
        try {
            //开启事务
            transactionManager.begin();

            accountDao.save(account);

            //提交事务
            transactionManager.commit();
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //释放连接
            transactionManager.close();
        }
    }

    @Override
    public void update(Account account) {
        try {
            //开启事务
            transactionManager.begin();

            accountDao.update(account);

            //提交事务
            transactionManager.commit();
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //释放连接
            transactionManager.close();
        }
    }

    @Override
    public void delete(Integer id) {

        try {
            //开启事务
            transactionManager.begin();

            accountDao.delete(id);

            //提交事务
            transactionManager.commit();
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //释放连接
            transactionManager.close();
        }
    }



    @Override
    public void transfer(String sourceName, String targetName, Double money) {

        try {
            //开启事务
            transactionManager.begin();

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
            int i=1/0;//模拟转账异常
            //6.更新转入账户
            accountDao.update(target);

            //提交事务
            transactionManager.commit();
        }catch (Exception e){
            //回滚事务
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //释放连接
            transactionManager.close();
        }
    }


    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}*/
