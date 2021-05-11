/**
 * 
 */
package com.ysx.staticClass;

/**
 * @author yangs
 *
 */
public class staticTest {

	/**
	 * 
	 */
	// 2 每个实例对象都调用一次， 赋初始值
	{
		// 匿名代码块
		System.out.println("匿名代码块");

	}
	// 1--只执行一次
	static {
		// 静态代码块， 类加载是就执行
		System.out.println("静态代码块");

	}

	/**
	 * 
	 */
	public staticTest() {
		// TODO Auto-generated constructor stub
		// 3
		System.out.println("构造函数");
	}

	private static int age; // 静态变量， 多线程！
	private double score; // 非静态变量

	public void run() {

	}

	public static void go() {

	}

	public static void main(String[] args) {
		// 静态属性
		staticTest s1 = new staticTest();
		System.out.println("===============");
		staticTest s2 = new staticTest();

		System.out.println(s1.age);
		System.out.println(s1.score);

		System.out.println(staticTest.age);
		// System.out.println(staticTest.score); // 报错了

		go();
		// run(); //无法运行
	}

}
