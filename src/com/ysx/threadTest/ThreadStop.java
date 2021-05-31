/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 * 线程停止最好的方法是 用flag的方式，让线程自然停止； 其它的接口都不建议调用
 */
public class ThreadStop implements Runnable {

	private boolean flag = true;

	public void stop() {
		this.flag = false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 通过代理的方式开启线程
		ThreadStop threadStop = new ThreadStop();
		new Thread(threadStop).start();

		for (int i = 0; i < 1000; i++) {
			if (i == 900) {
				System.out.println("*** call stop thread func");
				threadStop.stop();
			}
			System.out.println("main thread runing " + i);
		}
		System.out.println("*** main thread stop");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (flag) {
			System.out.println("thread is running " + i++);
		}

		System.out.println("*** thread is stop!!!");

	}

}
