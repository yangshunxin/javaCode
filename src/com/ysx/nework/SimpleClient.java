/**
 * 
 */
package com.ysx.nework;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author yangs
 *
 */
public class SimpleClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream oStream = null;
		String msgString = "你好，我是学java的杨顺新";
		try {
			// 1. 知道服务器的地址和端口号
			InetAddress serverIPAddress = InetAddress.getByName("127.0.0.1");
			int port = 9999;
			// 2. 创建一个socket连接
			socket = new Socket(serverIPAddress, port);
			// 3. 发送消息 IO流
			oStream = socket.getOutputStream();
			oStream.write(msgString.getBytes());
			oStream.write(msgString.getBytes());
			oStream.write(msgString.getBytes());
			socket.shutdownOutput(); // 告诉服务器 我已经传递完了
			System.out.println("send:" + msgString);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				oStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
