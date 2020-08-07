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
	private static ThreadLocal<EntityManager> tl ;
	
	static{
		factory = Persistence.createEntityManagerFactory("myJPAUnit");
		tl = new ThreadLocal<EntityManager>();
	}
	
	/**
	 * 获取JPA操作数据库的对象
	 * @return
	 
	private static EntityManager  createEntityManager(){
		return factory.createEntityManager();
	}*/
	
	/**
	 * 获取EntityManager对象
	 * @return
	 */
	public static EntityManager createEntityManager(){
		//1.从当前线程上获取entityManager对象
		EntityManager em = tl.get();
		if(em == null){
			em = factory.createEntityManager();
			tl.set(em);
		}
		return tl.get();
	}

	public static void main(String[] args) {
		createEntityManager();
	}
}
