package com.itheima.gjp.controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itheima.gjp.domain.Sort;
import com.itheima.gjp.services.SortService;
import com.itheima.gjp.view.AbstractSortMngDialog;
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
	 * 
	 * 对用户选择的分类数据进行控制
	 * 不选择
	 * 选择空行
	 * sortDataTable 表格中的方法 getSelectRow（）获取选择的行  ，返回-1,没有选择
	 * 选择的是空行：
	 * getSortByTableRow() 父类方法，传递选中的行号，返回这一行的数据，封装到Sort对象
	 * 如果用户选择有效行，封装好的Sort对象，传递给EditSortController对话框
	 * 后面的实现和新增几乎一致
	 */
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
