/**
 * 
 */
package com.ysx.exception;

/**
 * @author yangs
 *
 */
public class demo {

	/**
	 * 
	 */
	public static void main(String[] args) {
		int a = 1;
		int b = 0;

		// 主动抛出异常
		if (b == 0) {
			throw new ArithmeticException();// 主动抛出异常
		}

		try {
			System.out.println(a / b);
		} catch (Error e) {
			System.out.println("java 出现错误");

		} catch (Exception t) {
			System.out.println("java 编码异常，必须处理");

		} catch (Throwable e) {
			System.out.println("程序出现异常，分母不能为0");

		} finally {
			// TODO: handle finally clause
			System.out.println("finally");
		}
		// 可以不要 finally

	}

}
