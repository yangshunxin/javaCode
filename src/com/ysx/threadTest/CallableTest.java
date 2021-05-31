/**
 * 
 */
package com.ysx.threadTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

/**
 * @author yangs
 *
 *Callable的好处：
 *1.可以定义返回值
 *2. 可以抛出异常
 *
 */
public class CallableTest implements Callable<Boolean> {

	private String urlString;
	private String nameString;

	/**
	 * 
	 */
	public CallableTest(String url, String name) {
		this.urlString = url;
		this.nameString = name;
	}

	@Override
	public Boolean call() {
		// TODO Auto-generated method stub
		WebDownload2 webDownload = new WebDownload2();
		webDownload.downloader(urlString, nameString);
		System.out.println("下载了：" + nameString);
		return true;
	}

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		CallableTest t1 = new CallableTest("https://www.baidu.com/img/flexible/logo/pc/result.png", "1.png");
		CallableTest t2 = new CallableTest("https://www.baidu.com/img/flexible/logo/pc/result.png", "2.png");
		CallableTest t3 = new CallableTest("https://www.baidu.com/img/flexible/logo/pc/result.png", "3.png");

//		multiThreadDownload1.start();
//		multiThreadDownload2.start();
//		multiThreadDownload3.start();

		// 创建执行服务
		ExecutorService ser = Executors.newFixedThreadPool(3);

		// 提交执行
		Future<Boolean> r1 = ser.submit(t1);
		Future<Boolean> r2 = ser.submit(t2);
		Future<Boolean> r3 = ser.submit(t3);

		// 获取结果
		Boolean rs1 = r1.get();
		Boolean rs2 = r2.get();
		Boolean rs3 = r3.get();

		System.out.println(rs1);
		System.out.println(rs2);
		System.out.println(rs3);

		// 关闭服务
		ser.shutdown();

	}

}

class WebDownload2 {

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
