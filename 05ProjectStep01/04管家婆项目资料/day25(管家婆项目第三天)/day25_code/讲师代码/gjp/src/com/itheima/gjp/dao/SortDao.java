package com.itheima.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.gjp.domain.Sort;
import com.itheima.gjp.tools.JDBCUtils;

/*
 * 访问数据库的类
 * SortDao类，负责分类功能
 */
public class SortDao {
	//类的成员位置，定义QueryRunner对象，所有的方法，都可以直接使用
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * 定义方法,传递分类的名称,返回分类的ID
	 */
	public int getSidBySname(String sname){
		try{
			String sql = "SELECT sid FROM gjp_sort where sname=?";
			return (int)qr.query(sql, new ScalarHandler(),sname);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	/*
	 * 定义方法,传递分类id,返回分类的具体名称
	 */
	public String getSnameBySid(int sid){
		try{
			String sql = "SELECT sname FROM gjp_sort where sid=?";
			return (String)qr.query(sql, new ScalarHandler(),sid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 定义方法,查询所有的分类的名称,传递字符串的查询条件
	 * 由services层调用
	 */
	public List<Object> querySortNameByParent(String parent){
		try{
		String sql = "SELECT sname FROM gjp_sort where parent=?";
		return qr.query(sql, new ColumnListHandler(),parent);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 定义方法,查询所有的分类的名称
	 * 由services层调用
	 */
	public List<Object> querySortNameAll(){
		try{
			String sql = "SELECT sname FROM gjp_sort ";
			return  qr.query(sql, new ColumnListHandler());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 定义方法，删除分类数据
	 * 方法传递参数，Sort对象
	 * 由services层调用
	 */
	public void deleteSort(Sort sort){
		try{
		//拼写删除SQL语句
		String sql = "DELETE FROM gjp_sort WHERE sid=?";
		Object[] params = {sort.getSid()};
		qr.update(sql,params);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 定义方法，编辑分类数据
	 * 方法传递参数，Sort对象
	 * 由services层调用
	 */
	public void editSort(Sort sort){
		try{
			//拼写修改的SQL语句
			String sql ="UPDATE gjp_sort SET sname=?,parent=?,sdesc=? where sid=?";
			//将SQL语句中的参数组合好
			Object[] params = {sort.getSname(),sort.getParent(),sort.getSdesc(),sort.getSid()};
			qr.update(sql,params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	/*
	 * 定义方法，添加分类数据
	 * 方法需要传递参数，Sort对象
	 * 添加的及时Sort对象中的数据
	 * 没有返回值
	 * 由services层调用
	 */
	public void addSort(Sort sort){
		try{
		//拼写SQL语句
		String sql = "INSERT INTO gjp_sort(sname,parent,sdesc)values(?,?,?)";
		//定义SQL语句中的参数，Object数组
		Object[] params = {sort.getSname(),sort.getParent(),sort.getSdesc()};
		//QueryRunner方法update
		qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 定义方法，查询出所有的分类数据
	 * 返回List集合，泛型Sort类型
	 * querySortAll
	 */
	public List<Sort> querySortAll(){
		try{
			//拼写数据库的SQL语句
			String sql = "SELECT * FROM gjp_sort";
			//QueryRunner方法query查询数据表，结果集的处理方式 BeanListHandler
			List<Sort> list = qr.query(sql, new BeanListHandler<Sort>(Sort.class));
			return list;
		}catch (SQLException e) {
			//手动跑出运行时期异常
			throw new RuntimeException(e);
		}
	}
}
