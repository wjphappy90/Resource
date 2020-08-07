package com.itheima.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itheima.dao.ILinkManDao;
import com.itheima.domain.LinkMan;

/**
 * 联系人的持久层实现类
 * @author zhy
 *
 */
@Repository("linkmanDao")
public class LinkManDaoImpl implements ILinkManDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(LinkMan linkman) {
		hibernateTemplate.save(linkman);
	}

	@Override
	public List<LinkMan> findAll(DetachedCriteria dCriteria) {
		return (List<LinkMan>) hibernateTemplate.findByCriteria(dCriteria);
	}
	
	@Override
	public LinkMan findById(Long lkmId) {
		return hibernateTemplate.get(LinkMan.class, lkmId);
	}

	@Override
	public void delete(Long lkmId) {
		hibernateTemplate.delete(findById(lkmId));
	}

	@Override
	public void update(LinkMan linkman) {
		hibernateTemplate.update(linkman);
	}	

}
