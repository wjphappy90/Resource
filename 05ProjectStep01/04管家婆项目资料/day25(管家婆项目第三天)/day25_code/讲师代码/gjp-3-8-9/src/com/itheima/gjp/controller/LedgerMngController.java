package com.itheima.gjp.controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

import com.itheima.gjp.services.SortService;
import com.itheima.gjp.view.AbstractLedgerMngDialog;

/**
 * @author apple
 * 账务管理对话框控制层
 */
public class LedgerMngController extends AbstractLedgerMngDialog {

	public LedgerMngController(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}
	private SortService sortService = new SortService();
	
	/*
	 * 点击添加账务按钮，弹出添加账务对话框
	 */
	@Override
	public void addLedger() {
		new AddLedgerController(this).setVisible(true);

	}
	/*
	 * 点击编辑账务按钮，弹出编辑账务对话框
	 */
	@Override
	public void editLedger() {
		new EditLedgerController(this).setVisible(true);
	}

	@Override
	public void deleteLedger() {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryLedger() {
		// TODO Auto-generated method stub

	}
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

	@Override
	public void pie() {
		new ShapeController(this).setVisible(true);

	}

}
