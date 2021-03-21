/**
 * 
 */
package com.ysx.oop;

/**
 * @author yangs
 * 一个文件里面  只能有一个相同名称的主类
 */
public class Dog {
	// 定义属性
	String nameString; // 名字
	String furColorString; // 毛发颜色

	/**
	 * 
	 */
	public Dog() {
		// TODO Auto-generated constructor stub

	}

	public Dog(String nameString, String furColorString) {
		this.furColorString = furColorString;
		this.nameString = nameString;
	}

	public Dog(int num) {
		// TODO Auto-generated constructor stub
		System.out.println(num);
	}

	// 定义方法
	public void run() {
		System.out.println(furColorString + nameString + "在跑。。。");
	}

}
