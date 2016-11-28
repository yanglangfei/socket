package utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class ReadThread extends Thread{
	
	
	private Socket socket;
	private List<Integer> integers;
	private DataInputStream dis;
	private DataOutputStream dos;
	private int port;

	public ReadThread(Socket socket, List<Integer> integers) {
		this.socket=socket;
		this.integers=integers;
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			port = socket.getLocalPort();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String readStr=dis.readUTF();
			dos.writeUTF(readStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
