SSH阶段：16天课
hibernate：4天
struts2：4天
spring：5天
crm：3天
SSH阶段学习的重点：把3个框架能够灵活的应用。先用起来。
----------------------------------------------
hibernate4天安排：
第一天：hibernate基础入门
	能够独立搭建hibernate开发环境
	能够使用hibernate实现CRUD操作
第二天：hibernate的细节说明
	对象标识符
	主键生成方式（生成策略）
	一级缓存和快照机制
	线程绑定操作数据库的Session对象
	hibernate中的查询
	Query对象
	Criteria对象
第三天：hibernate的多表映射和操作
	一对多
	多对多
第四天：JPA概述和使用hibernate中JPA的实现
	JPA:java persistence api (规范)
		  持久化
	使用注解
---------------------------------------------------
1、三层架构
	表现层 web层（MVC是一个表现层的设计模型）
	业务层 service层
	持久层 dao层
2、三大框架和三层架构的关系
	hibernate框架：它是一个持久层框架
	struts2框架：它是一个表现层框架
	spring框架：它是一个综合类框架

	明确：hibernate只能操作数据库（跟数据库打交道）
3、我们已经掌握的持久层技术
	JDBC：它是操作数据库最底层的方式。
	   优势：底层，效率高。
	   弊端：编写代码时，比较繁琐。尤其是封装结果集。

	DBUtils：它是基于JDBC,对JDBC进行了简单的封装。
	    优势：封装结果集的操作变得简单。并且仍然是自己编写sql语句，相对效率并没有太大影响。
		  它用了池的思想管理连接。
	    弊端：要求实体类中属性名称和数据库表的字段名必须一致。
		  要我们记的东西也比较多。

	他们的共同点：都要我们自己写SQL语句。
4、使用JDBC和DBUtils操作产品表时遇到的问题：
	JDBC的问题：
		查询封装结果集时，写吐了。
	DBUtils的问题：
		保存或者更新时，给参数赋值写吐了。
5、你想怎么办？
	就想写一行代码。
	保存：
	   session.save(product);//执行java代码===>在数据库的表中真正添加了一条数据（insert into语句）
	查询：
	   Product product = session.get(id);
6、怎么实现？
	我们有实体类：
		public class Product{
			private Integer pid;
			private String pname;
			private Double price;
		}
	我们有表：
		create table product(
			product_id int primary key auto_increment,
			product_name varchar(50),
			product_price double(7,2)
		);
	用JDBC或者DBUtils操作时，表和实体类的关系就是SQL语句。
	insert into product(product_name,product_price)values(product.getPname(),product.getPrice());
	建立实体类和表之间的关系
		使用配置文件。
		配置文件的种类：
			properties
			xml
		选择properties还是xml呢？
			使用XML。
			因为XML可以描述层级关系
	对应关系的配置文件示例：
		<class name="类名" table="表名">
			<id name="实体类属性名称" column="表中的主键字段名">
			<property name="属性名" column="表中的字段名"/>
		</class>
		insert into  $tablename$($columnname$,$columnname$) values(product.getxxx,product.getxx)
7、ORM
   Object Relational Mapping
   对象关系映射
   就是建立实体类和数据库表的对应关系。
   实现操作实体类对象就相当于操作数据库表
8、hibernate
   它是一个轻量级，企业级，开源的ORM持久层框架。是可以操作数据库的框架。
   框架：它就是一个架构。
   通常情况下，软件工程的持久层解决方案，一个为主一个为辅。两者并存（写SQL语句的和不写SQL语句的）
   轻量级：指的是使用时依赖的资源很少。（目前我们使用的阶段，只依赖log4j，c3p0连接池）
   企业级：指的是在企业级应用中使用的比较多
   开源的：开放源代码。
   ORM的操作方式：建立对象关系映射，实现操作实体类就相当于操作数据库表。
9、CRM：
	CRM：客户关系管理系统
10、搭建hibernate的开发环境（重点内容）
	要求：能够独立搭建
	需求：实现保存一个客户到数据库
11、hibernate的入门案例
12、hibernate的常用对象
	Configuration
	SessionFactory
	Session
	Transaction
   
作业：
 1、实现客户的CRUD操作
 2、参考客户的CRUD，实现联系人的CRUD操作
 3、预习hibernate第二天的内容