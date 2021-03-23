/**
 * 
 */
package com.ysx.polymorphism;

/**
 * @author yangs
 *
 */
public class Dog extends Pet {

	/**
	 * 
	 */
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String name) {
		super(name);
	}

	public void enjoy() {
		System.out.println(this.getName() + " 汪汪汪，，，，");
	}
}
