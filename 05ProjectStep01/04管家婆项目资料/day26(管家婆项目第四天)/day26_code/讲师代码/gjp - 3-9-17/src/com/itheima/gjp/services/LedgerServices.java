package com.itheima.gjp.services;

import java.util.HashMap;
import java.util.Hashtable;
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
	 * queryTotalMoneyByParent
	 * 调用dao层方法queryTotalMoneyByParent,获取收入或者支出的所有金额的总和
	 */
	public Double queryTotalMoneyByParent(String parent){
		return ledgerDao.getTotalMoney(parent);
	}
	
	/*
	 * 调用dao层querySumMoneyBySort,传递父分类,获取这个分类下的求和数据
	 * 每个分类名称进行分组
	 * Map: 键存储的是分类名称,值存储的是这个名称所有金额总和
	 */
	public Map<String,Double> querySumMoneyBySort(String parent){
		List<Object[]> list = ledgerDao.querySumMoneyBySort(parent);
		//创建Map集合: 键存储的是分类名称,值存储的是这个名称所有金额总和
		Map<String,Double> map = new HashMap<String,Double>();
		//遍历集合List,获取出Object数组,(根据sid值,找sname)
		for(Object[] objects : list){
			Double money = (Double)objects[0];
			int sid = (int)objects[1];
			//调用sortDao方法,传递sid获取sname
			String sname = sortDao.getSnameBySid(sid);
			//求和的值,和分类名称,存储到Map集合
			map.put(sname, money);
		}
		return map;
	}
	
	
	/*
	 * 定义方法,删除账务
	 * deleteLedger,传递lid值
	 */
	public void deleteLedger(int lid){
		ledgerDao.deleteLedger(lid);
	}
	
	/*
	 * 定义方法,编辑账务
	 * editLedger,传递Ledger对象
	 */
	public void editLedger(Ledger ledger){
		ledgerDao.editLedger(ledger);
	}
	/*
	 * 定义方法,添加账务
	 * addLedger,传递Ledger对象
	 */
	public void addLedger(Ledger ledger){
		ledgerDao.addLedger(ledger);
	}
	
	
	/*
	 * 定义方法,调用sortDao方法 getSidBySname,传递sname
	 * 获取sid
	 */
	public int getSidBySname(String sname){
		return  sortDao.getSidBySname(sname);
	}
	
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
