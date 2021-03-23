/**
 * 
 */
package com.ysx.polymorphism;

/**
 * @author yangs
 *
 */
public class Tiger extends Pet {

	/**
	 * 
	 */
	public Tiger() {
		// TODO Auto-generated constructor stub
	}

	public Tiger(String name) {
		this.setName(name);
	}

	public void enjoy() {
		System.out.println(this.getName() + " 来呀，一起吃肉呀，，，，，");
	}

}
