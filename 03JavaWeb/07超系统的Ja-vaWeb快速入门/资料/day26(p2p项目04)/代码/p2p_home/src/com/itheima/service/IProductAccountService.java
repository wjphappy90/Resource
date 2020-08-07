package com.itheima.service;

import java.util.Map;

import com.itheima.domain.Account;
import com.itheima.domain.Customer;

public interface IProductAccountService {

	void buy(Account account, Customer customer, double money, int pid) throws Exception;

	Map<String, Object> findByCustomer(Customer customer) throws Exception;

}
