package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.View;

public class ControlUi extends JFrame {

	public ControlUi() {
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 200, 200);
		final JButton button = new JButton();
		button.setText("开启服务");
		final JButton button1 = new JButton();
		button1.setText("开启客户端");
		panel.add(button);
		panel.add(button1);
		add(panel);
		setBackground(Color.GRAY);
		setBounds(100, 100, 300, 300);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("开启服务")) {
					openServer();
					button.setText("关闭服务");
				} else {
					button.setText("开启服务");
				}

			}
		});

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("开启客户端")) {
					openClient();
					button.setText("关闭客户端");
				} else {
					button.setText("开启客户端");
				}

			}
		});
	}

	protected void openServer() {
		new Thread() {
			public void run() {
				ServerUi server = new ServerUi();
				server.setVisible(true);
			}
		}.start();

	}

	protected void openClient() {
		new Thread() {
			public void run() {
				MyUi client = new MyUi();
				client.setVisible(true);
			}
		}.start();

	}

	public static void main(String[] args) {
		ControlUi ui = new ControlUi();
		ui.setVisible(true);
	}

}
