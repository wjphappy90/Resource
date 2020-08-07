package com.itheima.gjp.controller;

import javax.swing.JFrame;

import com.itheima.gjp.view.AbstractSortMngDialog;

public class SortMngController extends AbstractSortMngDialog {
	public SortMngController(JFrame frame) {
		super(frame);

	}
	/*
	 * 添加分类按钮，点击后调用的方法
	 * 开启添加分类的对话框
	 */
	@Override
	public void addSort() {
		new AddSortController(this).setVisible(true);

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
		// TODO Auto-generated method stub

	}

}
