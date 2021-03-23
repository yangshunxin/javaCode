/**
 * 
 */
package com.ysx.polymorphism;

/**
 * @author yangs
 *
 */
public class Person {
	private String name;
	Pet pet;

	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, Pet p) {
		setName(name);
		this.pet = p;
	}

	public void feed() {
		System.out.println(name + " 正在给" + pet.getName() + "喂实物，，，");
		this.pet.enjoy();
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
