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
	private int age;

	/**
	 * 方法重写就是：
	 * 子类覆盖父类的方法，子类如果想调用父类的方法，用super.方法名的方式--建立在继承的基础上
	 * 方法名相同，参数列表相同，参数类型相同或者是其子类，访问权限高于父类
	 * 子类中可以定义与父类相同名字的静态方法，以便隐藏父类的静态方法；
	 * 
	 * 方法重载：
	 * 方法名相同，参数列表不同，与返回值无关
	 * 
	 * */
	public void show() {
		System.out.println("name:" + this.getName() + " age:" + this.getAge());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 
	 */
	public Pet() {
		// TODO Auto-generated constructor stub
	}

	public Pet(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}

}
