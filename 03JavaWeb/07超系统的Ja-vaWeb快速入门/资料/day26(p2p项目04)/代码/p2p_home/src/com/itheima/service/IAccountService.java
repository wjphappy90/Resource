package com.itheima.service;

import com.itheima.domain.Account;

public interface IAccountService {

	Account findByCustomer(int id) throws Exception;

}
