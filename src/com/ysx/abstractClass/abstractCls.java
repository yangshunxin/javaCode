/**
 * 
 */
package com.ysx.abstractClass;

/**
 * @author yangs
 *
 */
//抽象类
// 有抽象方法的类 就必须是抽象类， 单也可以有普通方法；
// 抽象类不能被实例化
public abstract class abstractCls {

	/**
	 * 
	 */
	public abstractCls() {
		// TODO Auto-generated constructor stub
	}

	// 约束， 有人帮我们实现
	// 抽象方法，只有方法名，可以不实现
	// 抽象方法必须在抽象类中

	public abstract void doSomething();

}
