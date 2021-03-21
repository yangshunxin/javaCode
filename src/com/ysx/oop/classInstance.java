/**
 * 
 */
package com.ysx.oop;

/**
 * @author yangs
 *
 */
public class classInstance {
	// 所有java程序都以类class为组织单元
	// 关键字class定义自定义的数据类型
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 1.创建对象
		Dog dog = new Dog();
		// 2. 初始化对象
		dog.nameString = "wangcai";
		dog.furColorString = "白色";

		Dog dog2 = new Dog();
		dog2 = dog; // 将dog2的引用指向dog--
		dog2.nameString = "二狗子";
		dog2.furColorString = "黑色";

		dog = null;
		// dog2 = null;

		// 3. 使用对象
		// dog.run();
		dog2.run();

	}

}
