package com.itheima.service;

import com.itheima.domain.Customer;

public interface ICustomerService {

	void addCustomer(Customer c);

	Customer findByName(String c_name) throws Exception;

	Customer findByEmail(String email) throws Exception;

	Customer login(String c_name, String password) throws Exception;

	void updateEmailStatus(String email) throws Exception;

	

}
