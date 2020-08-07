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
	public List<Customer> findAllCustomer(DetachedCriteria dCriteria) {
		return customerDao.findAll(dCriteria);
	}

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

}
