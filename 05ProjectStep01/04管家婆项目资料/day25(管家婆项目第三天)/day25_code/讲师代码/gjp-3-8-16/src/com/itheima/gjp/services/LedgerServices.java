package com.itheima.gjp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itheima.gjp.dao.LedgerDao;
import com.itheima.gjp.dao.SortDao;
import com.itheima.gjp.domain.Ledger;
import com.itheima.gjp.domain.QueryForm;

public class LedgerServices {
	private LedgerDao ledgerDao = new LedgerDao();
	private SortDao sortDao = new SortDao();
	/*
	 * 定义方法,返回值是Map集合
	 * 作用,根据用户的条件,查询数据库(List集合)
	 * 遍历List集合,统计收入和支出的求和计算
	 * 存储到Map集合
	 * 
	 * 调用dao层方法查询结果的List集合
	 */
	public Map<String,Object> queryLedgerByQueryForm(QueryForm form){
		List<Ledger> list = ledgerDao.queryLedgerByQueryForm(form);
		
		double in = 0;
		double pay = 0;
		
		for(Ledger ledger : list){
			int sid = ledger.getSid();
			//调用dao层SortDao方法getSnameBySid,传递sid,获取出sname
			String sname = sortDao.getSnameBySid(sid);
			ledger.setSname(sname);
			if(ledger.getParent().equals("收入")){
				in += ledger.getMoney();
			}else{
				pay += ledger.getMoney();
			}
		}
		//创建Map集合,将数据,List,in,pay存储到Map集合中
		Map<String , Object> data = new HashMap<String, Object>();
		data.put("ledger", list);
		data.put("in",in);
		data.put("pay", pay);
		return data;
	}
}
