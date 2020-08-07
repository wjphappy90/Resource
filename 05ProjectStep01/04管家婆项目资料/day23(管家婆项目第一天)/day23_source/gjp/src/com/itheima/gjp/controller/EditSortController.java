package com.itheima.gjp.controller;

import javax.swing.JDialog;

import com.itheima.gjp.view.AbstractOperationSortDialog;
/*
 * 编辑分类的对话框
 */
public class EditSortController extends AbstractOperationSortDialog {

	public EditSortController(JDialog dialog) {
		super(dialog);
		titleLabel.setText("编辑分类");
		super.setTitle("编辑分类");
	}

	@Override
	public void confirm() {

	}

}
