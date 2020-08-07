package com.itheima.gjp.controller;

import javax.swing.JDialog;
import javax.swing.JLabel;

import com.itheima.gjp.view.AbstractOperationLedgerDialog;

public class EditLedgerController extends AbstractOperationLedgerDialog {
	
	public EditLedgerController(JDialog dialog) {
		super(dialog);
		titleLabel.setText("编辑账务");
		super.setTitle("编辑账务");
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
