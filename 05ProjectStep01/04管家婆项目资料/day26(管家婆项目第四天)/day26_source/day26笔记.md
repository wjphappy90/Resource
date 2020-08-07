今天内容安排： 
1、管家婆项目添加账务、编辑账务、删除账务的实现
2、管家婆项目收支比重图的实现

01管家婆（添加账务功能分析）.avi
02管家婆（添加账务功能菜单联动）.avi
03管家婆（添加账务功能controller层实现）.avi
04管家婆（添加账务功能services层实现）.avi
05管家婆（添加账务功能dao层实现）.avi

###01管家婆（添加账务功能分析）
	* A: 添加账务功能分析
		* a: 实现账务添加功能
		* b: 实现账务编辑功能
		* c: 实现账务删除功能
		* d: 实现收支比重统计图
		
###02管家婆（添加账务功能菜单联动）
	* A: 添加账务功能菜单联动
		* a: 分析
			* 因为添加账务的二级联动和查询条件时的二级联动基本一样只需要将情况而删除即可
			* 将controller层LedgerMngController类中的parentChange方法中的二级联动代码拷贝到AddLedgerController类中changeParent方法中即可
				@Override
				public void changeParent() {
					// 获取收支的选择
					String parent = parentBox.getSelectedItem().toString();
					// parent选择的是 -请选择-,分类也是请选择
					if (parent.equals("-请选择-")) {
						sortBox.setModel(new DefaultComboBoxModel(new String[] { "-请选择-" }));
					}
					// 情况二,根据数据库查询,查询分类的具体内容
					if (parent.equals("收入") || parent.equals("支出")) {
						// 调用services层方法querySortNameByParent(String parent)查询所有分类名称
						// 获取到一个List.toArray()集合,集合中的数据,填充到下拉菜单中
						List<Object> list = sortService.querySortNameByParent(parent);
						list.add(0, "-请选择-");
						sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
					}

				}
				
###03管家婆（添加账务功能controller层实现）
	* A: 添加账务功能controller层实现 
		* a: controller类中的AddLedgerController类中的confirm方法实现
			/*
			 * 点击添加按钮,实现功能
			 * 验证用户填写数据
			 *   分类
			 *   分类名称
			 *   金额>0, 必须是数字
			 *   账户,必须填写的
			 *   
			 * 用户所有填写的数据,封装成Ledger的对象
			 * 传递给services层,进行添加
			 */
			@Override
			public void confirm() {
				String parent = parentBox.getSelectedItem().toString();
				String sname = sortBox.getSelectedItem().toString();
				String account = accountTxt.getText();
				String createtime = createtimeTxt.getText();
				String sMoney = moneyTxt.getText();
				String ldesc = ldescTxt.getText();
				if(parent.equals("-请选择-")){
					JOptionPane.showMessageDialog(this, "请选择收/支");
					return ;
				}
				if(sname.equals("-请选择-")){
					JOptionPane.showMessageDialog(this, "请选择分类名称");
					return ;
				}
				if(account==null || account.isEmpty()){
					JOptionPane.showMessageDialog(this, "请填写账户");
					return ;
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					if(sdf.parse(createtime).getTime()-new Date().getTime()>0) {
						JOptionPane.showMessageDialog(this, "不能选择当前日期之后的日期");
						return ;
					}			
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
				//获取到的金额,由String,转出double
				double money = 0;
				try{
					money  = Double.parseDouble(sMoney);
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(this, "必须填写数字");
					return ;
				}
				
				if(money<=0){
					JOptionPane.showMessageDialog(this, "金额必须大于0");
					return ;
				}
				//将数据封装成Ledger对象
				//0,数据表主键,假数据   ,sid 是通过sname查询sort表获取,给假的
				
				Ledger ledger = new Ledger(0, parent, money, sid, account, createtime, ldesc, sname);			
			}
			
###04管家婆（添加账务功能services层实现）
	* A: 添加账务功能services层实现
		* a: 在service层的LedgerServices类中添加getSidBySname方法
			/*
			 * 定义方法,调用sortDao方法 getSidBySname,传递sname
			 * 获取sid
			 */
			public int getSidBySname(String sname){
				return  sortDao.getSidBySname(sname);
			}
		* b: 在service层的LedgerServices类中添加addLedger方法
			/*
			 * 定义方法,添加账务
			 * addLedger,传递Ledger对象
			 */
			public void addLedger(Ledger ledger){
				ledgerDao.addLedger(ledger);
			}
		* c: controller类中的AddLedgerController类中的confirm方法实现
			public void confirm() {
				String parent = parentBox.getSelectedItem().toString();
				String sname = sortBox.getSelectedItem().toString();
				String account = accountTxt.getText();
				String createtime = createtimeTxt.getText();
				String sMoney = moneyTxt.getText();
				String ldesc = ldescTxt.getText();
				if(parent.equals("-请选择-")){
					JOptionPane.showMessageDialog(this, "请选择收/支");
					return ;
				}
				if(sname.equals("-请选择-")){
					JOptionPane.showMessageDialog(this, "请选择分类名称");
					return ;
				}
				if(account==null || account.isEmpty()){
					JOptionPane.showMessageDialog(this, "请填写账户");
					return ;
				}		
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					if(sdf.parse(createtime).getTime()-new Date().getTime()>0) {
						JOptionPane.showMessageDialog(this, "不能选择当前日期之后的日期");
						return ;
					}			
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
				//获取到的金额,由String,转出double
				double money = 0;
				try{
					money  = Double.parseDouble(sMoney);
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(this, "必须填写数字");
					return ;
				}
				
				if(money<=0){
					JOptionPane.showMessageDialog(this, "金额必须大于0");
					return ;
				}
				//将数据封装成Ledger对象
				//0,数据表主键,假数据   ,sid 是通过sname查询sort表获取,给假的
				//调用service层方法getSidBySname,获取sid值
				int sid = ledgerService.getSidBySname(sname);
				Ledger ledger = new Ledger(0, parent, money, sid, account, createtime, ldesc, sname);
				ledgerService.addLedger(ledger);
				
				this.dispose();
				JOptionPane.showMessageDialog(this, "添加账务成功");
			
			}

###05管家婆（添加账务功能dao层实现）
	* A: 添加账务功能dao层实现
		* a: 在dao层的LedgerDao类中添加addLedger方法
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
		* b: 在service层的LedgerServices类中添加addLedger方法
			/*
			 * 定义方法,添加账务
			 * addLedger,传递Ledger对象
			 */
			public void addLedger(Ledger ledger){
				ledgerDao.addLedger(ledger);
			}
			
========================第一阶段=================================================

06管家婆（编辑账务的功能分析）.avi
07管家婆（编辑账务controller层功能实现）.avi
08管家婆（编辑账务controller层功能实现_封装Ledger对象）.avi
09管家婆（编辑账务dao层功能实现_封装Ledger对象）.avi
10管家婆（编辑账务services层功能实现）.avi
			
###06管家婆（编辑账务的功能分析）
	* A: 编辑账务的功能分析
		* a: 在列表框中不选择行或者选择空行，点"编辑"，都提示"请选择行"
		* b: 当用户选择行之后，单击"编辑"，需要将所选行的信息填充到编辑对话框中
		* c: 在编辑对话框中修改信息后，单击确定时同样要进行信息验证，验证的规则和前面添加时一样的
		
###07管家婆（编辑账务controller层功能实现）
	* A: 编辑账务controller层功能实现
		* a: 在view层AbstractLedgerMngDialog类中的editBtn按钮绑定了一个方法editLedger()，而该方法是抽象的，需要子类LedgerMngController实现
			/*
			 * 编辑账务按钮事件监听器
			 */
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					editLedger();
				}
			});
			
		* b: 在controller层LedgerMngController类中的editLedger()方法实现
			注意：这里获取用户选择的行数据，然后要弹出编辑对话框EditLedgerController，
				将行数据封装成Ledger对象传递给编辑对话框并显示(在编辑对话框的而构造方法中给其各组件设置值)，
				所以要给编辑对话框的构造方法添加一个参数Ledger
				/*
				 * 点击编辑账务按钮，弹出编辑账务对话框
				 */
				@Override
				public void editLedger() {
					//获取到选择的行
					int row = ledgerDataTable.getSelectedRow();
					if(row<0){
						JOptionPane.showMessageDialog(this, "请选择要编辑的数据");
						return ;
					}
					//调用父类方法getLedgerByTableRow,传递行号,获取到一个Ledger对象
					Ledger ledger = getLedgerByTableRow(row);
					if(ledger==null){
						JOptionPane.showMessageDialog(this, "选择的是空行");
						return ;
					}
					//弹出编辑对话框,传递给Ledger对象,窗体开启的时候,显示出选择的数据
					new EditLedgerController(this,ledger).setVisible(true);
					queryLedger();
				}
		* c: 在controller类中的EditLedgerController类中内容如下：
			注意：其中changeParent方法是实现二级联动的，因为"收/支"按钮和"分类"按钮是在其父类中定义的，
			而且绑定了二级联动的方法changeParent，只是changeParent方法在父类中是抽象方法，由子类EditLedgerController实现
			public class EditLedgerController extends AbstractOperationLedgerDialog {
				private SortService sortService = new SortService();
				private Ledger ledger;
				private LedgerServices ledgerServices = new LedgerServices();
				public EditLedgerController(JDialog dialog, Ledger ledger) {
					super(dialog);
					titleLabel.setText("编辑账务");
					super.setTitle("编辑账务");
					this.ledger=ledger;
					// 编辑对话框中,全数据,都显示
					parentBox.setSelectedItem(ledger.getParent());
					// setSelectedItem,将菜单原有的内容,设置一个默认选项
					// sortBox.setSelectedItem(ledger.getSname());

					// 获取到的分类名称,转字符串数组
					String[] items = { ledger.getSname() };
					// 调用的是菜单的方法setModel,从新设置菜单数据
					sortBox.setModel(new DefaultComboBoxModel(items));

					accountTxt.setText(ledger.getAccount());
					moneyTxt.setText(ledger.getMoney() + "");
					createtimeTxt.setText(ledger.getCreatetime());
					ldescTxt.setText(ledger.getLdesc());
				}

				@Override
				public void changeParent() {
					// 获取收支的选择
					String parent = parentBox.getSelectedItem().toString();
					// parent选择的是 -请选择-,分类也是请选择
					if (parent.equals("-请选择-")) {
						sortBox.setModel(new DefaultComboBoxModel(new String[] { "-请选择-" }));
					}
					// 情况二,根据数据库查询,查询分类的具体内容
					if (parent.equals("收入") || parent.equals("支出")) {
						// 调用services层方法querySortNameByParent(String parent)查询所有分类名称
						// 获取到一个List.toArray()集合,集合中的数据,填充到下拉菜单中
						List<Object> list = sortService.querySortNameByParent(parent);
						list.add(0, "-请选择-");
						sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
					}
				}
				
###08管家婆（编辑账务controller层功能实现_封装Ledger对象）
	* A: 编辑账务controller层功能实现_封装Ledger对象
		* a: 在点击"确认"按钮时，是将编辑分类中用户重新填写的信息替换掉查询列表中用户选定的行所封装成的Ledger对象中的信息，
			而不用创建新的Ledger对象，所以在创建编辑对话框时，需要将Ledger对象提升为成员位置，这样才能在确认方法中使用该Ledger对象
		* b: 用户在编辑分类对话框中所输入的"分类"为字符串类型的sname，但是数据库中存储的是int类型sid，所以要现根据sname查询出对应的sid，
		* c: controller层的EditLedgerController类中的confirm方法实现
			/*
			 * 点击编辑的确定按钮,调用方法
			 * 获取用户选择的数据
			 * 对数据进行验证
			 * 数据封装成Ledgerd对象
			 * 调用serveices层方法
			 */
			@Override
			public void confirm() {
				String parent = parentBox.getSelectedItem().toString();
				String sname = sortBox.getSelectedItem().toString();
				String account = accountTxt.getText();
				String createtime = createtimeTxt.getText();
				String sMoney = moneyTxt.getText();
				String ldesc = ldescTxt.getText();
				if(parent.equals("-请选择-")){
					JOptionPane.showMessageDialog(this, "请选择收/支");
					return ;
				}
				if(sname.equals("-请选择-")){
					JOptionPane.showMessageDialog(this, "请选择分类名称");
					return ;
				}
				if(account==null || account.isEmpty()){
					JOptionPane.showMessageDialog(this, "请填写账户");
					return ;
				}
				
				//获取到的金额,由String,转出double
				double money = 0;
				try{
					money  = Double.parseDouble(sMoney);
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(this, "必须填写数字");
					return ;
				}
				
				if(money<=0){
					JOptionPane.showMessageDialog(this, "金额必须大于0");
					return ;
				}
				int lid = ledger.getLid();
				ledger = new Ledger();
				//将已有的数据,封装到Ledger对象中
				ledger.setAccount(account);
				ledger.setCreatetime(createtime);
				ledger.setLdesc(ldesc);
				ledger.setMoney(money);
				ledger.setParent(parent);
				ledger.setLid(lid);
				
				int sid = ledgerServices.getSidBySname(sname);
				ledger.setSid(sid);
				
				//调用services层方法editLedger
				ledgerServices.editLedger(ledger);
				this.dispose();
				JOptionPane.showMessageDialog(this, "编辑成功");
			}
			
###09管家婆（编辑账务dao层功能实现_封装Ledger对象）
	* A: 编辑账务dao层功能实现_封装Ledger对象
		* a: dao层LedgerDao类中添加方法editLedger
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
			
###10管家婆（编辑账务services层功能实现）
	* A: 编辑账务services层功能实现
		* a: 在service层的LedgerServices类中添加方法editLedger
			/*
			 * 定义方法,编辑账务
			 * editLedger,传递Ledger对象
			 */
			public void editLedger(Ledger ledger){
				ledgerDao.editLedger(ledger);
			}

===================================第二阶段==============================================
11管家婆（删除账务controller层和services层功能实现）.avi
12管家婆（删除账务dao层功能实现）.avi			
###11管家婆（删除账务controller层和services层功能实现）
	* A: 删除账务controller层和services层功能实现
		* a: 判断用户选定的要删除的行是否为空行，是空行或没有选择行，提示"请选择要删除的行"
		* b: 不是空行，直接删除，再弹出"删除成功"提示信息
		* c: 在controller层LedgerMngController类中添加deleteLedger方法
				@Override
				public void deleteLedger() {
					//获取选择的行号
					int row = ledgerDataTable.getSelectedRow();
					if(row<0){
						JOptionPane.showMessageDialog(this, "没有选择数据");
						return ;
					}
					//将选择中的行,封装成Ledger对象
					Ledger ledger = getLedgerByTableRow(row);
					if(ledger==null){
						JOptionPane.showMessageDialog(this, "选择的是空行");
						return ;
					}
					//确认删除的提示对话框
					int result = JOptionPane.showConfirmDialog(this, "是否确认删除吗");
					if(result==JOptionPane.OK_OPTION){
						//调用services层方法 deleteLedger,传递lid值,数据表的主键
						ledgerServices.deleteLedger(ledger.getLid());
						JOptionPane.showMessageDialog(this, "删除成功");
					}
					queryLedger();
				}
		* d: 在service层建立LedgerServices类中添加deleteLedger方法
			/*
			 * 定义方法,删除账务
			 * deleteLedger,传递lid值
			 */
			public void deleteLedger(int lid){
				ledgerDao.deleteLedger(lid);
			}
		
###12管家婆（删除账务dao层功能实现）
	* A: 删除账务dao层功能实现
		* a: 在dao层的LedgerDao类中添加deleteLedger方法
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
			
========================第三阶段===========================================

13管家婆（收支占比图形分析）.avi
14管家婆（JfreeChart工具类说明）.avi
15管家婆（收支比重图路径获取分析）.avi
16管家婆（收支比重图路数据查询SQL语句）.avi			
###13管家婆（收支占比图形分析）
	* A: 收支占比图形分析
		* a: 最上边是表头,而且只查当年的收入，图形中除了收入总收入，还有每个收入项的收入(支出也是有总支出，和每个支出项的支出)
		* b: sql语句
			* select sum(money) from gjp_ledger where parent = '收入';
		* c: 这种图形无法手动绘制，借助第三方类库jfreechart-1.0.9.jar，而jfreechart-1.0.9.jar依赖于jcommon-1.0.12.jar
	
###14管家婆（JfreeChart工具类说明）
	* A: JfreeChart工具类说明
		public class JFreeChartUtils {
			/**
			 * 使用jfreechart生成图片
			 * @param title 标题
			 * @param totalMap 数据（key:分类名称, value：该分类的汇总数据，例如分类名称为"工资收入"，汇总数据为所有工资收入的和）
			 * @param sum 汇总数据和（例如"工资收入汇总 + 股票收入汇总 + ...."）
			 * @param path 生成图片保存路径
			 */
			public static void pie(String title, Map<String,Double> totalMap, double sum, String path) {
				DefaultPieDataset pieDataset = new DefaultPieDataset();
				for(String dataName : totalMap.keySet()) {
					double dataValue = totalMap.get(dataName);
					String bf = String.format("%.2f%%", dataValue / sum * 100);
					dataName = dataName + ":" + dataValue + "元(" + bf + ")";
					pieDataset.setValue(dataName, dataValue);
				}
				JFreeChart chart = ChartFactory.createPieChart3D(title, pieDataset, true, true, false);
				//JFreeChart chart=ChartFactory.createPieChart(title, pieDataset, true, true, false);
				//JFreeChart chart=ChartFactory.createRingChart(title, pieDataset, true, true, false);

				
				try {
					ChartUtilities.saveChartAsJPEG(new File(path), chart, 500, 300);
				} catch(Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

###15管家婆（收支比重图路径获取分析）
	* A: 收支比重图路径获取分析
		* a: 点击"账务管理"中的"收/支比重统计"按钮，打开一个对话框，该对话框就是AbstractShapeDialog
		* b: AbstractShapeDialog类中有个抽象方法public abstract List<String> getImagePaths();
		* c: public abstract List<String> getImagePaths();的作用获取生成的图片路径，该方法由子类实现
		* d: 发现在AbstractShapeDialog类的构造方法中并没有调用initDialog(该方法进行初始化和添加组件)，那谁来调用呢？
			* 由子类ShapeController在其构造方法中调用，而且子类ShapeController要实现父类中的抽象方法getImagePaths()
			/*
			 * 获取生成的图片路径,路径存储到List集合中
			 * 
			 * 问题? 谁生成图片JFreeChartUtils静态方法pie();
			 * 
			 * 调用services层方法,获取需要的数据
			 */
			@Override
			public List<String> getImagePaths() {
				
			}
###16管家婆（收支比重图路数据查询SQL语句）
	* A: 收支比重图路数据查询SQL语句
		* a: 相关sql语句
			* SELECT SUM(money) FROM gjp_ledger WHERE parent = '支出';
			* SELECT SUM(money),sid FROM gjp_ledger WHERE parent = '支出' AND createtime LIKE '2016%' GROUP BY sid;
			
===========================第四阶段======================================


17管家婆（收支比重图路dao层实现）.avi
18管家婆（收支比重图路services层实现）.avi
19管家婆（收支比重图路controller层实现）.avi
20管家婆（收支比重图_收入实现）.avi
21管家婆（项目中的遗留问题）.avi
###17管家婆（收支比重图路dao层实现）
	* A: 收支比重图路dao层实现
		* a: 在dao层的LedgerDao类中添加getTotalMoney方法
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
		* b: 在dao层的LedgerDao类中添加querySumMoneyBySort方法
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

###18管家婆（收支比重图路services层实现）
	* A: 收支比重图路services层实现
		* a: 在service层建立LedgerServices类中添加queryTotalMoneyByParent方法
			/*
			 * queryTotalMoneyByParent
			 * 调用dao层方法queryTotalMoneyByParent,获取收入或者支出的所有金额的总和
			 */
			public Double queryTotalMoneyByParent(String parent){
				return ledgerDao.getTotalMoney(parent);
			}
		* b: 在service层建立LedgerServices类中添加querySumMoneyBySort方法
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
			
###19管家婆（收支比重图路controller层实现）
	* A: 收支比重图路controller层实现
		* a: 实现支出图
			* 在controller层ShapeController类中getImagePaths方法
				/*
				 * 获取生成的图片路径,路径存储到List集合中
				 * 
				 * 问题? 谁生成图片JFreeChartUtils静态方法pie();
				 * 
				 * 调用services层方法,获取需要的数据
				 */
				@Override
				public List<String> getImagePaths() {
					List<String> listPath = new ArrayList<String>();

					// 调用services方法queryTotalMoneyByParent,获取所有支出或者收入的总金额
					Double money = ledgerServices.queryTotalMoneyByParent("支出");
					// 调用services方法querySumMoneyBySort,获取支出或者收入中的,每一项的总金额 工资,股票收入
					Map<String, Double> map = ledgerServices.querySumMoneyBySort("支出");

					// 调用JFreeChartUtils工具类中的方法pie生成图片
					String title = "支出 占比图(" + money + ") (" + DateUtils.getYear() + "年)";
					
					JFreeChartUtils.pie(title, map, money, "pay.jpg");

					listPath.add("pay.jpg");
					
					return listPath;
				}

###20管家婆（收支比重图_收入实现）
	* A: 收支比重图_收入实现
		* a: 收入实现
			* 在controller层ShapeController类中getImagePaths方法
				/*
				 * 获取生成的图片路径,路径存储到List集合中
				 * 
				 * 问题? 谁生成图片JFreeChartUtils静态方法pie();
				 * 
				 * 调用services层方法,获取需要的数据
				 */
				@Override
				public List<String> getImagePaths() {
					List<String> listPath = new ArrayList<String>();

					// 调用services方法queryTotalMoneyByParent,获取所有支出或者收入的总金额
					Double moneyPay = ledgerServices.queryTotalMoneyByParent("支出");
					// 调用services方法querySumMoneyBySort,获取支出或者收入中的,每一项的总金额 工资,股票收入
					Map<String, Double> mapPay = ledgerServices.querySumMoneyBySort("支出");

					// 调用JFreeChartUtils工具类中的方法pie生成图片
					String title = "支出 占比图(" + moneyPay + ") (" + DateUtils.getYear() + "年)";
					String pathPay="pay.jpg";
					JFreeChartUtils.pie(title, mapPay, moneyPay, pathPay);

					listPath.add(pathPay);

					// 调用services方法queryTotalMoneyByParent,获取所有支出或者收入的总金额
					Double moneyIn = ledgerServices.queryTotalMoneyByParent("收入");
					// 调用services方法querySumMoneyBySort,获取支出或者收入中的,每一项的总金额 工资,股票收入
					Map<String, Double> mapIn = ledgerServices.querySumMoneyBySort("收入");

					// 调用JFreeChartUtils工具类中的方法pie生成图片
					String titleIn = "收入 占比图(" + moneyIn + ") (" + DateUtils.getYear() + "年)";
					String pathIn="in.jpg";
					JFreeChartUtils.pie(titleIn, mapIn, moneyIn, pathIn);

					listPath.add(pathIn);
					return listPath;
				}

###21管家婆（项目中的遗留问题）
	* A: 
		* a: 代码的冗余问题，过多的重复性代码
		* b: 关于删除分类的问题
			* 删除一个分类名称时，对应的账务表中的数据也应该删除掉
		* c: 分页显示
			依赖sql语句实现
				SELECT * FROM gjp_ledger LIMIT 0,3
				0：表示从几开始，3：表示查询几个
				3：对应在显示界面中，每页显示多少条数据
			总页数怎么算？
			先算出总记录数count，然后总页数=Math.ceil(count/3);
			计算总页数的sql语句：
				SELECT COUNT(*) FROM gjp_ledger
			0的计算方式：（当前页-1） * 每页显示的条数
			
###22总结
	* 把今天的知识点总结一遍。
	


	


