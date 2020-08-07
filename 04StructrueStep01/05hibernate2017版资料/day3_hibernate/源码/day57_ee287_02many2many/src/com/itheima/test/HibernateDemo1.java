package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import com.itheima.utils.HibernateUtil;

/**
 * 多对多的保存和删除操作
 * @author zhy
 *
 */
public class HibernateDemo1 {

	/**
	 * 保存操作
	 * 	需求：
	 * 		创建2个用户和3个角色
	 * 		让1号用户具备1号和2号角色
	 * 		让2号用户具备2号和3号角色
	 * 		保存用户和角色
	 */
	@Test
	public void test1(){
		SysUser u1 = new SysUser();
		u1.setUserName("用户1");
		SysUser u2 = new SysUser();
		u2.setUserName("用户2");
		
		SysRole r1 = new SysRole();
		r1.setRoleName("角色1");
		SysRole r2 = new SysRole();
		r2.setRoleName("角色2");
		SysRole r3 = new SysRole();
		r3.setRoleName("角色3");
		
		//建立双向关联关系
		//先建立用户的
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		u2.getRoles().add(r2);
		u2.getRoles().add(r3);
		//再建立角色
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		r3.getUsers().add(u2);
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(u1);
		s.save(u2);
		s.save(r1);
		s.save(r2);
		s.save(r3);
		tx.commit();
	}
	
	
	
	/**
	 * 删除操作
	 * 实际开发中：多对多的双向级联删除是禁止使用的
	 */
	@Test
	public void test2(){
		
		Session s = HibernateUtil.getCurrentSession();
		Transaction tx = s.beginTransaction();
		//1查询id为3的用户
		SysUser u3 = s.get(SysUser.class, 3L);
		//删除
		s.delete(u3);
		tx.commit();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
