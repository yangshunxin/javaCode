/**
 * 
 */
package com.ysx.packageTest;

/**
 * @author yangs
 *
 */
public class staticTest {

	/**
	 * @param args
	 * 
	 *  * static 修饰符
	 * 成员变量：静态变量，可以直接通过类名访问
	 * 成员方法：静态方法，可以直接通过类名访问
	 * 代码块：静态代码块，当java虚拟机加载类时，就会执行该代码块，如果有多个静态代码块，会按顺序镜像加载
	 * 
	 * static final 定义的变量 不能被修改，
	 */
	static int age;

	// 代码块
	static {
		// 加载类时 会调用这里
		age = 10;
		System.out.println(age); // 定义在后面会报错
	}

	public static void method(int age) {
		staticTest.age += age;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		staticTest.method(100);
		System.out.println(staticTest.age);
	}

}
