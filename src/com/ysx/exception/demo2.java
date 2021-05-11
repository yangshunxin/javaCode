/**
 * 
 */
package com.ysx.exception;

/**
 * @author yangs
 *
 */
public class demo2 {

	public static void main(String[] args) {

		try {
			demo2 inst = new demo2();
			inst.test(1, 0);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("get exception");
		}

	}

	public void test(int a, int b) throws ArithmeticException {
		if (b == 0) {
			throw new ArithmeticException();// 主动在方法中抛出异常
		}
	}

}
