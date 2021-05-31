/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 *
 */
public class ThreadTest extends Thread {

	/**
	 * 创建线程的方法： 1.继承Thread类 2. 重写run方法，3. 创建线程对象，调用start()方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ThreadTest t = new ThreadTest();
		t.start();

		for (int i = 0; i < 20; i++) {
			System.out.println("主线程：" + i);

		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println("**子线程：" + i);
		}
	}

}
