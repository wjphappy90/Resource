package com.itheima.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA的工具类
 * @author zhy
 *
 */
public class JPAUtil {
	//它就相当于SessionFactory
	private static EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("myJPAUnit");
	}
	
	/**
	 * 获取JPA操作数据库的对象
	 * @return
	 */
	public static EntityManager  createEntityManager(){
		return factory.createEntityManager();
	}
	
	public static void main(String[] args) {
		createEntityManager();
	}
}
