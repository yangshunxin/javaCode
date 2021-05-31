/**
 * 
 */
package com.ysx.nework;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yangs
 *
 */
public class TestInetAddress {

	public static void main(String[] args) {
		// 根据域名获取IP
		InetAddress inetAdress1;
		try {
			inetAdress1 = InetAddress.getByName("www.baidu.com");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		// 获取IP
		System.out.println(inetAdress1.getHostAddress());
		// 获取域名
		System.out.println(inetAdress1.getHostName());

	}

}
