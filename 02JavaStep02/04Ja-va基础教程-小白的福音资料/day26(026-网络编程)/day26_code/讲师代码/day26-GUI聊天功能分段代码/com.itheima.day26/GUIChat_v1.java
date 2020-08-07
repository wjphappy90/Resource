package com.itheima.day26;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * GUI聊天版本1 -- 搭建框架
 */
// 继承Frame，方便使用Frame中的功能
public class GUIChat_v1 extends Frame {

	private static final long serialVersionUID = 1L;

	public GUIChat_v1() {
		// 将窗体的初始化动作放到构造方法中，对象一创建就初始化好了。
		
		init(); // 初始化窗体
		
		southPanel(); // 初始化南边的Panel
		
		centerPanel(); // 初始化中间的Panel
		
		event(); // 添加事件
	}

	public void event() {
		// 窗体关闭事件
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void centerPanel() {
		Panel center = new Panel(); // 创建中间的Panel
		
		TextArea viewText = new TextArea(); // 显示文本区域
		viewText.setEditable(false); // 设置不可编辑
		viewText.setBackground(Color.WHITE); // 设置背景白色
		viewText.setFont(new Font("xxx", Font.PLAIN, 15)); // 常规字体15磅
		
		TextArea sendText = new TextArea(5, 1); // 发送文本区域
		sendText.setFont(new Font("xxx", Font.PLAIN, 15));
		
		center.setLayout(new BorderLayout()); // 设置为边界布局管理器
		
		center.add(sendText, BorderLayout.SOUTH); // 将发送文本区域设置在南边
		center.add(viewText, BorderLayout.CENTER); // 将显示文本区域设置在中间
		
		this.add(center, BorderLayout.CENTER); // 将中间的Panel添加到窗体
		
	}

	public void southPanel() {
		Panel south = new Panel(); // 创建南边的Panel
		
		TextField tf = new TextField(15); // 创建文本字段存储ip地址，15列
		Button send = new Button("发 送"); // 发送按钮
		Button log = new Button("记 录"); // 记录按钮
		Button clear = new Button("清 屏"); // 清屏按钮
		Button shake = new Button("震 动"); // 震动按钮
		
		// 按钮添加到Panel
		south.add(tf);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		
		this.add(south, BorderLayout.SOUTH); // 将南边的Panel添加到窗体
	}

	public void init() {
		this.setLocation(500, 50); // 设置窗体位置，距左侧500px，距上方50px
		this.setSize(400, 600); // 设置窗体大小 400 * 600
		this.setVisible(true); // 设置窗体可见
	}

	public static void main(String[] args) {
		new GUIChat_v1(); // 创建一个窗体（Frame的子类对象）
	}

}
