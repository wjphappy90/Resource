package com.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.LinkMan;

/**
 * 联系人的业务层接口
 * @author zhy
 *
 */
public interface ILinkManService {

	/**
	 * 新增联系人
	 * @param linkman
	 */
	void saveLinkMan(LinkMan linkman);
	
	/**
	 * 查询所有联系人
	 * @param dCriteria	查询的条件
	 * @return
	 */
	List<LinkMan> findAllLinkMan(DetachedCriteria dCriteria);
	
	/**
	 * 删除联系人
	 * @param lkmId
	 */
	void removeLinkMan(Long lkmId);
	
	/**
	 * 根据id查询联系人信息
	 * @param lkmId
	 * @return
	 */
	LinkMan findLinkManById(Long lkmId);
	
	/**
	 * 更新联系人
	 * @param linkman
	 */
	void updateLinkMan(LinkMan linkman);

}
