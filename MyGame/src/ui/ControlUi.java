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
		button.setText("��������");
		final JButton button1 = new JButton();
		button1.setText("�����ͻ���");
		panel.add(button);
		panel.add(button1);
		add(panel);
		setBackground(Color.GRAY);
		setBounds(100, 100, 300, 300);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("��������")) {
					openServer();
					button.setText("�رշ���");
				} else {
					button.setText("��������");
				}

			}
		});

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�����ͻ���")) {
					openClient();
					button.setText("�رտͻ���");
				} else {
					button.setText("�����ͻ���");
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
