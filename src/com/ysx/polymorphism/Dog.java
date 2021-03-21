/**
 * 
 */
package com.ysx.polymorphism;

/**
 * @author yangs
 *
 */
public class Dog extends Pet {

	private boolean bRegister = false; // 是否登记

	public void show() {
		System.out.println("name:" + this.getName() + " age:" + this.getAge() + " bRegister:" + this.isbRegister());
	}

	/**
	 * @return the bRegister
	 */
	public boolean isbRegister() {
		return bRegister;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	/**
	 * == 比较的 是不是同一个内存地址
	 * 
	 * */
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	/**
	 * @param bRegister the bRegister to set
	 */
	public void setbRegister(boolean bRegister) {
		this.bRegister = bRegister;
	}

	/**
	 * 
	 */
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age) {
		super(name, age);
	}

}
