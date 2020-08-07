今天内容安排： 
1、文件搜索案例
2、熊猫烧香(修改目录图标)

01JDBC&DBUtils（数据库连接池的介绍）.avi
02JDBC&DBUtils（dbcp数据连接池的使用）.avi
03JDBC&DBUtils（自定义MyDBUtils工具类）.avi



###01JDBC&DBUtils（数据库连接池的介绍）
	* A: 连接池技术
		* a: 连接池技术简介
			* 当多个程序(多个用户)的多个需求时，我们需要创建多个Connect对象，而与数据库创建连接是十分消耗资源的，
				连接池创建了多个连接，当使用连接操作数据时，会分配一个连接，而这个连接也可供其他程序(用户)的数据库操作使用，
				类似线程池。
			* javax.sql包下的 DataSource是线程池接口。可以使用getConnection()方法获取一个连接，如果连接对象Connection是通过连接池获取的，
				当通过Connection对象调用close()方法时，不再是销毁连接对象，而是将连接对象放回到连接池。
				
###02JDBC&DBUtils（dbcp数据连接池的使用）
	* A: dbcp数据连接池的使用
		* a: dbcp连接池介绍
			* DBCP 是 Apache 软件基金组织下的一个优秀的开源连接池实现，使用DBCP数据源，应用程序应在系统中增加如下两个 jar 文件：
				* Commons-dbcp.jar：连接池的实现
				* Commons-pool.jar：连接池实现的依赖库
			* Tomcat 的连接池正是采用该连接池来实现的。该数据库连接池既可以与应用服务器整合使用，也可由应用程序独立使用。
				DBCP 是 Apache 软件基金组织下的开源连接池实现，使用DBCP数据源，应用程序应在系统中增加如下两个 jar 文件：
				* Commons-dbcp.jar：连接池的实现
				* Commons-pool.jar：连接池实现的依赖库
		* b: dbcp连接池编码配置
			* //导包加入classpath
			* // 1.创建连接池对象
			* BasicDataSource ds = new BasicDataSource();
			* // 2.设置相关属性
			* ds.setDriverClassName("com.mysql.jdbc.Driver");
			* ds.setUrl("jdbc:mysql:///day13");
			* ds.setUsername("root");
			* ds.setPassword("abc");
		* c: DBUtils使用连接池
			* 在上边DBUtils的学习过程中，我们使用QueryRunner的空参构造完成，每次请求调用query方法时传入连接对象。
			* 而当有了线程池后，可以调用QueryRunner的带参构造创建对象：
				QueryRunner(DataSource connectionPool);
				这时，在每次访问数据库时，将无需再传入连接对象。因为在每次使用QueryRunner时，都已经通过连接池获取了连接。
	* B: 案例代码
		* a: 创建产生DataSource数据源的类Demo_01BasicDataSource
			/*
			 * 使用数据库的连接池
			 * DBCP连接池
			 *   BasicDataSource 实现 javax.sql.DataSource接口
			 */
			public class Demo_01BasicDataSource {

				public static BasicDataSource getSource(){
					BasicDataSource source = new BasicDataSource();
					//BasicDataSource方法，设置必要参数
					//设置驱动程序
					source.setDriverClassName("com.mysql.jdbc.Driver");
					//设置数据库连接URL
					source.setUrl("jdbc:mysql://localhost:3306/gjp");
					//设置用户名和密码
					source.setUsername("root");
					source.setPassword("123");
					return source;
				}
			}
		* b: 使用QueryRunner测试配置好的数据源对象
			/*
			 * 测试，配置好的数据源对象
			 * BasicDataSource
			 * 使用Demo_01BasicDataSource类中，配置好的对象source
			 * 
			 * QueryRunner(DataSource ds) 
			 */
			public class Demo_02BasicDataSourceTest {
				public static void main(String[] args) throws SQLException {
					//创建QueryRunner对象，构造方法中，传递BasicDataSource类对象
					BasicDataSource source = Demo_01BasicDataSource.getSource();
					QueryRunner qr = new QueryRunner(source);
					
					List<Object[]> list = qr.query("SELECT * FROM GJP_LEDGER", new ArrayListHandler());
					for (Object[] objects : list) {
						for (Object object : objects) {
							System.out.print(object);
						}
						System.out.println();
					}
				}
			}
			
###03JDBC&DBUtils（自定义MyDBUtils工具类）
	* A: 自定义MyDBUtils工具类
		* a: 重构MyJDBCUtils
			* 由于连接池的加入，我们将MyJDBCUtils返回连接的方法重构为返回连接池对象(数据源DataSource子类对象,即DBCP对象)的方法。
		* b: 案例代码
			* JDBCUtils 工具类
				public class JDBCUtils {
					private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
					private static final String URL = "jdbc:mysql://localhost:3306/gjp";
					private static final String USERNAME = "root";
					private static final String PASSWORD = "123";
					
					private static final int MAX_IDLE = 3;
					private static final int MAX_WAIT = 3000;
					private static final int MAX_ACTIVE = 5;
					private static final int INITIAL_SIZE = 10;
					
					private static BasicDataSource dataSource = new BasicDataSource();
					
					static{
						dataSource.setDriverClassName(DRIVER_CLASS_NAME);//驱动类名
						dataSource.setUrl(URL);//连接数据库地址
						dataSource.setUsername(USERNAME);//用户名
						dataSource.setPassword(PASSWORD);//密码
						
						dataSource.setMaxIdle(MAX_IDLE);//连接池最大空闲连接个数
						dataSource.setMaxWait(MAX_WAIT);//连接池最大等待时间
						dataSource.setMaxActive(MAX_ACTIVE);//连接池最大连接个数
						dataSource.setInitialSize(INITIAL_SIZE);//连接池初始化连接个数
					}

					public static DataSource getDataSource(){
						return dataSource;
					}
				}
			* 测试类Demo_02BasicDataSourceTest
				/*
				 * 测试，配置好的数据源对象
				 * BasicDataSource
				 * 使用Demo_01BasicDataSource类中，配置好的对象source
				 * 
				 * QueryRunner(DataSource ds) 
				 */
				public class Demo_02BasicDataSourceTest {
					public static void main(String[] args) throws SQLException {
						//创建QueryRunner对象，构造方法中，传递BasicDataSource类对象
						BasicDataSource source = Demo_01BasicDataSource.getSource();
						QueryRunner qr = new QueryRunner(source);
						
						List<Object[]> list = qr.query("SELECT * FROM GJP_LEDGER", new ArrayListHandler());
						for (Object[] objects : list) {
							for (Object object : objects) {
								System.out.print(object);
							}
							System.out.println();
						}
						System.out.println("=====================");
						DataSource dataSource = JDBCUtils.getDataSource();
						QueryRunner qr2 = new QueryRunner(dataSource);
						List<Object[]> list2 = qr2.query("SELECT * FROM GJP_LEDGER", new ArrayListHandler());
						for (Object[] objects : list2) {
							for (Object object : objects) {
								System.out.print(object);
							}
							System.out.println();
						}
					}
				}		

=======================第一阶段====================================
04管家婆（项目开发目标）.avi
05管家婆（项目演示）.avi
06管家婆（项目中的分层）.avi
07管家婆（项目功能模块介绍）.avi
###04管家婆（项目开发目标）
	* A: 项目开发目标
		* a: 本项目为JAVAEE基础班综合项目，包含了若干个知识点，达到将基础班所学知识综合使用，提高了我们对项目的理解与知识点的运用。
		* b: 掌握View层、Controller层、Service层、Dao层等之间的方法相互调用操作、
		* c: 掌握dbutils操作数据库表完成增删改查
		* d: 掌握事件监听处理
		* e: 通过本项目，了解公司项目开发的流程，充分的掌握项目需求分析、设计与功能的代码实现。提高同学们独立分析需求与功能实现的能力。
		* f: 项目时间
			* 本项目通过5天课程时间，边讲边练的方式完成。
			
###05管家婆（项目演示）
	* A: 项目演示
		* a: 分类管理
			* 增、删、改、查
		* b: 财务管理
			* 增、删、改、查
			
###06管家婆（项目中的分层）
	* A: 项目中的分层(详见day23_source文件夹中的"项目中的分层_1.JPG"图片)
		* a: 怎么分包，每个包的作用是啥，他们之间的关系是啥
		
###07管家婆（项目功能模块介绍）项目各模块功能介绍_2
	* A: 管家婆家庭记账软件(首页)
		* a: 分类管理
			* 显示所有分类
			* 添加分类
			* 编辑分类
			* 删除分类
		* b: 财务管理
			* 多条件组合查询账务
			* 添加账务
			* 编辑账务
			* 删除账务
			* 收入分类占比图，支出分类占比图（饼形图）

=============第二阶段项目介绍=============
08管家婆（技术选型和相关jar包）.avi
09管家婆（创建项目_导入jar包）.avi
10管家婆（创建数据库SQL语句）.avi
11管家婆（项目中创建包导入工具类）.avi
12管家婆（项目中的工具类）.avi

###08管家婆（技术选型和相关jar包）
	* A: 技术选型和相关jar包
		* a: 每个项目都要使用一些已经成熟的技术，它们通常是由一些专业组织或团队所提供的开源免费技术。
			在今后的学习过程中，学员会逐渐对这些专业组织有所了解。
		* b: 本项目中使用的技术如下
			* jfreechart-1.0.9.jar：用来绘制图形的框架，例如：柱状图、饼形图等；
				* jcommon-1.0.12.jar：jfreechart依赖该jar包；
			* apache的commons组件：
			* commons-beanutils-1.8.3.jar：封装并简化了反射；
			* commons-dbutils-1.4.jar：封装并简化了JDBC；
			* commons-dbcp-1.4.jar：apache commons提供的数据库连接池组件，命名为DBCP；
			* commons.pool-1.3.jar：DBCP连接池依赖该jar包；
			* commons-logging-1.1.1.jar：beanutils依赖该jar包；
			* mysql-connector-java-5.1.28-bin.jar：MySQL的JDBC驱动包，用JDBC连接MySQL数据库必须使用该JAR包。

###09管家婆（创建项目_导入jar包）
	* A: 创建项目_导入jar包
		* a: 创建java project 名称为gjp，项目编码改为utf-8
		* b: 在项目跟路径下建立文件夹lib，将相关jar包拷贝到lib目录中，并添加到构建路径(build path)
		* c: 将管家婆图片，拷贝到项目跟路径下
		
###10管家婆（创建数据库SQL语句）
	* A: 数据表创建(详见day23_source文件夹中的"数据库SQL命令.sql"的文件)
		* a: 对一个项目而言，表设计是非常重要的，因为应用程序中所有的操作都是基于数据库表而进行的，
			所以我们第一步就是创建数据库表。
		* b: 项目分层后，每层之间的关系是，上层依赖下层，表现层（view）依赖控制层（controller），
			控制层依赖业务层（service），业务层依赖数据层（dao），而数据层依赖数据库（DB）。
		* c: 管家婆项目的数据库设计很简单，学员只需找到gjp.sql文件，然后执行之即可。
		* d: 创建数据库、创建表、添加数据的sql语句
		--sql语句开始
		CREATE DATABASE gjp;
		USE gjp;

		-- 创建分类表
		CREATE TABLE gjp_sort(
		  sid INT PRIMARY KEY AUTO_INCREMENT, -- 分类ID
		  sname VARCHAR(100), -- 分类名称
		  parent VARCHAR(100), -- 所属父分类
		  sdesc VARCHAR(10000) -- 描述
		);

		-- 创建账务表
		CREATE TABLE gjp_ledger(
		  lid INT PRIMARY KEY AUTO_INCREMENT, -- 账务ID
		  parent VARCHAR(100), -- 所属父分类
		  money DOUBLE, -- 金额
		  sid INT, -- 分类ID
		  account VARCHAR(100), -- 账户
		  createtime DATE, -- 创建时间
		  ldesc VARCHAR(1000) -- 描述	
		 );
		 
		 
		 INSERT INTO 
		gjp_sort(sid,sname,parent,sdesc) 
		VALUES (1,'服装支出','支出','买衣服'),
		(2,'吃饭支出','支出',''),
		(3,'交通支出','支出',''),
		(4,'住房支出','支出',''),
		(5,'工资收入','收入','fda'),
		(6,'股票收入','收入',''),
		(7,'礼金支出','支出',''),
		(8,'其它支出','支出','');


		INSERT INTO 
		 gjp_ledger(lid,parent,money,sid,account,createtime,ldesc) 
		 VALUES (1,'支出',247,2,'交通银行','2016-03-02','家庭聚餐'),
		 (2,'收入',12345,5,'现金','2016-03-15','开工资了'),
		 (3,'支出',1998,1,'现金','2016-04-02','买衣服'),
		 (4,'支出',325,2,'现金','2016-06-18','朋友聚餐'),
		 (10,'收入',8000,6,'工商银行','2016-10-28','股票大涨'),
		 (11,'收入',5000,6,'工商银行','2016-10-28','股票又大涨'),
		 (12,'收入',5000,5,'交通银行','2016-10-28','又开工资了'),
		 (13,'支出',5000,7,'现金','2016-10-28','朋友结婚'),
		 (14,'支出',1560,8,'现金','2016-10-29','丢钱了'),
		 (15,'支出',2300,3,'交通银行','2016-10-29','油价还在涨啊'),
		 (16,'支出',1000,2,'工商银行','2016-10-29','又吃饭'),
		 (17,'收入',1000,5,'现金','2016-10-30','开资'),
		 (18,'支出',2000,3,'现金','2016-10-30','机票好贵'),
		 (19,'收入',5000,5,'现金','2016-10-30','又开资');
		 --sql语句结束
		 
###11管家婆（项目中创建包导入工具类）
	* A: 创建包导入工具类
		* a: 包结构
			* com.itheima.gjp.app
			* com.itheima.gjp.controller
			* com.itheima.gjp.dao
			* com.itheima.gjp.domain
			* com.itheima.gjp.services
			* com.itheima.gjp.tools
			* com.itheima.gjp.view
		* b: 将所有的工具类导入到com.itheima.gjp.tools包中
			* 如果报错，可以修改包名，注意JDBCUtils工具类中的用户名和密码，改成自己的
				* DateChooser.java
				* DateUtils.java
				* GUITools.java
				* JDBCUtils.java
				* JFreeChartUtils.java
				* ListTableModel.java
				
###12管家婆（项目中的工具类）
	* A: 项目中的工具类
		* a: 每个项目都会用到一些工具类，本项目也不例外。我们不会教大家如何实现这些类，而是让大家知道在项目我们如何使用这些工具类。
		* b: 项目中的工具类类介绍
			* DateChooser.java：用来显示日期选择框，属于对GUI的扩展；
			* DateUtils.java：字符串与日期类之间的转换类；
			* GUITools.java：该类可以把窗口居中显示；
			* JFreeChartUtils：用来简化JFreeChart的使用；
			* ListTableModel：用来简化JTable组件的使用；
			* JDBCUtils：用来创建数据库连接池对象；

=====第三阶段项目搭建=============
13管家婆（主窗体界面）.avi
14管家婆（弹出分类管理对话框）.avi
15管家婆（分类管理对话分析）.avi
16管家婆（弹出添加编辑分类对话框）.avi

###13管家婆（主窗体界面）
	* A:  主窗体界面
		* a: 主窗体类：AbstractMainFrame  继承JFrame
			* 将day23_source文件夹下\搭建项目相关资料\页面文件夹中的AbstractMainFrame类拷贝到com.itheima.gjp.view包中
			* 在com.itheima.gjp.controller包中 建立MainFrameContrller类，该类继承AbstractMainFrame类，并需要重写AbstractMainFrame类中的抽象方法
			* 在com.itheima.gjp.app包中建立MainApp类(该类的功能用于启动项目)，并在该类在中添加启动主窗体界面的代码，内容如下：
				/*
				 * 整个项目的起始入口
				 */
				public class MainApp {
					public static void main(String[] args) {
						//开启主窗体，创建他的子类对象
						new MainFrameContrller().setVisible(true);
					}
				}
		* b: 注意
			* 页面代码大家不用自己写，但是要理解代码逻辑，能看的懂，知道调用过程即可
			
###14管家婆（弹出分类管理对话框）
	* A: 弹出分类管理对话框
		* a:将day23_source文件夹下\搭建项目相关资料\页面文件夹中的AbstractSortMngDialog类(继承JDialog)拷贝到com.itheima.gjp.view包中
			* 此时发现报错了，如果报名有问题，直接更改，还有就是该类中使用的分类管理的实体类Sort，现在还没有需要创建，代码如下
				public class Sort {
					//注意生成空参、有参构造、set、get、toString
					 private int sid  ;
					 private String sname ;
					 private String parent ;
					 private String sdesc ;
				}
		* b: 在com.itheima.gjp.controller包中创建SortMngController类(继承AbstractSortMngDialog)
			* 此时发现报错了，因为在创建子类对象时，子类构造方法会默认调用父类构造方法，而父类只有一个有参构造，所以要在子类添加一个有参的构造方法，调用父类的有参构造
				public class SortMngController extends AbstractSortMngDialog {
					public SortMngController(JFrame frame) {
						super(frame);

					}
					//。。。。
				}
			*   因为SortMngController 子类是由主窗体的，分类管理按钮，点击后显示的，所以要在MainFrameContrller类中打开分类管理对话框的方法中创建"分类管理对话框，并显示"
				public class MainFrameContrller extends AbstractMainFrame {
					/*
					 * 重写主窗体类的抽象方法
					 * 打开账务管理对话框
					 */
					@Override
					public void ledgerMng() {
						
					}
					/*
					 * 重写主窗体类的抽象方法
					 * 打开分类管理对话框
					 */
					@Override
					public void sortMng() {
						//创建分类对话框的子类对象
						new SortMngController(this).setVisible(true);
					}
				}

###15管家婆（分类管理对话分析）
	* A: 分类管理对话分析
		* a: AbstractSortMngDialog类
			* 该类为弹出分类管理对话框的类，该类中只是定义了各种组件，组合出分类管理页面
			* 其中有三个按钮"添加"、"编辑"、"删除"，分别在这三个按钮上绑定了方法，但都是抽象方法，具体有子类实现，核心代码：
				public abstract class AbstractSortMngDialog extends JDialog {
					//........
					/**
					 * 
					 * 给组件添加监听器
					 */
					private void addListener() {
						closeBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AbstractSortMngDialog.this.dispose();
							}
						});
						/*
						 * 添加分类按钮的事件监听器
						 */
						addBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								addSort();
							}
						});
						/*
						 * 编辑分类按钮的事件监听器
						 */
						editBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								editSort();
							}
						});
						/*
						 * 删除分类按钮的事件监听器
						 */
						delBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								deleteSort();
							}
						});
						/*
						 * 显示数据的表格，鼠标的双击事件
						 * 调用编辑分类方法
						 */
						sortDataTable.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								if(e.getButton() == 1) {
									if(e.getClickCount() >= 2) {
										editSort();		
									}
								}
							}
						});
					}
					/*
					 * 点击添加分类后调用
					 * 子类重写，运行的是子类重写
					 */
					public abstract void addSort();
					/*
					 * 点击编辑分类后调用
					 */
					public abstract void editSort();
					/*
					 * 点击删除分类后调用
					 */
					public abstract void deleteSort();
				}

###16管家婆（弹出添加编辑分类对话框）
	* A: 弹出添加分类对话框
		* a: 添加分类对话框相关类创建
			* 复制已编写好的GUI分类操作界面类AbstractOperationSortDialog.java到view包中；
			* 在controller控制层，创建类AddSortController.java，继承AbstractOperationSortDialog用来创建添加分类窗口；
		* b: 弹出添加分类对话框
			* 在SortMngController#addSort()方法中，创建添加分类窗口（AddSortController）对象；
			* 通过setVisible（）方法显示主窗口
	* B: 弹出编辑分类对话框
		* a: 编辑分类对话框相关类创建
			* 在controller控制层，创建类EditSortController.java，继承AbstractOperationSortDialog用来创建编辑分类窗口；
		* b: 弹出编辑分类对话框
			* 在SortMngController#editSort()方法中，创建编辑分类窗口（EditSortController）对象；
			* 通过setVisible（）方法显示主窗口

==============第四阶段主页面及分类管理模块环境搭建========
17管家婆（弹出账务管理对话框）.avi
18管家婆（账务管理对话框分析）.avi
19管家婆（弹出添加账务编辑账务对话框）.avi
20管家婆（添加账务编辑账务对话框分析）.avi
21管家婆（弹出收支比重图对话框）.avi
			
###17管家婆（弹出账务管理对话框）
	* A: 账务管理对话框相关类创建
		* a: 复制已编写好的GUI分类管理界面类AbstractLedgerMngDialog.java到view包中；
		* b: 在domain包中，创建实体类 Ledger.java，类中成员变量参照数据库表gjp_ledger的字段，要求名称一致；表格中要体现出分类名称，所以添加一个属性sname(分类名称)
			* 实体类要与数据库和表格对应：
			* 与数据库对应：把实体类对象保存到数据库中，以及把数据库数据查询出来封装到实体类对象中；
			* 与表单对应：把实体类对象显示到表单中，把表单数据封装到实体类对象中；
				public class Ledger {
					//生成空参、有参构造、set、get、toString方法
					private int  lid ;
					private String  parent ;
					private double  money ;
					private int  sid ;
					private String  account ;
					private String  createtime ;
					private String  ldesc ;
				}
		* c: 在controller控制层，创建类LedgerMngController.java，继承AbstractLedgerMngDialog用来创建分类管理窗口;
	* B: 弹出账务管理对话框
		* a: 在MainFrameController#ledgerMng()方法中，创建账务管理窗口（LedgerMngController）对象；
		* b: 通过setVisible（）方法显示主窗口

###18管家婆（账务管理对话框分析）
	* A: 账务管理对话框分析
		* a: 代码能看得懂就可以，不用自己写

###19管家婆（弹出添加账务编辑账务对话框）
	* A: 弹出添加账务对话框
		* a: 添加账务对话框相关类创建
			* 复制已编写好的GUI账务操作界面类AbstractOperationLedgerDialog.java到view包中；
			* 在controller控制层，创建类AddLedgerController.java，继承AbstractOperationLedgerDialog用来创建添加账务窗口；
		* b: 弹出添加账务对话框
			* 在LedgerMngController#addLedger()方法中，创建添加账务窗口（AddLedgerController）对象；
			* 通过setVisible（）方法显示主窗口
	* B: 弹出编辑账务对话框
		* a: 编辑账务对话框相关类创建
			* 在controller控制层，创建类EditLedgerController.java，继承AbstractOperationLedgerDialog用来创建添加账务窗口；
		* b: 弹出编辑账务对话框
			* 在LedgerMngController#editLedger()方法中，创建编辑账务窗口（EditLedgerController）对象；
			* 通过setVisible（）方法显示主窗口		
		
###20管家婆（添加账务编辑账务对话框分析）
	* A: 添加账务编辑账务对话框分析
		* a: 代码能看得懂就可以，不用自己写
###21管家婆（弹出收支比重图对话框）
	* A: 弹出收支比重图对话框
		* a: 收/支比重统计对话框相关类创建
			* 复制已编写好的GUI账务收支比重统计窗口类AbstractShapeDialog.java到view包中；
			* 在controller控制层，创建类PieController.java，继承AbstractShapeDialog用来创建账务收支比重统计窗口
		* b: 弹出收/支比重统计对话框
			* 在LedgerMngController#pie()方法中，创建账务收支比重统计窗口（PieController）对象；
			* 通过setVisible（）方法显示主窗口

=======第五阶段账务管理环境搭建=======
###22复习今天的知识点

	


