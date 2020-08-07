package com.itheima.listener.uilistener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

/**
 * GUI的小窗口演示监听器
 * @author jt
 *
 */
public class MyFrame extends JFrame{

	public static void main(String[] args) {
		// 1.创建小窗口对象：(被监听的对象)
		MyFrame myFrame = new MyFrame();
		// 设置窗口名称:
		myFrame.setName("小窗口");
		// 设置窗口的宽高：
		myFrame.setBounds(0, 0, 200, 180);
		// 2.设置窗口显示：
		myFrame.setVisible(true);
		
		// 在事件源上绑定监听器:
		myFrame.addWindowListener(new MyWindowListener());
	}
}

/**
 * 监听器对象
 * @author jt
 *
 */
class MyWindowListener implements WindowListener{

	@Override
	public void windowClosing(WindowEvent e) {
		MyFrame myFrame = (MyFrame) e.getSource();
		System.out.println(myFrame.getName());
		System.out.println("窗口关闭...");
		System.exit(0);
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
}
