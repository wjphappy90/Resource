package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate的工具类
 * 用于获取Session对象
 * 
 * 使用工具类原因：
 * 	1.简化代码
 * 	2.保证SessionFactory不会反复的创建和销毁
 * @author zhy
 *
 */
public class HibernateUtil {

	private static SessionFactory factory;
	
	static{
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("初始化SessionFactory失败！");
		}
	}
	
	/**
	 * 每次都是从当前线程上获取Session
	 * @return
	 */
	public static Session getCurrentSession(){
		return factory.getCurrentSession();
	}
	
	/**
	 * 开启事务
	 */
	public static void beginTransaction(){
		getCurrentSession().beginTransaction();
	}
	
	/**
	 * 提交事务
	 */
	public static void commit(){
		getCurrentSession().beginTransaction().commit();
	}
	
	/**
	 * 回滚事务
	 */
	public static void rollback(){
		getCurrentSession().beginTransaction().rollback();
	}
	
	
	public static void main(String[] args) {
		getCurrentSession();
	}
}
