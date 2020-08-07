package com.itheima.gjp.controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.itheima.gjp.domain.Ledger;
import com.itheima.gjp.services.LedgerServices;
import com.itheima.gjp.services.SortService;
import com.itheima.gjp.view.AbstractOperationLedgerDialog;

/**
 * 
 * @author apple 添加账务对话框
 */
public class AddLedgerController extends AbstractOperationLedgerDialog {
	private SortService sortService = new SortService();
	private LedgerServices ledgerService = new LedgerServices();

	public AddLedgerController(JDialog dialog) {
		super(dialog);
		titleLabel.setText("添加账务");
		super.setTitle("添加账务");
	}

	@Override
	public void changeParent() {
		// 获取收支的选择
		String parent = parentBox.getSelectedItem().toString();
		// parent选择的是 -请选择-,分类也是请选择
		if (parent.equals("-请选择-")) {
			sortBox.setModel(new DefaultComboBoxModel(new String[] { "-请选择-" }));
		}
		// 情况二,根据数据库查询,查询分类的具体内容
		if (parent.equals("收入") || parent.equals("支出")) {
			// 调用services层方法querySortNameByParent(String parent)查询所有分类名称
			// 获取到一个List.toArray()集合,集合中的数据,填充到下拉菜单中
			List<Object> list = sortService.querySortNameByParent(parent);
			list.add(0, "-请选择-");
			sortBox.setModel(new DefaultComboBoxModel(list.toArray()));
		}

	}
	/*
	 * 点击添加按钮,实现功能
	 * 验证用户填写数据
	 *   分类
	 *   分类名称
	 *   金额>0, 必须是数字
	 *   账户,必须填写的
	 *   
	 * 用户所有填写的数据,封装成Ledger的对象
	 * 传递给services层,进行添加
	 */
	@Override
	public void confirm() {
		String parent = parentBox.getSelectedItem().toString();
		String sname = sortBox.getSelectedItem().toString();
		String account = accountTxt.getText();
		String createtime = createtimeTxt.getText();
		String sMoney = moneyTxt.getText();
		String ldesc = ldescTxt.getText();
		if(parent.equals("-请选择-")){
			JOptionPane.showMessageDialog(this, "请选择收/支");
			return ;
		}
		if(sname.equals("-请选择-")){
			JOptionPane.showMessageDialog(this, "请选择分类名称");
			return ;
		}
		if(account==null || account.isEmpty()){
			JOptionPane.showMessageDialog(this, "请填写账户");
			return ;
		}
		
		//获取到的金额,由String,转出double
		double money = 0;
		try{
			money  = Double.parseDouble(sMoney);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "必须填写数字");
			return ;
		}
		
		if(money<=0){
			JOptionPane.showMessageDialog(this, "金额必须大于0");
			return ;
		}
		//将数据封装成Ledger对象
		//0,数据表主键,假数据   ,sid 是通过sname查询sort表获取,给假的
		//调用service层方法getSidBySname,获取sid值
		int sid = ledgerService.getSidBySname(sname);
		Ledger ledger = new Ledger(0, parent, money, sid, account, createtime, ldesc, sname);
		ledgerService.addLedger(ledger);
		
		this.dispose();
		JOptionPane.showMessageDialog(this, "添加账务成功");
	
	}

}
