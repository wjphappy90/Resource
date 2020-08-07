package com.itheima.sh.dao;

import com.itheima.sh.domain.Product;
import com.itheima.sh.utils.MongoDBUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ProductDao {
	//查询所有商品信息
	public DBCursor findAllProducts() throws Exception {
		// 根据工具类中的方法获取数据库连接
		DB db = MongoDBUtils.getDB("itcast");
		//根据数据库连接获取对应的集合
		DBCollection coll = db.getCollection("products");
		//使用coll对象调用方法获取数据
		DBCursor cur = coll.find();
		return cur;
	}
	//根据商品编号查询商品信息
	public DBCursor findProductsByPid(int pid) throws Exception {
		// 获取数据库连接
		DB db = MongoDBUtils.getDB("itcast");
		//获取数据库中的表(集合)连接
		DBCollection coll = db.getCollection("products");
		//创建对象 DBObject属于BasicDBObject类父接口
		//BasicDBObject底层是HashMap {"pid":pid}
		DBObject basicDBObject = new BasicDBObject();
		//将pid添加到BasicDBObject中
		basicDBObject.put("pid", pid);
		//将basicDBObject作为参数到数据库中查询商品
		DBCursor cur = coll.find(basicDBObject);
		return cur;
	}
	// 添加商品
	public void addProduct(Product p) throws Exception {
		// 获取集合连接
		DBCollection coll = MongoDBUtils.getCollection("itcast", "products");
		// 创建对象
		DBObject db=new BasicDBObject();
		//添加数据
		db.put("pid", p.getPid());
		db.put("pname", p.getPname());
		db.put("price", p.getPrice());
		//使用集合连接将数据插入到数据库中
		coll.insert(db);
		
	}
	//根据编号删除商品
	public void deleteProductByPid(int pid) throws Exception {
		// 获取集合连接
		DBCollection coll = MongoDBUtils.getCollection("itcast", "products");
		//创建对象
		DBObject dbs=new BasicDBObject();
		//添加数据
		dbs.put("pid", pid);
		//使用集合连接对象coll调用方法进行删除
		coll.remove(dbs);
	}

}
