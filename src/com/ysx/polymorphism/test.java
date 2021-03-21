/**
 * 
 */
package com.ysx.polymorphism;

/**
 * @author yangs
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pet p = new Pet();
		p.show();
		Dog dog = new Dog("xiaohuang", 5);
		dog.setbRegister(true);
		dog.show();
		System.out.println("===================");
		System.out.println(p);
		System.out.println(p.toString()); // 15db9742
		System.out.println(Pet.class.hashCode()); // 都是跟类有关的参数
		System.out.println(Dog.class.hashCode());
		System.out.println(p.hashCode());
		// Object
		// 返回类的全名
		System.out.println(p.getClass());
		System.out.println(p.getClass().getName());
		// 返回类的 包名
		System.out.println(p.getClass().getPackage());
		System.out.println(p.getClass().getPackage().getName());
		System.out.println("====================");

	}

}
