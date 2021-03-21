/**
 * 
 */
package com.ysx.javabase;

/**
 * @author yangs
 *
 */
public class baseType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("my baseType");
		System.out.println(0b1010);
		// java中的数据类型： byte int short long float double
		// 常量：不能改变的量 final
		int a;
		int b = 10;
		a = 11;
		System.out.println(a);
		System.out.println(b);
		// 字符串类型
		String name = "ysx";
		System.out.println(name);

		// 定义常量 使用关键字 final
		// 1. final修饰的变量是一个常量，不能被改变
		// 2. final常量要用大写
		final int NUM = 100;
		// NUM = 20; // cant be assigned!!!
		System.out.println(NUM);
	}

}
