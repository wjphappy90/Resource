package com.itheima.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色的实体类
 * @author zhy
 *
 */
@Entity
@Table(name="sys_role")
public class SysRole implements Serializable {

	@Id
	@Column(name="role_id")
	@GenericGenerator(name="uuid",strategy="uuid")//声明一个主键生成器 name属性：给生成器起个名字。strategy：指定的就是hibernate中包含的生成策略
	@GeneratedValue(generator="uuid")
	private String roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_memo")
	private String roleMemo;
	
	//多对多关系映射：一个角色可以赋予多个用户
	@ManyToMany(cascade=CascadeType.ALL)
	//加入一张表
	@JoinTable(name="user_role_ref",
			  joinColumns={@JoinColumn(name="role_id",referencedColumnName="role_id")},//写的是当前实体在中间表的外键字段
			  inverseJoinColumns={@JoinColumn(name="user_id",referencedColumnName="user_id")}//写的是对方实体在中间表的外键字段
	)
	private Set<SysUser> users = new HashSet<SysUser>(0);
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleMemo() {
		return roleMemo;
	}
	public void setRoleMemo(String roleMemo) {
		this.roleMemo = roleMemo;
	}
	public Set<SysUser> getUsers() {
		return users;
	}
	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName + ", roleMemo=" + roleMemo + "]";
	}
	
	
}
