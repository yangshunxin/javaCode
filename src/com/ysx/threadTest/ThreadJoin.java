/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 *
 *Join 等待线程停止
 */
public class ThreadJoin implements Runnable {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new ThreadJoin());
		thread.start();

		for (int i = 0; i < 1000; i++) {
			if (i == 500) {
				// 等待子线程停止
				System.out.println("***main thread wait");
				thread.join();
				System.out.println("***main thread begin again");
			}

			System.out.println("main thread " + i);

		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			System.out.println("thread " + i);
		}
	}

}
