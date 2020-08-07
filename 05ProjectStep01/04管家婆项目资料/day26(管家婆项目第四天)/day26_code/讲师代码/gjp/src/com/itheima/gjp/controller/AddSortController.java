package com.itheima.gjp.controller;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.itheima.gjp.domain.Sort;
import com.itheima.gjp.services.SortService;
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
	/*
	 * 添加分类的确定按钮
	 * 实现步骤：
	 *   1. 数据验证
	 *     验证分类选项
	 *     验证分类名称
	 *     数据不符合要求，提示对话框，从新输入
	 *   2. 将获取到的数据，封装成Sort对象
	 *      lid成员，不需要设置值
	 *   3. 将Sort对象传递给services层处理
	 *   4. services获取Sort对后，对象传递给dao层
	 *   5. dao层中，将Sort对象中的数据写入到数据表中 insert
	 *   6. 提示用户添加成功
	 *   7. 从新加载分类功能 -- SortMngController这个对话框的addSort方法中实现
	 */
	@Override
	public void confirm() {
		//对添加功能的数据，进行验证
		//获取分类下拉菜单，用户选择的值
		//getSelectedItem获取下拉菜单，中选择的内容
		String parent = parentBox.getSelectedItem().toString();
		//获取分类名称
		String sname = snameTxt.getText().trim();
		//获取分类的秒睡
		String sdesc = sdescArea.getText();
		//验证用户选择的下拉菜单
		//选择的内容，不等于  =请选择= 就可以
		if(parent.equals("=请选择=")){
			//弹出对话框，选择错误
			JOptionPane.showMessageDialog(this, "请选择分类");
			//"错误提示", JOptionPane.ERROR_MESSAGE
			return ;
		}
		//验证分类名称，不是空即可
		if(sname == null  ||sname.equals("")){
			JOptionPane.showMessageDialog(this, "请填写分类名称");
			return ;
		}
		
		//获取到数据封装成Sort类对象
		Sort sort = new Sort(0, sname, parent, sdesc);
		/*Sort sort = new Sort();
		sort.setParent(parent);
		sort.setSname(sname);
		sort.setSdesc(sdesc);*/
		//调用service层的SortService方法addSort()传递Sort对象
		//创建service层的SortService类的对象
		SortService sortService = new SortService();
		//调用方法addSort传递封装好的Sort对象
		sortService.addSort(sort);
		
		//new SortService().addSort(sort);
		//提示用户，添加分类成功
		JOptionPane.showMessageDialog(this, "添加分类成功", "操作成功", JOptionPane.PLAIN_MESSAGE);
		
		//关闭自己的对话框
		this.dispose();
		
	}

}
