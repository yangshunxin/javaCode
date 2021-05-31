/**
 * 
 */
package com.ysx.inherit;

/**
 * @author yangs
 *
 */
public class Father {

	/**
	 * 
	 */
	public Father() {
		// TODO Auto-generated constructor stub
		System.out.println("this is father constructor!!!");
	}

	public Father(String name) {
		System.out.println("this is father constructor:" + name);
	}

	public static void work() {
		System.out.println("father work!!!");
	}

}
