/**
 * 
 */
package com.ysx.polymorphism;

/**
 * @author yangs
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 什么是多态？
	 * 同一个引用类型，使用不同的实例，而执行不同的操作；
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elephant elephant = new Elephant("小飞象");
		Dog dog = new Dog("小黄");
		Tiger tiger = new Tiger("小虎");

		// 父类引用指向 子类对象
		Pet pet = new Elephant("小飞象");

		// 这里Person构造函数参数的类型是：Pet, 传入的是子类实例：elephant,dog,tiger;
		// 当父类作为返回值，也可以返回子类对象实例，
		Person person = new Person("王思聪", pet);
		person.feed();
		// tiger.enjoy();
		// instanceof 后面的类必须与前面的实例有上下级关系
		// System.out.println(elephant instanceof Test);
		System.out.println(elephant instanceof Pet);
		System.out.println(elephant instanceof Elephant);

	}

}
