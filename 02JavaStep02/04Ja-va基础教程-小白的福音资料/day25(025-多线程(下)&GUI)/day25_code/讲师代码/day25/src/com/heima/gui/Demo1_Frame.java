package com.heima.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Demo1_Frame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("我的第一个窗口");
		f.setSize(400, 600);							//设置窗体大小
		f.setLocation(500, 50);							//设置窗体位置
		f.setIconImage(Toolkit.getDefaultToolkit().createImage("qq.png"));
		Button b1 = new Button("按钮一");
		Button b2 = new Button("按钮二");
		f.add(b1);
		f.add(b2);
		f.setLayout(new FlowLayout());					//设置布局管理器
		//f.addWindowListener(new MyWindowAdapter());
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		b1.addMouseListener(new MouseAdapter() {
			/*@Override
			public void mouseClicked(MouseEvent e) {	//单击
				System.exit(0);
			}*/
			@Override
			public void mouseReleased(MouseEvent e) {	//释放
				System.exit(0);
			}
		});
		
		b1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//System.exit(0);
				//System.out.println(e.getKeyCode());
				//if(e.getKeyCode() == 32) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					System.exit(0);
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {		//添加动作监听,应用场景就是暂停视频和播放视频
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);								//设置窗体可见
	}

}

/*class MyWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
}
*/

/*class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}*/

