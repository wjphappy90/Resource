package com.itheima.gjp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.gjp.domain.Ledger;
import com.itheima.gjp.domain.QueryForm;
import com.itheima.gjp.tools.DateUtils;
import com.itheima.gjp.tools.JDBCUtils;

public class LedgerDao {
	private SortDao sortDao = new SortDao();
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * getTotalMoney
	 * 通过分类查询今年的所有数据总和,传递参数,支出还是收入
	 */
	public Double getTotalMoney(String parent){
		try{
			String sql = "SELECT SUM(money) FROM gjp_ledger WHERE parent=? AND createtime LIKE ?";
			Object[] params = {parent,DateUtils.getYear()+"%"};
			return (Double)qr.query(sql, new ScalarHandler(),params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * querySumMoneyBySort
	 * 通过分类的名称查询所有分类数据的总和,传递参数,收入还是支出
	 */
	public List<Object[]>querySumMoneyBySort(String parent){
		try{
			//对所属于parent分类中的数据 ,进行求和查询计算,带分组
			String sql = "SELECT SUM(money),sid FROM gjp_ledger WHERE " +
					" parent=? AND createtime LIKE ? GROUP BY sid";
			Object[] params = {parent,DateUtils.getYear()+"%"};
			return qr.query(sql, new ArrayListHandler(),params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	/*
	 * 定义方法,删除账务
	 * 传递lid值
	 */
	public void deleteLedger(int lid){
		try {
			qr.update("DELETE FROM gjp_ledger WHERE lid=?",lid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 定义方法,编辑账务
	 * 传递Ledger对象
	 */
	public void editLedger(Ledger ledger){
		try{
		//拼写更新账务的SQL语句
		String sql = "UPDATE gjp_ledger SET parent=?,money=?,sid=?,account=?,createtime=?,ldesc=?" +
				" where lid=?";
		Object[] params = {ledger.getParent(),ledger.getMoney(),ledger.getSid(),
				ledger.getAccount(),ledger.getCreatetime(),ledger.getLdesc(),ledger.getLid()};
		qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	/*
	 *  定义方法,添加账务
	 *  传递Ledger对象
	 *  
	 */
	public void addLedger(Ledger ledger){
		try{
			//拼写添加账务的SQL语句
			String sql = "INSERT INTO gjp_ledger (parent,money,sid,account,createtime,ldesc)" +
					"values(?,?,?,?,?,?)";
			Object[] params = {ledger.getParent(),ledger.getMoney(),ledger.getSid(),
					ledger.getAccount(),ledger.getCreatetime(),ledger.getLdesc()};
			qr.update(sql,params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 定义方法,实现组合查询功能
	 * 传递QueryForm对象
	 * 返回List<Ledger>集合
	 * 根据QueryForm封装的数据,进行SQL语句的编写
	 */
	public List<Ledger> queryLedgerByQueryForm(QueryForm form){
		//查询语句中 ? 占位符,也是一个不确定因素,参数选择容器进行存储
		List<String> params = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		//查询条件,开始日期和结束日期,不需要理会,必选
		builder.append("SELECT * FROM gjp_ledger WHERE createtime between ? and ?");
		params.add(form.getBegin());
		params.add(form.getEnd());
		
		//builder ===SELECT * FROM gjp_ledger WHERE createtime between ? and ?
		//params  2016-01-01   2016-01-30
		
		//对查询条件 收入或者支出的选择,组合SQL语句
		if(form.getParent().equals("收入")||form.getParent().equals("支出")){
			builder.append(" and parent = ?");
			params.add(form.getParent());
		}
		//builder ===SELECT * FROM gjp_ledger WHERE createtime between ? and ?  and parent = ?
	    //params=== 2016-01-01   2016-01-30   收入 支出
		
		//对查询条件,分类名称的选择,进行SQL语句组合
		if(!form.getSname().equals("-请选择-")){
			//获取sname的值,取数据表中,查找sid的值
			//调用方法 SortDao类的方法getSidBySname,传递sname,获取sid
			int sid = sortDao.getSidBySname(form.getSname());
			builder.append(" and sid=?");
			params.add(sid+"");
		}
//builder ===SELECT * FROM gjp_ledger WHERE createtime between ? and ?  and parent = ? and sid=?
		//params===2016-01-01   2016-01-30   收入 支出 5
		try{
		List<Ledger> list = qr.query(builder.toString(), new BeanListHandler<Ledger>(Ledger.class),params.toArray());
		return list;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
