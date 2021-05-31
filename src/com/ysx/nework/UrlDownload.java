/**
 * 
 */
package com.ysx.nework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yangs
 *
 */
public class UrlDownload {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL url = null;
		try {
			// 这个很重要哟，
			// 1. 下载地址
			url = new URL("http://ossppk.oss-cn-shanghai.aliyuncs.com/ppk/7d90d282-fd61-2af2-f177-477280a6e55b.jpg");

			// 2. 连接到这个资源的http
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

			InputStream inputStream = urlConnection.getInputStream();

			FileOutputStream fileOutputStream = new FileOutputStream("x.jpg");

			byte[] buffer = new byte[1024];
			int len;
			while ((len = inputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, len); // 写出这个数据

			}
			fileOutputStream.close();
			inputStream.close();
			urlConnection.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
