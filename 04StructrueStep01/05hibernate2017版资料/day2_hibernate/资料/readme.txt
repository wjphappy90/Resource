1、实体类的编写规范
	应该遵循JavaBean的编写规范
	Bean：在软件开发中是指的可重用的组件。
	JavaBean：指的是用java语言编写的可重用组件。在我们的实际项目中：domain,service,dao都可以看成是JavaBean。
	编写规范：
	    类都是public的
	    一般实现序列化接口
	    类成员（字段）都是私有的
	    私有类成员都有公有get/set方法
	    类都有默认无参构造函数
	 细节：
	   数据类型的选择问题：
		基本类型和包装类，选择哪个？
2、hibernate中的对象标识符
3、hibernate的主键生成方式（生成策略）
	native
	。。。。。。
4、hibernate的一级缓存和快照机制
	什么缓存？
		它就是内存中的临时数据。
	为什么使用缓存？
		减少和数据库交互的次数，从而提高查询效率。
	什么样的数据适用于缓存，什么样的数据不适用缓存？
		适用缓存的数据：
			经常查询的，并且不经常修改的。同时数据一旦出现问题，对最终结果影响不大的。
		不适用缓存的数据：
			不管是否经常查询，只要是经常修改的，都可以不用缓存。
			并且如果数据由于使用缓存，产生了异常数据，对最终结果影响很大，则不能使用。
			例如：股市的牌价，银行的汇率，商品的库存等等。
	hibernate的一级缓存：
		它指的是Session对象的缓存，一旦Session对象销毁了，则一级缓存也就消失了。
5、hibernate中的对象状态（三种状态/四种状态）
	瞬时状态（临时状态）
		标志：没有OID，和Session没有关系。
	持久化状态
		标志：有OID，和Session有关系。
		只有持久化状态的对象才会有一级缓存的概念。
	脱管状态（游离状态）
		标志：有OID，和Session没有关系。
	删除状态（了解）：
		标志：有OID，和Session有关系。同时已经调用了删除方法，即将从数据库中把记录删除。但是事务还没有提交，此时的对象状态是删除态。


	明确：学习对象的状态是为了更好的去掌握hibernate操作数据库的方法。

6、hibernate中的事务控制
	解决的问题：让session对象也符合使用原则
	session对象的使用原则：
		一个线程只能有一个Session
7、hibernate中的查询方式
	是查询多条的方式
	hibernate中一共有5种查询方式，讲完今天就应该还剩一种
	OID查询：
		根据id查询一个实体。
		涉及的方法：
			get和load
	SQL查询：
		使用SQL语句查询数据库。
		涉及的方式：
			有两种方式：
				第一种：SQLQuery（一般不怎么用）
				第二种：session的doWork方法，它可以拿到Connection
	HQL查询：
		使用HQL语句查询数据库
	QBC查询：
		使用Criteria对象查询数据库
	对象导航查询：
		此种查询方式，等到明天再说。
8、hibernate中的Query对象(着重)
	它是hibernate中HQL查询方式。
	HQL：hibernate query language
	a、如何获取该对象
		session对象的方法
	b、涉及的对象和方法
		createQuery(String hql);
	c、方法中参数的含义
		SQL：select cust_id from cst_customer
		HQL：select custId from Customer
		HQL语句，是把sql语句的表名换成类名，把字段名换成实体类中的属性名称
	b、常用方法说明
9、hibernate中的Criteria对象
	它是hibernate中QBC查询的方式
	QBC：Query By Criteria
	如何获取该对象
		session.createCriteria(Class clazz);
	涉及对象的方法
		createCriteria(Class clazz);
	参数的含义：
		要查询的实体类字节码