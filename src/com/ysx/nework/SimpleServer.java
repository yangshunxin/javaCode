/**
 * 
 */
package com.ysx.nework;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangs
 *
 */
public class SimpleServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream iStream = null;
		ByteArrayOutputStream baos = null;

		try {
			// 1. 设置本地的一个监听端口
			serverSocket = new ServerSocket(9999);
			// 循环监听
			while (true) {
				// 2.等待客户端连接
				socket = serverSocket.accept();
				// 3. 读取客户端的消息
				iStream = socket.getInputStream();

				// 管道流
				baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len;
				while ((len = iStream.read(buffer)) != -1) {
					baos.write(buffer, 0, len);

				}
				System.out.println("rcv:" + baos.toString());
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (iStream != null) {
				try {
					iStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
