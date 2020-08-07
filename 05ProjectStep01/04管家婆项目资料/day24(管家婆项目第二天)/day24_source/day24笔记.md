01管家婆（查询分类数据功能分析）.avi
02管家婆（查询分类数据dao层功能实现）.avi
03管家婆（查询分类数据services层功能实现）.avi
04管家婆（查询分类数据controller层功能实现）.avi

###01管家婆（查询分类数据功能分析）
	* A: 查询分类数据功能分析
		* a: 分析
			* 现在显示的分类管理界面的表格中没有数据，而我们现在要实现的功能是让分类管理这个对话框弹出时就显示出所有分类信息。
			* 为了完成这一功能，我们需要在SortMngController类的构造器中获取所有分类数据，然后再显示到表格中
		* b: 具体步骤
			* (1): SortMngController()构造器：
				* 通过SortService#querySortAll()方法得到所有分类对象，即List<Sort>类型；
				* 把得到的List<Sort>设置到表格中，需要使用SortMngController类的setTableModel(List<Sort>)方法完成，这个方法是在SortMngController的父类（AbstractSortMngDialog）类中定义的，至于这个方法内部如何完成的，我们这里不做讨论，在这里不对GUI相关的功能做讨论。
			* (2): SortService#querySortAll()：调用SortDao#querySortAll()方法；
			* (3): SortDao#querySortAll()：使用dbutils工具访问数据库。
			
###02管家婆（查询分类数据dao层功能实现）
	* A: 查询分类数据dao层功能实现
		* a: 案例代码
			在com.itheima.gjp.dao包中编写DAO数据层SortDao#querySortAll()
				/*
				 * 访问数据库的类
				 * SortDao类，负责分类功能
				 */
				public class SortDao {
					//类的成员位置，定义QueryRunner对象，所有的方法，都可以直接使用
					private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
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

###03管家婆（查询分类数据services层功能实现）
	* A: 查询分类数据services层功能实现
		* a: 案例代码
			在com.itheima.gjp.service包中编写Service业务层SortService#querySortAll()
				/**
				 * 
				 * @author apple
				 * 分类功能的业务层
				 * 
				 * 分类的控制层controller调用services功能
				 * services调用dao层功能
				 */
				public class SortService {
					//创建dao层,SortDao类的对象
					private SortDao sortDao = new SortDao();
					
					/*
					 * 定义方法，调用dao层SortDao#addSort()添加分类
					 * 传递Sort对象
					 * services层方法中的Sort对象，是contorller传递的
					 */
					public void addSort(Sort sort){
						sortDao.addSort(sort);
					}
					
					/*
					 * 定义方法，调用dao层 SortDao#querySortAll获取所有的分类的数据
					 * 返回的是List集合，存储Sort对象
					 */
					public List<Sort> querySortAll(){
						return sortDao.querySortAll();
					}
				}
			
###04管家婆（查询分类数据controller层功能实现）
	* A: 查询分类数据controller层功能实现
		* a: 案例代码
			在com.itheima.gjp.controller包中编写Controller控制层SortMngController()构造器
				/*
				 * 分类管理对话框的子类
				 * 实现分类管理的功能
				 * 显示分类管理界面，new这个子类
				 */
				public class SortMngController extends AbstractSortMngDialog {
					
					//成员位置，创建出services层SortService类的对象
					private SortService sortService = new SortService();
					
					public SortMngController(JFrame frame) {
						super(frame);
					   //向表格中，填充分类数据，在构造方法中实现
						//setTableModel方法，传递List<Sort>集合，向表格中填充数据
						/*
						 * 实现步骤
						 * 1. 调用serives层 中方法，获取出List集合
						 * 2. services层调用dao层，获取出List集合
						 * 3. dao层，查询数据库，数据表中的结果集变成List集合，返回
						 * 4. 调用父类方法setTableModel，传递List集合
						 * 5. 抽取一个方法，调用即可
						 */
						List<Sort> list = sortService.querySortAll();
						setTableModel(list);
						
					}
					//。。。。。其它代码省略
				}

==============================第一阶段============================================
05管家婆（添加分类功能分析）.avi
06管家婆（添加分类功能数据验证）.avi
07管家婆（添加分类功能数据封装Sort对象）.avi
08管家婆（添加分类功能dao层实现）.avi
09管家婆（添加分类功能services层实现）.avi
10管家婆（添加分类功能controller层实现）.avi

###05管家婆（添加分类功能分析）
	* A: 添加分类功能分析
		* a: 分析
			* 通过分析发现，单击"添加按钮"后弹出对话框，输入相关的分类信息，单击"确定按钮"，
				实际上市调用AddSortController类的confirm方法，该方法应该完成以下操作
				1. 数据验证
					 *  验证分类选项
					 *  验证分类名称
					 *  数据不符合要求，提示对话框，从新输入
				2. 将获取到的数据，封装成Sort对象
					 *  lid成员，不需要设置值
				3. 将Sort对象传递给services层处理
				4. services获取Sort对后，对象传递给dao层
				5. dao层中，将Sort对象中的数据写入到数据表中 insert
				6. 提示用户添加成功
				7. 从新加载分类功能 -- SortMngController这个对话框的addSort方法中实现
				
###06管家婆（添加分类功能数据验证）
	* A: 添加分类功能数据验证 
		* a: 案例代码
			* com.itheima.gjp.controller包中的AddSortController类的confirm方法内容如下：
				/*
				 * 添加分类对话框的控制器
				 */
				public class AddSortController extends AbstractOperationSortDialog {

					public AddSortController(JDialog dialog) {
						super(dialog);
						titleLabel.setText("添加分类");
						super.setTitle("添加分类");
					}
					
					@Override
					public void confirm() {
						//对添加功能的数据，进行验证
						//获取分类下拉菜单，用户选择的值
						//getSelectedItem获取下拉菜单，中选择的内容
						String parent = parentBox.getSelectedItem().toString();
						//获取分类名称
						String sname = snameTxt.getText().trim();
						//获取分类的秒睡
						String sdesc = sdescArea.getText();
						//验证用户选择的下拉菜单
						//选择的内容，不等于  =请选择= 就可以
						if(parent.equals("=请选择=")){
							//弹出对话框，选择错误
							JOptionPane.showMessageDialog(this, "请选择分类");
							//"错误提示", JOptionPane.ERROR_MESSAGE
							return ;
						}
						//验证分类名称，不是空即可
						if(sname == null  ||sname.equals("")){
							JOptionPane.showMessageDialog(this, "请填写分类名称");
							return ;
						}						
					}
				}

###07管家婆（添加分类功能数据封装Sort对象）
	* A: 添加分类功能数据封装Sort对象
		* a: 案例代码
			/*
			 * 添加分类对话框的控制器
			 */
			public class AddSortController extends AbstractOperationSortDialog {

				public AddSortController(JDialog dialog) {
					super(dialog);
					titleLabel.setText("添加分类");
					super.setTitle("添加分类");
				}
				@Override
				public void confirm() {
					//对添加功能的数据，进行验证
					//获取分类下拉菜单，用户选择的值
					//getSelectedItem获取下拉菜单，中选择的内容
					String parent = parentBox.getSelectedItem().toString();
					//获取分类名称
					String sname = snameTxt.getText().trim();
					//获取分类的秒睡
					String sdesc = sdescArea.getText();
					//验证用户选择的下拉菜单
					//选择的内容，不等于  =请选择= 就可以
					if(parent.equals("=请选择=")){
						//弹出对话框，选择错误
						JOptionPane.showMessageDialog(this, "请选择分类");
						//"错误提示", JOptionPane.ERROR_MESSAGE
						return ;
					}
					//验证分类名称，不是空即可
					if(sname == null  ||sname.equals("")){
						JOptionPane.showMessageDialog(this, "请填写分类名称");
						return ;
					}
					
					//获取到数据封装成Sort类对象
					Sort sort = new Sort(0, sname, parent, sdesc);
					/*Sort sort = new Sort();
					sort.setParent(parent);
					sort.setSname(sname);
					sort.setSdesc(sdesc);*/
					//调用service层的SortService方法addSort()传递Sort对象
					//创建service层的SortService类的对象									
				}
			}

###08管家婆（添加分类功能dao层实现）
	* A: 添加分类功能dao层实现
		* a: 案例代码
			* 在com.itheima.gjp.dao包中编写DAO数据层SortDao#addSort()
				/*
				 * 访问数据库的类
				 * SortDao类，负责分类功能
				 */
				public class SortDao {
					//类的成员位置，定义QueryRunner对象，所有的方法，都可以直接使用
					private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
					
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
					//查询所有的方法省略了。。。。					
				}

###09管家婆（添加分类功能services层实现）
	* A: 添加分类功能services层实现
		* a: 案例代码
			* 在com.itheima.gjp.service包中编写Service业务层SortService#addSort()
				/**
				 * 
				 * @author apple
				 * 分类功能的业务层
				 * 
				 * 分类的控制层controller调用services功能
				 * services调用dao层功能
				 */
				public class SortService {
					//创建dao层,SortDao类的对象
					private SortDao sortDao = new SortDao();
					
					/*
					 * 定义方法，调用dao层SortDao#addSort()添加分类
					 * 传递Sort对象
					 * services层方法中的Sort对象，是contorller传递的
					 */
					public void addSort(Sort sort){
						sortDao.addSort(sort);
					}
				  //查询所有的方法省略了。。。。。
				}

###10管家婆（添加分类功能constroller层实现）
	* A: 添加分类功能constroller层实现
		* a: 案例代码
			* 在com.itheima.gjp.controller包中编写Controller控制层AddSortController
				/*
				 * 添加分类对话框的控制器
				 */
				public class AddSortController extends AbstractOperationSortDialog {

					public AddSortController(JDialog dialog) {
						super(dialog);
						titleLabel.setText("添加分类");
						super.setTitle("添加分类");
					}
					/*
					 * 添加分类的确定按钮
					 * 实现步骤：
					 *   1. 数据验证
					 *     验证分类选项
					 *     验证分类名称
					 *     数据不符合要求，提示对话框，从新输入
					 *   2. 将获取到的数据，封装成Sort对象
					 *      lid成员，不需要设置值
					 *   3. 将Sort对象传递给services层处理
					 *   4. services获取Sort对后，对象传递给dao层
					 *   5. dao层中，将Sort对象中的数据写入到数据表中 insert
					 *   6. 提示用户添加成功
					 *   7. 从新加载分类功能 -- SortMngController这个对话框的addSort方法中实现
					 */
					@Override
					public void confirm() {
						//对添加功能的数据，进行验证
						//获取分类下拉菜单，用户选择的值
						//getSelectedItem获取下拉菜单，中选择的内容
						String parent = parentBox.getSelectedItem().toString();
						//获取分类名称
						String sname = snameTxt.getText().trim();
						//获取分类的秒睡
						String sdesc = sdescArea.getText();
						//验证用户选择的下拉菜单
						//选择的内容，不等于  =请选择= 就可以
						if(parent.equals("=请选择=")){
							//弹出对话框，选择错误
							JOptionPane.showMessageDialog(this, "请选择分类");
							//"错误提示", JOptionPane.ERROR_MESSAGE
							return ;
						}
						//验证分类名称，不是空即可
						if(sname == null  ||sname.equals("")){
							JOptionPane.showMessageDialog(this, "请填写分类名称");
							return ;
						}
						
						//获取到数据封装成Sort类对象
						Sort sort = new Sort(0, sname, parent, sdesc);
						/*Sort sort = new Sort();
						sort.setParent(parent);
						sort.setSname(sname);
						sort.setSdesc(sdesc);*/
						//调用service层的SortService方法addSort()传递Sort对象
						//创建service层的SortService类的对象
						SortService sortService = new SortService();
						//调用方法addSort传递封装好的Sort对象
						sortService.addSort(sort);
						
						//new SortService().addSort(sort);
						//提示用户，添加分类成功
						JOptionPane.showMessageDialog(this, "添加分类成功", "操作成功", JOptionPane.PLAIN_MESSAGE);
						
						//关闭自己的对话框
						this.dispose();
						
					}

				}
		* 添加数据后要刷新列表，显示新添加的数据，改写Controller层的SortMngController类
			/*
			 * 分类管理对话框的子类
			 * 实现分类管理的功能
			 * 显示分类管理界面，new这个子类
			 */
			public class SortMngController extends AbstractSortMngDialog {
				
				//成员位置，创建出services层SortService类的对象
				private SortService sortService = new SortService();
				
				public SortMngController(JFrame frame) {
					super(frame);
				   //向表格中，填充分类数据，在构造方法中实现
					//setTableModel方法，传递List<Sort>集合，向表格中填充数据
					/*
					 * 实现步骤
					 * 1. 调用serives层 中方法，获取出List集合
					 * 2. services层调用dao层，获取出List集合
					 * 3. dao层，查询数据库，数据表中的结果集变成List集合，返回
					 * 4. 调用父类方法setTableModel，传递List集合
					 * 5. 抽取一个方法，调用即可
					 */
					refresh();
					
				}
				/*
				 * 添加分类按钮，点击后调用的方法
				 * 开启添加分类的对话框
				 */
				@Override
				public void addSort() {
					new AddSortController(this).setVisible(true);
					refresh();

				}
				/*
				 * 编辑分类按钮，点击后调用的方法
				 * 开启编辑分类的对话框
				 */
				@Override
				public void editSort() {
					new EditSortController(this).setVisible(true);

				}

				@Override
				public void deleteSort() {
				}
				//刷新显示分类数据
				private void refresh(){
					List<Sort> list = sortService.querySortAll();
					setTableModel(list);
				}

			}
====================第二阶段============
11管家婆（编辑分类功能分析）.avi
12管家婆（编辑分类controller功能实现）.avi
13管家婆（编辑分类dao层功能实现）.avi
14管家婆（编辑分类services层功能实现）.avi

###11管家婆（编辑分类功能分析）
	* A: 编辑分类功能分析
		* a: 分析
			* 当点击"分类管理"功能后，如果用户没有在显示列表中选择记录(或者选择的是空记录)，单击"编辑按钮"，就不会显示对话框
		* b: 详细过程
			* 编辑分类按钮，点击后调用的方法
			* 开启编辑分类的对话框
			* 对用户选择的分类数据进行控制
			* 不选择
			* 选择空行
			* sortDataTable 表格中的方法 getSelectRow（）获取选择的行  ，返回-1,没有选择
			* 选择的是空行：
			* getSortByTableRow() 父类方法，传递选中的行号，返回这一行的数据，封装到Sort对象
			* 如果用户选择有效行，封装好的Sort对象，传递给EditSortController对话框
			* 后面的实现和新增几乎一致
		* c: 案例代码(SortMngController类的editSort()内容)
				@Override
				public void editSort() {
					//获取用户选中的行号
					int row = sortDataTable.getSelectedRow();					
					//getSortByTableRow，传递行号，返回这一行的数据，封装Sort对象
					Sort sort = getSortByTableRow(row);
					System.out.println(sort);
					
					//Sort对象，传递到，编辑分类的对话框中
					new EditSortController(this,sort).setVisible(true);
					
				}
		
###12管家婆（编辑分类controller功能实现）
	* A: 编辑分类controller功能实现
		* a: 当用户在列表中选定了费空行，单击"编辑分类"时，要显示编辑分类对话框，而且要显示分类信息，怎么显示呢？
			* 在创建分类对话框时，将查询出来的分类对象，传递给创建分类对话框的构造方法
			* 如果用户修改完信息后，点击"确认修改"，会调用dao层的update方法，而update方法要求要有where id = ?,那么id从哪来，
				在sort对象里，所以要在编辑分类对话框的类里定义一个成员变量private Sort sort;并在该类的构造方法里为其赋值
		* b: 案例代码
			* (SortMngController类的editSort()内容)
				@Override
				public void editSort() {
					//获取用户选中的行号
					int row = sortDataTable.getSelectedRow();
					
					if(row<0){
						JOptionPane.showMessageDialog(this, "请选择数据");
						return ;
					}
					//getSortByTableRow，传递行号，返回这一行的数据，封装Sort对象
					Sort sort = getSortByTableRow(row);
					if(sort == null){
						JOptionPane.showMessageDialog(this, "选择的是空行");
						return ;
					}
					
					//Sort对象，传递到，编辑分类的对话框中
					new EditSortController(this,sort).setVisible(true);
					refresh();

				}
			* 编辑分类对话框EditSortController类的内容
				/*
				 * 编辑分类的对话框
				 */
				public class EditSortController extends AbstractOperationSortDialog {
					private Sort sort;
					public EditSortController(JDialog dialog,Sort sort) {
						super(dialog);
						titleLabel.setText("编辑分类");
						super.setTitle("编辑分类");
						
						this.sort =sort;
						//获取Sort对象中的数据，填充到对话框中
						//Sort对象中，封装的分类，填充到下拉菜单中
						//setSelectedItem,将菜单中，已有的项目，作为默认项目出现
						parentBox.setSelectedItem(sort.getParent());
						
						snameTxt.setText(sort.getSname());
						
						sdescArea.setText(sort.getSdesc());
					}
					/*
					 * 点击确认编辑按钮，调用方法
					 */
					@Override
					public void confirm() {
						//获取分类下拉菜单内容
						String parent = parentBox.getSelectedItem().toString();
						//获取分类名称
						String sname = snameTxt.getText().trim();
						//获取分类描述
						String sdesc = sdescArea.getText();
						//此处数据是否符合要求，和添加分类的验证方式相同
						if(parent.equals("=请选择=")){
							JOptionPane.showMessageDialog(this, "请选择分类");
							return ;
						}
						
						if(sname==null || sname.isEmpty()){
							JOptionPane.showMessageDialog(this, "请输入分类名称");
							return ;
						}
						//获取到的数据封装成Sort对象
						sort.setParent(parent);
						sort.setSdesc(sdesc);
						sort.setSname(sname);
						//调用services层内容，传递Sort对象，进行修改
						
					}

				}

###13管家婆（编辑分类dao层功能实现）
	* A: 编辑分类dao层功能实现
		* a: 在com.itheima.gjp.dao包中编写DAO数据层SortDao#editSort()
				/*
				 * 访问数据库的类
				 * SortDao类，负责分类功能
				 */
				public class SortDao {
					//类的成员位置，定义QueryRunner对象，所有的方法，都可以直接使用
					private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());					
					
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
					//其它代码省略。。。。
				}

###14管家婆（编辑分类services层功能实现）
	* A: 编辑分类services层功能实现
		* a: 案例代码
			* 在com.itheima.gjp.service包中编写Service业务层SortService#editSort()
				/**
				 * 
				 * @author apple
				 * 分类功能的业务层
				 * 
				 * 分类的控制层controller调用services功能
				 * services调用dao层功能
				 */
				public class SortService {
					//创建dao层,SortDao类的对象
					private SortDao sortDao = new SortDao();					
					
					/*
					 * 定义方法，调用dao层SortDao#editSort()实现编辑分类
					 * 传递Sort对象
					 * 是contorller调用services层传递Sort
					 */
					public void editSort(Sort sort){
						sortDao.editSort(sort);
					}
					//其它代码省略。。。。					
				}
			* 在com.itheima.gjp.controller包中编写Controller层EditSortController#confirm()
				/*
				 * 编辑分类的对话框
				 */
				public class EditSortController extends AbstractOperationSortDialog {
					private Sort sort;
					public EditSortController(JDialog dialog,Sort sort) {
						super(dialog);
						titleLabel.setText("编辑分类");
						super.setTitle("编辑分类");
						
						this.sort =sort;
						//获取Sort对象中的数据，填充到对话框中
						//Sort对象中，封装的分类，填充到下拉菜单中
						//setSelectedItem,将菜单中，已有的项目，作为默认项目出现
						parentBox.setSelectedItem(sort.getParent());
						
						snameTxt.setText(sort.getSname());
						
						sdescArea.setText(sort.getSdesc());
					}
					/*
					 * 点击确认编辑按钮，调用方法
					 */
					@Override
					public void confirm() {
						//获取分类下拉菜单内容
						String parent = parentBox.getSelectedItem().toString();
						//获取分类名称
						String sname = snameTxt.getText().trim();
						//获取分类描述
						String sdesc = sdescArea.getText();
						//此处数据是否符合要求，和添加分类的验证方式相同
						if(parent.equals("=请选择=")){
							JOptionPane.showMessageDialog(this, "请选择分类");
							return ;
						}
						
						if(sname==null || sname.isEmpty()){
							JOptionPane.showMessageDialog(this, "请输入分类名称");
							return ;
						}
						//获取到的数据封装成Sort对象
						sort.setParent(parent);
						sort.setSdesc(sdesc);
						sort.setSname(sname);
						//调用services层内容，传递Sort对象，进行修改
						SortService sortService = new SortService();
						sortService.editSort(sort);
						this.dispose();
						JOptionPane.showMessageDialog(this, "编辑成功");
					}

				}

===================第三阶段===============
15管家婆（删除分类功能实现）.avi
16管家婆（删除分类dao层，services层功能实现）.avi
17管家婆（删除分类controller层功能实现）.avi

###15管家婆（删除分类功能实现）
	* A: 删除分类功能实现
		* a: 分析
			* 获取选择哪一行
			* 提示对话框，询问用户，是否真的要删除吗
			* 调用services层方法deleteSort，传递Sort对象
			* 刷新数据
			
###16管家婆（删除分类dao层，services层功能实现）
	* A: 删除分类dao层
		* a: 案例代码
			* 在com.itheima.gjp.dao包中编写DAO数据层SortDao#deleteSort()
				/*
				 * 访问数据库的类
				 * SortDao类，负责分类功能
				 */
				public class SortDao {
					//类的成员位置，定义QueryRunner对象，所有的方法，都可以直接使用
					private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
					
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
					//其它代码省略。。。。
					
				}
	* B: 删除分类service层
		* 在com.itheima.gjp.service包中编写service业务层SortService#deleteSort()
			/**
			 * 
			 * @author apple
			 * 分类功能的业务层
			 * 
			 * 分类的控制层controller调用services功能
			 * services调用dao层功能
			 */
			public class SortService {
				//创建dao层,SortDao类的对象
				private SortDao sortDao = new SortDao();
				
				/*
				 * 定义方法，调用dao层SortDao#deleteSort()实现删除分类
				 * 传递Sort对象
				 * 是contorller调用services层传递Sort
				 */
				public void deleteSort(Sort sort){
					sortDao.deleteSort(sort);
				}
				//其它代码省略。。。。
			}

		
###17管家婆（删除分类controller层功能实现）
	* A: 删除分类controller层功能实现
		* a: 案例代码
			* 在com.itheima.gjp.controller包中编写Controller控制层SortMngController#deleteSort()
				/*
				 * 分类管理对话框的子类
				 * 实现分类管理的功能
				 * 显示分类管理界面，new这个子类
				 */
				public class SortMngController extends AbstractSortMngDialog {
					
					//成员位置，创建出services层SortService类的对象
					private SortService sortService = new SortService();
					
					public SortMngController(JFrame frame) {
						super(frame);
					   //向表格中，填充分类数据，在构造方法中实现
						//setTableModel方法，传递List<Sort>集合，向表格中填充数据
						/*
						 * 实现步骤
						 * 1. 调用serives层 中方法，获取出List集合
						 * 2. services层调用dao层，获取出List集合
						 * 3. dao层，查询数据库，数据表中的结果集变成List集合，返回
						 * 4. 调用父类方法setTableModel，传递List集合
						 * 5. 抽取一个方法，调用即可
						 */
						refresh();
						
					}
					//其它代码省略。。。。
					/*
					 * 点击删除按钮，调用方法
					 *  实现步骤：
					 *    获取选择哪一行
					 *    提示对话框，询问用户，是否真的要删除吗
					 *    调用services层方法deleteSort，传递Sort对象
					 *    刷新数据
					 */
					
					@Override
					public void deleteSort() {
						//获取用户选择行号
						int row = sortDataTable.getSelectedRow();
						if(row<0){
							JOptionPane.showMessageDialog(this, "请选择数据");
							return ;
						}
						//getSortByTableRow，传递行号，返回这一行的数据，封装Sort对象
						Sort sort = getSortByTableRow(row);
						if(sort == null){
							JOptionPane.showMessageDialog(this, "选择的是空行");
							return ;
						}
						//提示用户，真的要删除吗
						int i = JOptionPane.showConfirmDialog(this, "是否真的要删除吗", "删除提示", JOptionPane.YES_NO_OPTION);
						if(i==JOptionPane.OK_OPTION){
							//调用services层方法deleteSort
							sortService.deleteSort(sort);
							JOptionPane.showMessageDialog(this, "删除成功");
							refresh();
						}
					}
					//刷新显示分类数据
					private void refresh(){
						List<Sort> list = sortService.querySortAll();
						setTableModel(list);
					}

				}


###18总结
	* 把今天的知识点总结一遍。

	


