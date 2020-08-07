package com.itheima.gjp.controller;

import javax.swing.JDialog;


import com.itheima.gjp.view.AbstractOperationSortDialog;

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
		
		
	}

}
