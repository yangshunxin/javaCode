/**
 * 
 */
package com.ysx.polymorphism;

/**
 * @author yangs
 *
 */
public class Elephant extends Pet {

	/**
	 * 
	 */
	public Elephant() {
		// TODO Auto-generated constructor stub
	}

	public Elephant(String name) {
		this.setName(name);
	}

	public void enjoy() {
		System.out.println(this.getName() + " 一脚踩死你，，，，，");
	}
}
