/**
 * 
 */
package anim;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 杨朗飞
 *
 *  2016年11月1日 下午2:46:45
 */
public class Main {
	private static Socket  socket;
	
	public static void main(String[] args) {
		try {
			socket=new Socket("192.168.1.134", 8888);
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF("connect success");
			dos.flush();
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			/*try {
				if(socket!=null){
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	}

}
