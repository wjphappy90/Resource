package cn.itcast.service;

import cn.itcast.domain.Customer;

public interface CustomerService {

	Customer findOne(String custId);

}
