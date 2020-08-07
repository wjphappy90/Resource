package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.LinkMan;

/**
 * 联系人的持久层接口
 * @author zhy
 *
 */
public interface ILinkManDao {
	/**
	 * 查询所有联系人
	 * @param dCriteria
	 * @return
	 */
	List<LinkMan> findAll(DetachedCriteria dCriteria);
	
	
	/**
	 * 新增联系人
	 * @param linkman
	 */
	void save(LinkMan linkman);


	/**
	 * 删除联系人
	 * @param lkmId
	 */
	void delete(Long lkmId);
	
	/**
	 * 根据id查询联系人
	 * @param lkmId
	 * @return
	 */
	LinkMan findById(Long lkmId);
	
	/**
	 * 更新联系人
	 * @param linkman
	 */
	void update(LinkMan linkman);

}
