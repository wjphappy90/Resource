package cn.itcast.dao;

import cn.itcast.domain.Customer;

public interface CustomerDao {

	Customer findOne(String custId);

}
