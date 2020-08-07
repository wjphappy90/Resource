package com.itheima.gjp.controller;

import javax.swing.JFrame;
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

	@Override
	public void parentChange() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pie() {
		new ShapeController(this).setVisible(true);

	}

}
