/**
 * 
 */
package com.ysx.polymorphism;

/**
 * @author yangs
 *
 */
public class Pet {
	private String name;

	/**
	 * 
	 */
	public void enjoy() {
		System.out.println(this.name + " 很高兴，，，，，");
	}

	public Pet() {
		// TODO Auto-generated constructor stub
	}

	public Pet(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
