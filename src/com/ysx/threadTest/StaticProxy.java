/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 *
 */

// 静态代理模式
// 真实对象和代理对象都实现同一个接口
// 代理对象代理真实对象
// 好处：代理对象可以做很多真实对象做不了的事情
//      真实对象专注做自己的事情
public class StaticProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeddingCompany weddingCompany = new WeddingCompany(new You());
		weddingCompany.happyMarry();

	}

}

interface Marry {
	void happyMarry();
}

// 真实角色
class You implements Marry {
	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("杨顺新要结婚了，超开心");
	}
}

// 代理角色
class WeddingCompany implements Marry {

	// 代理实例
	private Marry targetMarry;

	/**
	 * 
	 */
	public WeddingCompany(Marry target) {
		// TODO Auto-generated constructor stub
		this.targetMarry = target;
	}

	@Override
	public void happyMarry() {
		before();
		this.targetMarry.happyMarry();
		after();

	}

	/**
	 * 
	 */
	private void after() {
		// TODO Auto-generated method stub
		System.out.println("结婚后 收尾款");
	}

	/**
	 * 
	 */
	private void before() {
		// TODO Auto-generated method stub
		System.out.println("结婚前 准备婚礼现场");
	}

}