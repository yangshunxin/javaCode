/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 * 
 * 对于普通线程，当主线程停止了，不同线程不会停止，执行完才会停止
 * 对于守护线程，当主线程停止了，守护线程也会停止
 *
 */
public class ThreadDaemon implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("main thread begin");
		Thread thread = new Thread(new ThreadDaemon());
		// thread.setDaemon(true); // 设置为守护线程
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main thread end");
	}

	@Override
	public void run() {
		System.out.println("thread begin");
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			System.out.println("thread is runing");
		}
		System.out.println("thread end");
	}

}
