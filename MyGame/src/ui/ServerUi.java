package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.ReadThread;

public class ServerUi extends JFrame{
	
	private boolean isRun;
	private List<Integer> integers=new ArrayList<>();

	public ServerUi() {
		JPanel panel=new JPanel();
		panel.setBounds(100, 100, 200, 200);
		final JButton button=new JButton();
		button.setText("打开");
		panel.add(button);
		add(panel);
		setBounds(100, 100, 500, 500);
		setTitle("server");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("打开")){
					isRun=true;
					openServer();
					button.setText("关闭");
				}else{
					isRun=false;
					button.setText("打开");
				}
				
			}
		});
	}

	protected void openServer() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5858);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		while (isRun) {
			try {
				System.out.println("wait connect...");
				Socket socket = serverSocket.accept();
				System.out.println("connect..");
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				DataInputStream dis=new DataInputStream(is);
				DataOutputStream dos=new DataOutputStream(os);
				new ReadThread(socket,integers).start();
				dos.writeUTF(socket.getPort()+"connect success..");
			} catch (IOException e) {
				e.printStackTrace();
				try {
					if(serverSocket!=null){
						serverSocket.close();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ServerUi ui=new ServerUi();
		ui.setVisible(true);
	}

}
