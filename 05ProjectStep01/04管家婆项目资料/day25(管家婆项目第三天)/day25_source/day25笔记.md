今天内容安排： 
1、管家婆项目菜单联动的实现
2、管家婆项目账务组合查询的实现

01管家婆（今天项目内容安排）.avi
02管家婆（菜单联动分析）.avi
03管家婆（菜单联动三种情况）.avi

###01管家婆（今天项目内容安排）
	* A: 今天项目内容安排
		* a: 账务管理模块
			* 菜单联动
			* 查询
			* 有时间做个添加
	
###02管家婆（菜单联动分析）
	* A: 菜单联动分析
		* a: 分析
			* 通过查看view层的AbstractLedgerMngDialog类中父分类下拉列表标签为parentBox，分类下拉列表标签为sortBox
			* 而这两个下拉列表标签的内容都是写的死数据，而分类下拉列表框中的数据应该根据父分类列表框的选择，动态的确定分类下拉列表的内容，而不是写上的死数据
###03管家婆（菜单联动三种情况）
	* A: 菜单联动三种情况
		* a: 分析
			* 在AbstractLedgerMngDialog类中的addListener方法里给父分类下拉列表标签绑定了方法parentChange
				/*
				 * 选择分类，父分类下拉菜单事件
				 * 实现联动
				 */
				parentBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						parentChange();
					}
				});
			* 而parentChange方法在AbstractLedgerMngDialog类中是抽象方法，必须由子类LedgerMngController实现
		* b: 在子类LedgerMngController的parentChange方法实现
		* c: 情况分析
				/*
				 * 菜单联动,调用的方法
				 * 收支菜单,选择后,分类菜单,跟随他进行显示
				 * 情况一:
				 *   收支: 请选择
				 *   分类: 请选择
				 *   
				 * 情况二:
				 *   收支: 收入/支出
				 *   分类: 所有的支出和收入
				 *   根据收支选择,去数据库中,查询所有的分类内容
				 * 
				 * 情况三:
				 *   收支: 收入,或者选择支出
				 *   分类: 收支选择的是收入,显示收入,收支选择的是支出,显示支出
				 *   根据收支选择,去数据库中,查询所有的分类内容
				 */
============================第一阶段==============================================
04管家婆（菜单联动情况一实现）.avi
05管家婆（菜单联动第二种情况的controll层和services层功能实现）
06管家婆（菜单联动第二种情况的dao层功能实现）.avi
07管家婆（菜单联动第三种情况controller和services层功能实现）.avi
08管家婆（菜单联动第三种情况dao层功能实现）.avi				
###04管家婆（菜单联动情况一实现）
	* A: 菜单联动情况一实现
		* 案例代码
			* 在子类LedgerMngController的parentChange方法实现
				@Override
				public void parentChange() {
					//获取收支的选择
					String parent = parentBox.getSelectedItem().toString();
					//parent选择的是 -请选择-,分类也是请选择
					if(parent.equals("-请选择-")){
						sortBox.setModel(new DefaultComboBoxModel(new String[]{"-请选择-"}));
					}
				}
				
###05管家婆（菜单联动第二种情况的controll层和services层功能实现）.avi
	* A: 菜单联动第二种情况的controll层和services层功能实现
		* a: 菜单联动第二种情况的controll层
			在子类LedgerMngController的parentChange方法实现
			@Override
			public void parentChange() {
				//获取收支的选择
				String parent = parentBox.getSelectedItem().toString();
				//parent选择的是 -请选择-,分类也是请选择
				if(parent.equals("-请选择-")){
					sortBox.setModel(new DefaultComboBoxModel(new String[]{"-请选择-"}));
				}
				
				//情况二,根据数据库查询,收支: 收入/支出,查询所有的内容
				if(parent.equals("收入/支出")){
					//调用services层方法querySortNameAll()查询所有分类名称
					//获取到一个List.toArray()集合,集合中的数据,填充到下拉菜单中
					//代码下面实现
				}				
			}
		* b: service层功能实现
			在SortService类中添加方法querySortNameAll
			/*
			 * 定义方法,调用dao层SortDao#querySortNameAll()查询所有分类名称
			 * 返回List集合
			 */
			public  List<Object> querySortNameAll(){
				return null;
			}
###06管家婆（菜单联动第二种情况的dao层功能实现）
	* A: 菜单联动第二种情况的dao层功能实现
		* a: dao层实现
			* 在dao层的SortDao类中querySortNameAll方法
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
		* b: service层实现
			* 在service层的SortService类中添加方法querySortNameAll
				/*
				 * 定义方法,调用dao层SortDao#querySortNameAll()查询所有分类名称
				 * 返回List集合
				 */
				public  List<Object> querySortNameAll(){
					return sortDao.querySortNameAll();
				}
		* c: controller层实现
			* 在controller层LedgerMngController类的parentChange方法实现
				@Override
				public void parentChange() {
					//获取收支的选择
					String parent = parentBox.getSelectedItem().toString();
					//parent选择的是 -请选择-,分类也是请选择
					if(parent.equals("-请选择-")){
						sortBox.setModel(new DefaultComboBoxModel(new String[]{"-请选择-"}));
					}
					
					//情况二,根据数据库查询,收支: 收入/支出,查询所有的内容
					if(parent.equals("收入/支出")){
						//调用services层方法querySortNameAll()查询所有分类名称
						//获取到一个List.toArray()集合,集合中的数据,填充到下拉菜单中
						List<Object> list = sortService.querySortNameAll();
						list.add(0, "-请选择-");
						sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
					}
				}
				
###07管家婆（菜单联动第三种情况controller和services层功能实现）
	* A: 菜单联动第三种情况的controll层和services层功能实现
		* a: 菜单联动第三种情况的controll层
			在子类LedgerMngController的parentChange方法实现
			@Override
			public void parentChange() {
				//获取收支的选择
				String parent = parentBox.getSelectedItem().toString();
				//parent选择的是 -请选择-,分类也是请选择
				if(parent.equals("-请选择-")){
					sortBox.setModel(new DefaultComboBoxModel(new String[]{"-请选择-"}));
				}
				
				//情况二,根据数据库查询,收支: 收入/支出,查询所有的内容
				if(parent.equals("收入/支出")){
					//调用services层方法querySortNameAll()查询所有分类名称
					//获取到一个List.toArray()集合,集合中的数据,填充到下拉菜单中
					List<Object> list = sortService.querySortNameAll();
					list.add(0, "-请选择-");
					sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
				}
				//情况三,根据数据库查询,查询分类的具体内容
				if(parent.equals("收入")||parent.equals("支出")){
					//调用services层方法querySortNameByParent(String parent)查询所有分类名称
					//获取到一个List.toArray()集合,集合中的数据,填充到下拉菜单中
					List<Object> list = sortService.querySortNameByParent(parent);
					list.add(0, "-请选择-");
					sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
				}	
			}
		* b: service层功能实现
			在SortService类中添加方法querySortNameByParent
			/*
			 * 定义方法,调用dao成SortDao#querySortNameByParent(String parent)
			 * 查询所有的分类名称,传递String参数,父分类
			 */
			public List<Object> querySortNameByParent(String parent){
				return sortDao.querySortNameByParent(parent);
			}
			
###08管家婆（菜单联动第三种情况dao层功能实现）
	* A: 菜单联动第三种情况的dao层功能实现
		* a: dao层实现
			* 在dao层的SortDao类中querySortNameByParent方法
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
=====================第二阶段===============================================
09管家婆（账务组合查询的功能分析）.avi
10管家婆（账务组合查询的SQL语句分析）.avi
11管家婆（查询条件封装成QueryForm对象）.avi
12管家婆（账务组合查询相关的类和方法实现）.avi			
###09管家婆（账务组合查询的功能分析）
	* A: 账务组合查询的功能分析
		* a: 分析
			* 需要两张表的关联查询
			* 重点内容查询条件、结果集、求和
			* 查询条件中日期为必选条件
			* 通过分析如果通过查询来求和，效率比较低，可以根据查询的结果直接求和
			* 在dao层查询出结果集传递个service层，在service层进行数据处理，求出收入和支出，然后service层封装一个Map集合返给controller层
				/*
				 * 点击查询按钮,实现查询功能
				 * 获取的是services层的查询结果
				 * 结果做成Map集合
				 *   key: 键名   value: 查询数据数据的List集合
				 *   key: 键名  value: 所有收入的总和
				 *   key: 键名  value: 所有支出的总和
				 *   map.put("",数据库结果集List集合)
				 *   map.put("",inMoney)
				 *   map.put("",payMoney)
				*/
		* b: 案例代码
			在service层建立LedgerServices类
			public class LedgerServices {				
				/*
				 * 定义方法,返回值是Map集合
				 * 作用,根据用户的条件,查询数据库(List集合)
				 * 遍历List集合,统计收入和支出的求和计算
				 * 存储到Map集合
				 * 
				 * 调用dao层方法查询结果的List集合
				 */
				
			}
		
###10管家婆（账务组合查询的SQL语句分析）
	* A: 账务组合查询的SQL语句分析
		* a: 演示下面的相关sql语句
			/*根据日期进行查询*/
			/*根据日期进行查询,收支中,选择的是收入/支出*/
			SELECT * FROM gjp_ledger WHERE createtime  BETWEEN '2016-10-01' AND '2016-10-31'

			/*根据日期进行查询,收支中,选择的是收入或者是支出*/
			SELECT * FROM gjp_ledger WHERE createtime  BETWEEN '2016-10-01' AND '2016-10-31'
			AND parent = '收入'

			/*根据日期进行查询,收支中,选择的是收入,分类选择的是工资收入*/
			SELECT * FROM gjp_ledger WHERE createtime  BETWEEN '2016-10-01' AND '2016-10-31'
			AND parent = '收入' AND /*sname = '工资收入'*/ sid = 5

			/*根据日期进行查询,收支中,选择的是收入,分类选择的是工资收入*/
			SELECT * FROM gjp_ledger WHERE createtime  BETWEEN '2016-10-01' AND '2016-10-31'
			AND parent = '收入' AND /*sname = '工资收入'*/ sid = (SELECT sid FROM gjp_sort WHERE sname = '工资收入')
			SELECT DISTINCT sid FROM gjp_sort WHERE sname = '工资收入'
			
###11管家婆（查询条件封装成QueryForm对象）
	* A: 查询条件封装成QueryForm对象
		* a: 分析
			* 通过分析sql语句并不固定，不能写死，根据用户的选择生成出来的
			* 可以将所有的查询条件做成一个对象
			* 在domain中的Ledger类中增加成员变量private String sname;生成相应的set和get，修改构造方法
		* b: 查询条件对象
			* 在domain包中创建一个查询条件对象的类QueryForm
				/*
				 * 将账务的查询条件,封装成对象
				 */
				public class QueryForm {
					private String begin;
					private String end;
					private String parent;
					private String sname;
					public String getBegin() {
						return begin;
					}
					public void setBegin(String begin) {
						this.begin = begin;
					}
					public String getEnd() {
						return end;
					}
					public void setEnd(String end) {
						this.end = end;
					}
					public String getParent() {
						return parent;
					}
					public void setParent(String parent) {
						this.parent = parent;
					}
					public String getSname() {
						return sname;
					}
					public void setSname(String sname) {
						this.sname = sname;
					}
					public QueryForm(){}
					public QueryForm(String begin, String end, String parent, String sname) {
						super();
						this.begin = begin;
						this.end = end;
						this.parent = parent;
						this.sname = sname;
					}
					@Override
					public String toString() {
						return "QueryForm [begin=" + begin + ", end=" + end + ", parent="
								+ parent + ", sname=" + sname + "]";
					}
					
				}
		
###12管家婆（账务组合查询相关的类和方法实现）
	* A: 账务组合查询相关的类和方法实现
		* a: controller层LedgerMngController类中添加queryLedger方法
			/*
			 * 点击查询按钮,实现查询功能
			 * 获取的是services层的查询结果
			 * 结果做成Map集合
			 *   key: 键名   value: 查询数据数据的List集合
			 *   key: 键名  value: 所有收入的总和
			 *   key: 键名  value: 所有支出的总和
			 *   map.put("",数据库结果集List集合)
			 *   map.put("",inMoney)
			 *   map.put("",payMoney)
			 */
			@Override
			public void queryLedger() {
				//用户选择的查询条件,封装到QueryForm对象中
				String begin = beginDateTxt.getText();
				String end = endDateTxt.getText();
				String parent = parentBox.getSelectedItem().toString();
				String sname = sortBox.getSelectedItem().toString();
				QueryForm form = new QueryForm(begin, end, parent, sname);
				//调用Services层方法,queryLedgerByQueryForm
				//获取到Map集合 ,键:ledger 值 List集合,填充在表格中				
			}
		* b: service层创建LedgerServices类并添加方法queryLedgerByQueryForm
			public class LedgerServices {
				/*
				 * 定义方法,返回值是Map集合
				 * 作用,根据用户的条件,查询数据库(List集合)
				 * 遍历List集合,统计收入和支出的求和计算
				 * 存储到Map集合
				 * 
				 * 调用dao层方法查询结果的List集合
				 */
				public Map<String,Object> queryLedgerByQueryForm(QueryForm form){
					return null;
				}
			}
		* c: dao层LedgerDao类中添加queryLedgerByQueryForm方法
			public class LedgerDao {
				/*
				 * 定义方法,实现组合查询功能
				 * 传递QueryForm对象
				 * 返回List<Ledger>集合
				 * 根据QueryForm封装的数据,进行SQL语句的编写
				 */
				public List<Ledger> queryLedgerByQueryForm(QueryForm form){
					return null;
				}				
			}
		* d: 用户在分类中选择的"收入"是字符串，应该查询出该分类对应的id，所以要在dao层的SortDao类中添加如下方法：
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
			}
=============================第三阶段=========================================
13管家婆（账务组合查询dao层功能实现）.avi
14管家婆（账务组合查询services层封装Ledger对象功能实现）.avi
15管家婆（账务组合查询services层封装Map集合功能实现）.avi
16管家婆（账务组合查询controller功能实现）.avi
17管家婆（添加账务功能分析）.avi
###13管家婆（账务组合查询dao层功能实现）
	* A: 账务组合查询dao层功能实现
		* a: dao层LedgerDao类中queryLedgerByQueryForm方法实现
			public class LedgerDao {
				private SortDao sortDao = new SortDao();
				private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
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
				public static void main(String[] args) {
					List<Ledger> list = new LedgerDao().queryLedgerByQueryForm(new QueryForm("2016-01-01", "2016-12-01", "收入", "工资收入"));
					for (Ledger ledger : list) {
						System.out.println(ledger);
					}
				}
			}


###14管家婆（账务组合查询services层封装Ledger对象功能实现）
	* A: 账务组合查询services层封装Ledger对象功能实现
		* a: service层创建LedgerServices类方法queryLedgerByQueryForm实现
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
					for(Ledger ledger : list){
						int sid = ledger.getSid();
						//调用dao层SortDao方法getSnameBySid,传递sid,获取出sname
						String sname = sortDao.getSnameBySid(sid);
						ledger.setSname(sname);
						System.out.println(ledger);
					}					
					return null;
				}
			}

###15管家婆（账务组合查询services层封装Map集合功能实现）
	* A: 账务组合查询services层封装Map集合功能实现
		* a: service层创建LedgerServices类方法queryLedgerByQueryForm实现
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

###16管家婆（账务组合查询controller功能实现）
	* A: 账务组合查询controller功能实现
		* a: controller层创建LedgerMngController类方法queryLedger实现
			/*
			 * 点击查询按钮,实现查询功能
			 * 获取的是services层的查询结果
			 * 结果做成Map集合
			 *   key: 键名   value: 查询数据数据的List集合
			 *   key: 键名  value: 所有收入的总和
			 *   key: 键名  value: 所有支出的总和
			 *   map.put("",数据库结果集List集合)
			 *   map.put("",inMoney)
			 *   map.put("",payMoney)
			 */
			@Override
			public void queryLedger() {
				//用户选择的查询条件,封装到QueryForm对象中
				String begin = beginDateTxt.getText();
				String end = endDateTxt.getText();
				String parent = parentBox.getSelectedItem().toString();
				String sname = sortBox.getSelectedItem().toString();
				QueryForm form = new QueryForm(begin, end, parent, sname);
				//调用Services层方法,queryLedgerByQueryForm
				//获取到Map集合 ,键:ledger 值 List集合,填充在表格中
				Map<String,Object> data = ledgerServices.queryLedgerByQueryForm(form);
				List<Ledger> list =(List<Ledger>) data.get("ledger");
				double in = (double)data.get("in");
				double pay = (double)data.get("pay");
				//将查询数据List填充表格JTable中
				this.setTableModel(list);
				//计算的后求和,填充到Label中
				inMoneyTotalLabel.setText("总收入  "+in+" 元");
				payMoneyTotalLabel.setText("总支出  "+pay+" 元");
			//	payMoneyTotalLabel.setText(new StringBuilder().append("总收入 ").append(in).toString());
			}
			
###17管家婆（添加账务功能分析）
	* A: 添加账务功能分析
		* a: 菜单联动不需要写，可以复制之前的代码，也可以封装成方法
		* b: 添加账务中收/支中只能选择"收入或者支出"，不能都选
		* c: 账户必填
		* d: 金额必须是大于0的数字
		* e: 账务表中是id，但是我们选的是名字，所以需要名字到id的转换
		
###18总结
	* 把今天的知识点总结一遍。
	

===================================第四阶段=========================================

	


