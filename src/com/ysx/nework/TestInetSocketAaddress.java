/**
 * 
 */
package com.ysx.nework;

import java.net.InetSocketAddress;

/**
 * @author yangs
 *
 */
public class TestInetSocketAaddress {

	public static void main(String[] args) {
		InetSocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 8080);
		InetSocketAddress socketAddress2 = new InetSocketAddress("127.0.0.1", 8080);

		System.out.println(socketAddress);
		System.out.println(socketAddress2);

		System.out.println(socketAddress.getAddress());
		System.out.println(socketAddress.getHostName());
		System.out.println(socketAddress.getPort());
	}

}
