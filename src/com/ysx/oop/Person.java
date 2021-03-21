/**
 * 
 */
package com.ysx.oop;

/**
 * @author yangs
 *
 */
public class Person {
	private String name;
	private String furColor;
	private int age;

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 * 这里就是对类的属性  就行封装，类的封装性
	 */
	public void setAge(int age) {
		if (age < 1 || age > 200) {
			System.out.println("年龄不合法：" + age);
		} else {
			// 赋值
			this.age = age;
		}
	}

	/**
	 * 
	 */
	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.setAge(age);
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

	/**
	 * @return the furColor
	 */
	public String getFurColor() {
		return furColor;
	}

	/**
	 * @param furColor the furColor to set
	 */
	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public Person(String name, String furColor) {
		this.name = name;
		this.furColor = furColor;
	}

	public Person(String name, String furColor, int age) {
		// TODO Auto-generated constructor stub
		this(name, age); // 必须放在第一行
		this.furColor = furColor;
	}

	public void print() {
		System.out.println("name:" + this.name + " color:" + this.furColor + " age:" + this.age);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", furColor=" + furColor + ", age=" + age + "]";
	}

}
