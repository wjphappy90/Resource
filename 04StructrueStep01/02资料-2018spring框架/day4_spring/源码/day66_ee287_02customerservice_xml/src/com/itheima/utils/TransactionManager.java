package com.itheima.utils;

import org.hibernate.Session;

/**
 * 事务管理类
 * @author zhy
 *
 */
public class TransactionManager {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * 开启事务
	 */
	public void beginTransaction(){
		session.beginTransaction();
	}
	
	/**
	 * 提交事务
	 */
	public void commit(){
		session.beginTransaction().commit();
	}
	
	
	/**
	 * 回滚事务
	 */
	public void rollback(){
		session.beginTransaction().rollback();
	}
}
