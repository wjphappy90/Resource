package com.itheima.sh.utils;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoDBUtils {
	// 1.使用connection用来保存Mongo的数据库连接对象
	static Mongo connection = null;
	// 2.使用db接收具体的数据库连接
	static DB db = null;
	// 3.定义coll接收数据表的连接
	static DBCollection coll = null;

	public static DB getDB(String dbName) throws Exception {
		// 创建一个Mongo的数据库连接对象
		connection = new Mongo("127.0.0.1:27017");
		// 通过获取数据库的连接对象connection根据传递的数据库名dbName来连接具体的数据库
		db = connection.getDB(dbName);
		// 将具体的数据库连接返回给调用者
		return db;
	}

	public static DBCollection getCollection(String dbName, String collName) throws Exception {
		// 创建一个Mongo的数据库连接对象
		connection = new Mongo("127.0.0.1:27017");
		// 通过获取数据库的连接对象connection根据传递的数据库名dbName来连接具体的数据库
		db = connection.getDB(dbName);
		coll = db.getCollection(collName);
		// 将具体的数据库连接返回给调用者
		return coll;
	}
}
