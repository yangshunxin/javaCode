/**
 * 
 */
package com.ysx.threadTest;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author yangs
 * 线程sleep， 表示线程阻塞时间， 可以用来做两件事：模拟网络延时，倒计时；
 */
public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		// timeDown();
		// 打印当前系统时间
		Date st = new Date(System.currentTimeMillis());// 获取当前系统时间
		while (true) {
			Thread.sleep(1000);
			System.out.println(new SimpleDateFormat("HH:mm:ss").format(st));
			st = new Date(System.currentTimeMillis()); // 更新当前时间

		}

	}

	// 倒计时
	public static void timeDown() throws InterruptedException {
		int num = 10;
		while (true) {
			Thread.sleep(1000);
			System.out.println(num--);
			if (num <= 0) {
				break;
			}
		}

	}
}
