/**
 * 
 */
package com.ysx.oop;

/**
 * @author yangs
 *
 */
public class baseClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("红楼梦");
		System.out.println(b1.getName());
		/*
		 * 输出结果： person name: lisi book name: 红楼梦
		 */
		// 方法的重载：
		// 1.同一个类中，方法名相同，
		// 2.参数和类型不同，
		// 3.与返回值和修饰符无关(如果返回值或者修饰符有区别，其它的地方都相同，属于方法重复)；
		// 上述输出说明： 类是先初始化静态变量，再初始化实例变量，最后初始化类的构造方法；

		// 成员变量和局部变量：
		/**
		 * 作用域不同：
		 * 		局部变量的作用域仅限于定义它的方法；
		 * 		成员变量的作用域再整个类内部都是可见的；
		 * 初始值不同：
		 * 		Java会给成员变量一个初始值
		 * 		Java不会给局部变量赋予初始值(null)
		 * 
		 * */
		// 静态变量： 用static, 属于类 不进行实例化对象，用类名就能调用
		System.out.println(Book.p3.getName());
	}

}

class Book {
	String nameString;
	PersonLocal p1 = new PersonLocal("lisi");
	PersonLocal p2 = new PersonLocal("王五");
	static PersonLocal p3 = new PersonLocal("杨六"); // 先初始化静态的 变量

	/**
	 * 
	 */
	public Book(String nameString) {
		// TODO Auto-generated constructor stub
		System.out.println("book name: " + nameString);
	}

	/**
	 * 
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return this.nameString;
	}

	public void getName2() {
		System.out.println(nameString);
	}
}

class PersonLocal {
	String nameString;

	/**
	 * 
	 */
	public PersonLocal(String namString) {
		// TODO Auto-generated constructor stub
		this.nameString = namString;
		System.out.println("person name: " + this.nameString);
	}

	public String getName() {
		return this.nameString;
	}
}
