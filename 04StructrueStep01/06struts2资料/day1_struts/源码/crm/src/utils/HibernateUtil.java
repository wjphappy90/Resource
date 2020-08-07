package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate的工具类
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
			throw new ExceptionInInitializerError("初始化session工厂失败！");
		}
	}
	
	//每次从当前线程上获取一个Session,如果没有创建一个新的，并且绑定到当前线程上。
	public static Session getCurrentSession(){
		return factory.getCurrentSession();
	}
	
	
	public static Session openSession(){
		return factory.openSession();//永远都是获取一个新的
	}
	
	public static void main(String[] args) {
		Session s = getCurrentSession();
	}
}
