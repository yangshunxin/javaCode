/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 * 跳出当前执行，让CPU重新调度，CPU调度是无法确定的
 *
 */
public class ThreadYield implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread(new ThreadYield(), "a").start();
		new Thread(new ThreadYield(), "b").start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "开始执行");
		Thread.yield();
		System.out.println(Thread.currentThread().getName() + "停止执行");
	}

}
