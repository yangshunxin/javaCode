/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 *
 */
public class MultithreadError implements Runnable {

	private int ticketNum = 10;

	@Override
	public void run() {

		while (true) {
			if (ticketNum <= 0) {
				break;
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 并发的问题
			System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum + "张票");
			ticketNum--;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultithreadError multithreadError1 = new MultithreadError();
		MultithreadError multithreadError2 = new MultithreadError();
		MultithreadError multithreadError3 = new MultithreadError();

		new Thread(multithreadError1, "小明").start();
		new Thread(multithreadError2, "老师").start();
		new Thread(multithreadError3, "学校").start();

	}

}
