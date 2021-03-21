/**
 * 
 */
package com.ysx.oop;

/**
 * @author yangs
 *
 */
public class Encapsulate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 什么是封装？ 将类的某些信息隐藏在类内部，不允许外部程序直接访问，而是 通过该类提供的方法来实现对隐藏信息的操作和访问；
		 * 简单就是：隐藏内部细节，提供公开方法进行访问； 封装的两大原则： 1. 把所有的属性隐藏起来 2. 把尽可能多的东西藏起来，对外提供便捷的接口
		 * 
		 * 封装的步骤： 1.修改属性的可见性：把属性私有化（private） 2.创建公有的getter和setter方法；创建getXX和setXX方法
		 * 3.在getter/setter方法中加入属性控制语句；做逻辑判断
		 * 
		 * 
		 */
		Person person = new Person("ysx", "black");
		// person.print();
		// person.age = -10; // 这里就不对了，需要封装---private 后无法访问
		person.setAge(-10); // 这里就不对了，需要封装
		person.setAge(10);
		System.out.println(person);
		System.out.println(person.getAge());

	}

}
