package com.itheima.utils;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

/**
 * 事务管理类
 * @author zhy
 *
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {
	
	@Resource(name="session")
	private Session session;

	@Pointcut("execution(* com.itheima.service.impl.*.*(..))")
	private void pt1(){}

	/**
	 * 开启事务
	 */
	@Before("pt1()")
	public void beginTransaction(){
		session.beginTransaction();
	}
	
	/**
	 * 提交事务
	 */
	@AfterReturning("pt1()")
	public void commit(){
		session.beginTransaction().commit();
	}
	
	
	/**
	 * 回滚事务
	 */
	@AfterThrowing("pt1()")
	public void rollback(){
		session.beginTransaction().rollback();
	}
}
