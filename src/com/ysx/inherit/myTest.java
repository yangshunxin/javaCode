/**
 * 
 */
package com.ysx.inherit;

/**
 * @author yangs
 *
 */
public class myTest {

	/**
	 * extend 关键字
	 * 子类与父类是is-a关系：父类公有的子类都有--单根性
	 * Java只支持单继承，一个类只能有一个父类--传递性
	 * this表示本类实例对象
	 * super代表父类的对象，子类调用父类实例可以使用super
	 * 
	 * 实例化子类时，初始化过程：
	 * 当实例化子类时，都会先运行父类的无参构造方法；
	 * 先初始化父类（调用父类的构造函数）,然后调用子类的构造函数；用super来调用父类的有参构造函数；
	 * 
	 * protected修饰的在有继承关系下可以跨包访问，
	 * 但是访问方式需要使用this or super
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son s = new Son("ysx");
		s.work();// 子类实例 访问父类的静态方法
	}

}
