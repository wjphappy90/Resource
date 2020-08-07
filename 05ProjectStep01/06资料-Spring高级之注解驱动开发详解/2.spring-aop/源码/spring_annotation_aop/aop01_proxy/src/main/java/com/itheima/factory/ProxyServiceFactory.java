package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于生产service代理对象的工厂
 * 此处我们只做入门，实现对AccountService的代理创建，同时加入事务
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
public class ProxyServiceFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;


    @Bean("proxyAccountService")
    public AccountService getProxyAccountService(){
        //1.创建代理对象
        AccountService proxyAccountService = (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //1.定义返回值
                        Object rtValue = null;
                        try{
                            //开始事务
                            transactionManager.begin();
                            //执行被代理对象的方法
                            rtValue = method.invoke(accountService,args);
                            //提交事务
                            transactionManager.commit();
                        }catch (Exception e){
                            //回滚事务
                            transactionManager.rollback();
                            e.printStackTrace();
                        }finally {
                            //释放资源
                            transactionManager.close();
                        }

                        //返回
                        return rtValue;
                    }
                });
        //2.返回
        return proxyAccountService;
    }
}
