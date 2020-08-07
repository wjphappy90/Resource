package com.itheima.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.IBaseDictDao;
import com.itheima.dao.ICustomerDao;
import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.web.commons.Page;

/**
 * 客户的业务层熟实现类
 * @author zhy
 *
 */
@Service("customerService")
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class CustomerServiceImpl implements ICustomerService {
	
	@Resource(name="customerDao")
	private ICustomerDao customerDao;
	
	@Resource(name="baseDictDao")
	private IBaseDictDao baseDictDao;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<BaseDict> findAllCustomerSource() {
		return baseDictDao.findBaseDictByTypeCode("002");
	}

	@Override
	public List<BaseDict> findAllCustomerLevel() {
		return baseDictDao.findBaseDictByTypeCode("006");
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void removeCustomer(Long custId) {
		customerDao.delete(custId);
	}

	@Override
	public Customer findCustomerById(Long custId) {
		return customerDao.findById(custId);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerDao.findAll();
	}

	@Override
	public Page findAllCustomer(DetachedCriteria dCriteria, Integer num) {
		//1.准备当前页信息
		int currentPageNum = 1;
		if(num != null){
			currentPageNum = num;
		}
		//2.获取总记录条数
		int totalRecords = customerDao.findTotalRecords(dCriteria);
		//3.创建一个page对象
		Page page = new Page(currentPageNum,totalRecords);
		//4.使用page对象中的数据，查询带有分页的结果集
		List<Customer> records = customerDao.findAll(dCriteria, page.getStartIndex(), page.getPageSize());
		//5.把查询出来的结果集封装到page对象中
		page.setRecords(records);
		//6.返回page对象
		return page;
	}

}
