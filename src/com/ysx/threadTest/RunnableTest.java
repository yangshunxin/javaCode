/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 *
 */
public class RunnableTest implements Runnable {

	/**
	 * 创建线程的方法： 1.实现Runnable接口 2. 重写run方法，3. 创建Runnable对象，4. 将Runnable对象作为参数来创建Thread对象，调用Thread对象的start()方法开启线程
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ThreadTest t = new ThreadTest();
		Thread thread = new Thread(t);
		thread.start();

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
