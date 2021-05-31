/**
 * 
 */
package com.ysx.threadTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * @author yangs
 *
 */
public class MultiThreadDownload extends Thread {

	private String urlString;
	private String nameString;

	/**
	 * 
	 */
	public MultiThreadDownload(String url, String name) {
		this.urlString = url;
		this.nameString = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		WebDownload webDownload = new WebDownload();
		webDownload.downloader(urlString, nameString);
		System.out.println("下载了：" + nameString);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiThreadDownload multiThreadDownload1 = new MultiThreadDownload(
				"https://www.baidu.com/img/flexible/logo/pc/result.png", "1.png");
		MultiThreadDownload multiThreadDownload2 = new MultiThreadDownload(
				"https://www.baidu.com/img/flexible/logo/pc/result.png", "2.png");
		MultiThreadDownload multiThreadDownload3 = new MultiThreadDownload(
				"https://www.baidu.com/img/flexible/logo/pc/result.png", "3.png");

		multiThreadDownload1.start();
		multiThreadDownload2.start();
		multiThreadDownload3.start();

	}

}

class WebDownload {

	// 下载
	public void downloader(String url, String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("download URL error msg:" + url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("download ioError msg:" + name);
		}
	}

}
