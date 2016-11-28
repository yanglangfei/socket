package ui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyUi extends JFrame{
	
	private JLabel label;

	public MyUi() {
		JPanel panel=new JPanel();
		JPanel msgPanel=new JPanel();
		panel.setBounds(100, 100, 200, 200);
		final JButton button=new JButton();
		label=new JLabel();
		button.setText("连接");
		panel.add(button);
		msgPanel.add(label);
		add(panel);
		add(msgPanel);
		setBackground(Color.GRAY);
		setBounds(100, 100, 300, 300);
		setTitle("Client");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("连接")){
					connectServer();
					button.setText("断开连接");
				}else{
					button.setText("连接");
				}
			}
		});
	}

	protected void connectServer() {
		Socket socket = null;
		StringBuffer buffer=null;
		try {
			buffer=new StringBuffer();
			socket=new Socket("192.168.1.134", 5858);
			System.out.println("s:"+socket.getLocalPort());
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			DataInputStream dis=new DataInputStream(is);
			DataOutputStream dos=new DataOutputStream(os);
			String str=dis.readUTF();
			buffer.append(str+"\n");
			label.setText(buffer.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			try {
				if(socket!=null){
					socket.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if(socket!=null){
					socket.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
