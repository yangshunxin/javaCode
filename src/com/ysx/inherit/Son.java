/**
 * 
 */
package com.ysx.inherit;

/**
 * @author yangs
 *
 */
public class Son extends Father {

	/**
	 * 
	 */
	public Son() {
		// TODO Auto-generated constructor stub
		System.out.println("this is son constructor!!!");
	}

	public Son(String name) {
		// 显式的调用 父类有参构造函数
		// super代表父类对象，只能在第一句，不能访问父类中的private成员
		super(name);
		System.out.println("this is son constructor:" + name);
	}

}
