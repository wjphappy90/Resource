package com.itheima.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import com.itheima.utils.JPAUtil;

/**
 * JPA的多对多操作：
 * 		保存操作
 * 		删除操作
 * @author zhy
 *
 */
public class JPADemo1 {
	/**
	 * 保存操作
	 * 		创建两个用户
	 * 		创建三个角色
	 * 		让1号用户具备1号和2号角色
	 * 		让2号用户具备2号和3号角色
	 * 		保存用户和角色
	 */
	@Test
	public void test1(){
		SysUser u1 = new SysUser();
		SysUser u2 = new SysUser();
		u1.setUserName("JPA Many to Many u1");
		u2.setUserName("JPA Many to Many u2");
		
		SysRole r1 = new SysRole();
		SysRole r2 = new SysRole();
		SysRole r3 = new SysRole();
		
		r1.setRoleName("JPA Many to Many r1");
		r2.setRoleName("JPA Many to Many r2");
		r3.setRoleName("JPA Many to Many r3");
		
		//建立用户和角色的关联关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		u2.getRoles().add(r2);
		u2.getRoles().add(r3);
		
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		r3.getUsers().add(u2);
		
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//保存操作
		em.persist(u1);

		tx.commit();
		em.close();
		
	}
	
	/**
	 * 删除操作
	 * 		双向级联删除，不管是hibernate还是Jpa,多对多中都不能配置
	 */
	@Test
	public void test2(){
		EntityManager em = JPAUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//查询用户
		SysUser u1 = em.find(SysUser.class, "8a7e83cc5fbf19b6015fbf19bada0000");
		em.remove(u1);
		tx.commit();
		em.close();
	}
}
