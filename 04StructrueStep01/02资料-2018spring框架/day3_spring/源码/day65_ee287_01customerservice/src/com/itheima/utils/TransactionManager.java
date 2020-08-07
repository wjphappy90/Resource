package com.itheima.utils;

/**
 * 事务管理类
 * @author zhy
 *
 */
public class TransactionManager {
	
	/**
	 * 开启事务
	 */
	public static void beginTransaction(){
		HibernateUtil.getCurrentSession().beginTransaction();
	}
	
	/**
	 * 提交事务
	 */
	public static void commit(){
		HibernateUtil.getCurrentSession().beginTransaction().commit();
	}
	
	
	/**
	 * 回滚事务
	 */
	public static void rollback(){
		HibernateUtil.getCurrentSession().beginTransaction().rollback();
	}
}
