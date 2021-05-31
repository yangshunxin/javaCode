/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 * 线程一共有5个状态： 
 * NEW： 尚未启动的线程，new完，但没有start
 * RUNNABLE:正在执行
 * BLOCKED: 被阻塞
 * WAITING：
 * TIMED_WAITING:被sleep
 * TERMINATED：已退出
 */
public class ThreadState implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new ThreadState());
		System.out.println(thread.getState());

		thread.start();

		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(thread.getState());
			if (thread.getState() == Thread.State.TERMINATED) {
				break;
			}
		}
		System.out.println(thread.getState());
		// System.out.println(thread.getPriority());

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 10;
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i--;
			if (i <= 0) {
				break;
			}

		}
	}

}
