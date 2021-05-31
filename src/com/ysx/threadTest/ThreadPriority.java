/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 *
 */
public class ThreadPriority implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("main thread priority:" + Thread.currentThread().getPriority());

		Thread a1 = new Thread(new ThreadPriority(), "1");
		Thread a2 = new Thread(new ThreadPriority(), "2");
		Thread a3 = new Thread(new ThreadPriority(), "3");
		Thread a4 = new Thread(new ThreadPriority(), "4");
		Thread a5 = new Thread(new ThreadPriority(), "5");
		Thread a6 = new Thread(new ThreadPriority(), "6");

		a1.start();

		a2.setPriority(3);
		a2.start();

		a3.setPriority(1);
		a3.start();

		a4.setPriority(5);
		a4.start();

		a5.setPriority(8);
		a5.start();

		a6.setPriority(10);
		a6.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "---> " + Thread.currentThread().getPriority());
	}

}
