package com.itheima.gjp.controller;

import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itheima.gjp.domain.Ledger;
import com.itheima.gjp.domain.QueryForm;
import com.itheima.gjp.services.LedgerServices;
import com.itheima.gjp.services.SortService;
import com.itheima.gjp.view.AbstractLedgerMngDialog;

/**
 * @author apple
 * 账务管理对话框控制层
 */
public class LedgerMngController extends AbstractLedgerMngDialog {

	public LedgerMngController(JFrame frame) {
		super(frame);
	}
	private SortService sortService = new SortService();
	private LedgerServices ledgerServices = new LedgerServices();
	
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
		//获取到选择的行
		int row = ledgerDataTable.getSelectedRow();
		if(row<0){
			JOptionPane.showMessageDialog(this, "请选择要编辑的数据");
			return ;
		}
		//调用父类方法getLedgerByTableRow,传递行号,获取到一个Ledger对象
		Ledger ledger = getLedgerByTableRow(row);
		if(ledger==null){
			JOptionPane.showMessageDialog(this, "选择的是空行");
			return ;
		}
		//弹出编辑对话框,传递给Ledger对象,窗体开启的时候,显示出选择的数据
		new EditLedgerController(this,ledger).setVisible(true);
		queryLedger();
	}

	@Override
	public void deleteLedger() {
		//获取选择的行号
		int row = ledgerDataTable.getSelectedRow();
		if(row<0){
			JOptionPane.showMessageDialog(this, "没有选择数据");
			return ;
		}
		//将选择中的行,封装成Ledger对象
		Ledger ledger = getLedgerByTableRow(row);
		if(ledger==null){
			JOptionPane.showMessageDialog(this, "选择的是空行");
			return ;
		}
		//确认删除的提示对话框
		int result = JOptionPane.showConfirmDialog(this, "是否确认删除吗");
		if(result==JOptionPane.OK_OPTION){
			//调用services层方法 deleteLedger,传递lid值,数据表的主键
			ledgerServices.deleteLedger(ledger.getLid());
			JOptionPane.showMessageDialog(this, "删除成功");
		}
		queryLedger();
	}
	/*
	 * 点击查询按钮,实现查询功能
	 * 获取的是services层的查询结果
	 * 结果做成Map集合
	 *   key: 键名   value: 查询数据数据的List集合
	 *   key: 键名  value: 所有收入的总和
	 *   key: 键名  value: 所有支出的总和
	 *   map.put("",数据库结果集List集合)
	 *   map.put("",inMoney)
	 *   map.put("",payMoney)
	 */
	@Override
	public void queryLedger() {
		//用户选择的查询条件,封装到QueryForm对象中
		String begin = beginDateTxt.getText();
		String end = endDateTxt.getText();
		String parent = parentBox.getSelectedItem().toString();
		String sname = sortBox.getSelectedItem().toString();
		QueryForm form = new QueryForm(begin, end, parent, sname);
		//调用Services层方法,queryLedgerByQueryForm
		//获取到Map集合 ,键:ledger 值 List集合,填充在表格中
		Map<String,Object> data = ledgerServices.queryLedgerByQueryForm(form);
		List<Ledger> list =(List<Ledger>) data.get("ledger");
		double in = (double)data.get("in");
		double pay = (double)data.get("pay");
		//将查询数据List填充表格JTable中
		this.setTableModel(list);
		//计算的后求和,填充到Label中
		inMoneyTotalLabel.setText("总收入  "+in+" 元");
		payMoneyTotalLabel.setText("总支出  "+pay+" 元");
	//	payMoneyTotalLabel.setText(new StringBuilder().apped("总收入 ").append(in).toString());
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
