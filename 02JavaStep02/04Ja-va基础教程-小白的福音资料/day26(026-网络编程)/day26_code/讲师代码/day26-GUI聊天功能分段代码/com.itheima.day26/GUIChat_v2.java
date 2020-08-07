package com.itheima.day26;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * GUI聊天版本2 -- 发送功能
 */
// 继承Frame，方便使用Frame中的功能
public class GUIChat_v2 extends Frame {

	private static final long serialVersionUID = 4605735517129860188L;
	private TextField tf;
	private Button send;
	private Button log;
	private Button clear;
	private Button shake;
	private TextArea viewText;
	private TextArea sendText;

	private DatagramSocket socket;

	public GUIChat_v2() {
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
				
				socket.close(); // 退出之前再关闭socket服务
				
				System.exit(0);
			}
		});

		// 发送功能
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 把发送功能提取成一个方法
				try {
					send();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void send() throws IOException {
		String message = sendText.getText(); // 获取发送区域的内容
		String ip = tf.getText(); // 获取ip地址;
		
//		socket = new DatagramSocket(); // 创建发送端Socket服务，放到初始化时完成，因为不需要每次发送都重新创建

		DatagramPacket packet = new DatagramPacket(message.getBytes(),
				message.getBytes().length, InetAddress.getByName(ip), 9999);
		socket.send(packet);

		String time = getCurrentTime(); // 获取当前时间
		
		String str = time + " 我对:" + ip + "说\r\n" + message + "\r\n\r\n";
		
		viewText.append(str); // 将信息添加到显示区域中
		sendText.setText(""); // 清空发送区的内容
		
//		socket.close(); // 关闭发送端Socket服务，放到退出功能里。不能发一条信息就退出了。

	}

	// 获取当前时间字符串
	private String getCurrentTime() {
		Date d = new Date(); // 创建当前日期对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		return sdf.format(d); // 将时间格式化
	}

	// 中间的Panel
	public void centerPanel() {
		Panel center = new Panel(); // 创建中间的Panel

		viewText = new TextArea();
		viewText.setEditable(false); // 设置不可编辑
		viewText.setBackground(Color.WHITE); // 设置背景白色
		viewText.setFont(new Font("xxx", Font.PLAIN, 15)); // 常规字体15磅

		sendText = new TextArea(5, 1);
		sendText.setFont(new Font("xxx", Font.PLAIN, 15));

		center.setLayout(new BorderLayout()); // 设置为边界布局管理器

		center.add(sendText, BorderLayout.SOUTH); // 将发送文本区域设置在南边
		center.add(viewText, BorderLayout.CENTER); // 将显示文本区域设置在中间

		this.add(center, BorderLayout.CENTER); // 将中间的Panel添加到窗体

	}

	// 南边的Panel
	public void southPanel() {
		Panel south = new Panel(); // 创建南边的Panel

		tf = new TextField(15);
		tf.setText("127.0.0.1"); // 设置默认的发送IP

		send = new Button("发 送");
		log = new Button("记 录");
		clear = new Button("清 屏");
		shake = new Button("震 动");

		// 按钮添加到Panel
		south.add(tf);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);

		this.add(south, BorderLayout.SOUTH); // 将南边的Panel添加到窗体
	}

	// 初始化操作
	public void init() {
		this.setLocation(500, 50); // 设置窗体位置，距左侧500px，距上方50px
		this.setSize(400, 600); // 设置窗体大小 400 * 600
		
		new Receive().start(); // 启动接收线程
		
		try {
			socket = new DatagramSocket();// 初始化的时候就创建发送端Socket对象
		} catch (SocketException e) {
			e.printStackTrace();
		} 
		
		this.setVisible(true); // 设置窗体可见
	}
	
	// 接收数据的线程 -- 定义成内部类的好处：外部类的成员变量可以直接拿来使用
	private class Receive extends Thread {//接收和发送需要同时执行,所以定义成多线程的
		@Override
		public void run() {
			try {
				DatagramSocket socket = new DatagramSocket(9999);
				DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
				
				while(true) {
					socket.receive(packet);				//接收信息
					byte[] arr = packet.getData();		//获取字节数据
					int len = packet.getLength();		//获取有效的字节数据
					
					String message = new String(arr,0,len);	//转换成字符串
					
					String time = getCurrentTime();		//获取当前时间
					String ip = packet.getAddress().getHostAddress();	//获取ip地址
					String str = time + " " + ip + " 对我说:\r\n" + message + "\r\n\r\n";
					viewText.append(str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new GUIChat_v2(); // 创建一个窗体（Frame的子类对象）
	}

}
