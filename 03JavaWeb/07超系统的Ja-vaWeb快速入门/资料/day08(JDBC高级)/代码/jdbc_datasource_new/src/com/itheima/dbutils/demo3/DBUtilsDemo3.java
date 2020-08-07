package com.itheima.dbutils.demo3;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.itheima.dbutils.domain.Account;
import com.itheima.jdbc.utils.JDBCUtils2;

/**
 * ResultSetHandler的实现类
 * 
 * @author jt
 *
 */
public class DBUtilsDemo3 {

	@Test
	/**
	 * ArrayHandler:将一条记录封装到一个Object数组中
	 */
	public void demo1() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Object[] objs = queryRunner.query("select * from account where id = ?", new ArrayHandler(), 1);
		System.out.println(Arrays.toString(objs));
	}

	@Test
	/**
	 * ArrayListHandler:将多条记录封装到一个装有Object数组的List集合中 *
	 * 一条记录封装到Objecct[]数组中，多条记录就是多个Object[]，那么多个Object数组就将其装入List集合中即可。
	 */
	public void demo2() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		List<Object[]> list = queryRunner.query("select * from account", new ArrayListHandler());
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}

	@Test
	/**
	 * BeanHandler：将一条记录封装到一个JavaBean中
	 */
	public void demo3() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Account account = queryRunner.query("select * from account where id = ?",
				new BeanHandler<Account>(Account.class), 2);
		System.out.println(account);
	}

	@Test
	/**
	 * BeanListHandler:将多条记录封装到一个装有JavaBean的List集合中。 
	 * *一条记录就是一个Java的对象（JavaBean），如果多条记录（多个Java的对象），将多个Java对象装到一个List集合中。
	 */
	public void demo4() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		List<Account> list = queryRunner.query("select * from account ", new BeanListHandler<Account>(Account.class));
		for (Account account : list) {
			System.out.println(account);
		}
	}
	
	@Test
	/**
	 * MapHandler：将一条记录封装到一个Map集合中，Map的key是列名，Map的value就是表中列的记录值。
	 */
	public void demo5() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Map<String,Object> map = queryRunner.query("select * from account where id = ?", new MapHandler(), 4);
		System.out.println(map);
	}
	
	@Test
	/**
	 * MapListHandler：将多条记录封装到一个装有Map的List集合中。
	 */
	public void demo6() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		List<Map<String,Object>> list = queryRunner.query("select * from account", new MapListHandler());
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	/**
	 * ColumnListHandler：将某列的值封装到List集合中
	 */
	public void demo7() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		List<Object> list = queryRunner.query("select name,money from account", new ColumnListHandler("name"));
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
	@Test
	/**
	 * ScalarHandler:单值封装
	 */
	public void demo8() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Object obj = queryRunner.query("select count(*) from account", new ScalarHandler());
		System.out.println(obj);
	}
	
	@Test
	/**
	 * KeyedHandler：将一条记录封装到一个Map集合中。将多条记录封装到一个装有Map集合的Map集合中。而且外面的Map的key是可以指定的。
	 */
	public void demo9() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		Map<Object,Map<String,Object>> map = queryRunner.query("select * from account", new KeyedHandler("id"));
		for (Object key : map.keySet()) {
			System.out.println(key+" "+map.get(key));
		}
	}
}
