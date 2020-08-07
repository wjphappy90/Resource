package com.itheima.gjp.controller;

import java.util.List;

import javax.swing.JFrame;

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
