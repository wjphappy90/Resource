package com.itheima.gjp.controller;

import javax.swing.JDialog;

import com.itheima.gjp.view.AbstractOperationLedgerDialog;
/**
 * 
 * @author apple
 * 添加账务对话框
 */
public class AddLedgerController extends AbstractOperationLedgerDialog {

	public AddLedgerController(JDialog dialog) {
		super(dialog);
		titleLabel.setText("添加账务");
		super.setTitle("添加账务");
	}

	@Override
	public void changeParent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirm() {
		// TODO Auto-generated method stub

	}

}
