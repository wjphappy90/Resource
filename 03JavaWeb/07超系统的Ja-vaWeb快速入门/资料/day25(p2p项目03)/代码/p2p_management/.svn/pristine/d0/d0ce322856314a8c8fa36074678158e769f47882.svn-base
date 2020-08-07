package com.itheima.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.itheima.dao.IProductExpirationDAO;
import com.itheima.dao.impl.ProductExpirationDAOImpl;
import com.itheima.service.IProductExpirationService;

public class ProductExpirationServiceImpl implements IProductExpirationService {

	// 判断客户购买的产品是否到期
	@Override
	public void checkProductExpiration() {

		// 1.调用dao完成查询操作，主要查询客户投资的产品信息及当前这个产品的相关信息

		IProductExpirationDAO peDao = new ProductExpirationDAOImpl();

		try {
			// SELECT p.proLimit,pa.interest,pa.pa_date ,pa.c_id FROM product
			// p,product_account pa WHERE p.id=pa.p_id
			List<Object[]> list = peDao.findExpiration();

			// 2.判断产品是否到期
			for (Object[] obj : list) {
				// 判断产品是否到期
				int status = checkStatus((Date) obj[2], (int) obj[0]);
				if (status == 1) {
					// 到期---调用AccountDao修改帐户中的收益情况
					peDao.updateCustomerAccountInterest((double)obj[1],(int)obj[3]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 参数1 是购买产品的日期 参数二是产品的期限
	private int checkStatus(Date pa_date, int proLimit) {
		Calendar c = Calendar.getInstance();
		c.setTime(pa_date); // 当前的c就代表的是购买产品的日期
		c.add(Calendar.MONTH, proLimit); // 从购买产品开始+产品的期限的时间值

		if (c.getTimeInMillis() - new Date().getTime() >= 0) {
			// 未到期
			return 0;
		} else {
			// 到期
			return 1;
		}
	}

}
