package com.itheima.gjp.controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itheima.gjp.domain.Ledger;
import com.itheima.gjp.services.LedgerServices;
import com.itheima.gjp.services.SortService;
import com.itheima.gjp.view.AbstractOperationLedgerDialog;

public class EditLedgerController extends AbstractOperationLedgerDialog {
	private SortService sortService = new SortService();
	private Ledger ledger;
	private LedgerServices ledgerServices = new LedgerServices();
	public EditLedgerController(JDialog dialog, Ledger ledger) {
		super(dialog);
		titleLabel.setText("编辑账务");
		super.setTitle("编辑账务");
		this.ledger=ledger;
		// 编辑对话框中,全数据,都显示
		parentBox.setSelectedItem(ledger.getParent());
		// setSelectedItem,将菜单原有的内容,设置一个默认选项
		// sortBox.setSelectedItem(ledger.getSname());

		// 获取到的分类名称,转字符串数组
		String[] items = { ledger.getSname() };
		// 调用的是菜单的方法setModel,从新设置菜单数据
		sortBox.setModel(new DefaultComboBoxModel(items));

		accountTxt.setText(ledger.getAccount());
		moneyTxt.setText(ledger.getMoney() + "");
		createtimeTxt.setText(ledger.getCreatetime());
		ldescTxt.setText(ledger.getLdesc());
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
	 * 点击编辑的确定按钮,调用方法
	 * 获取用户选择的数据
	 * 对数据进行验证
	 * 数据封装成Ledgerd对象
	 * 调用serveices层方法
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
		int lid = ledger.getLid();
		ledger = new Ledger();
		//将已有的数据,封装到Ledger对象中
		ledger.setAccount(account);
		ledger.setCreatetime(createtime);
		ledger.setLdesc(ldesc);
		ledger.setMoney(money);
		ledger.setParent(parent);
		ledger.setLid(lid);
		
		int sid = ledgerServices.getSidBySname(sname);
		ledger.setSid(sid);
		
		//调用services层方法editLedger
		ledgerServices.editLedger(ledger);
		this.dispose();
		JOptionPane.showMessageDialog(this, "编辑成功");
	}

}
