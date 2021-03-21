/**
 * 
 */
package com.ysx.packageTest;

// 声明包 作为Java的第一条语句
// 包名 以小写字母组成，点只能在中间，一般以组织的域名倒置；也可以以机构来做 group.algorithm.deeplearn
/**
 * 
 * java jdk 提供的基本包：
 * java.lang: 虚拟机自动引入
 * Java.util: 提供一些实用类
 * java.io: 输入与输出
 * 
 * 包的导入： import 包名.类名 import com.ysx.oop.* 导入所有的类
 * 
 * 一个类同时引用了两个来自不同包的同名类：使用时必须通过完整包名和类名来区分
 * 每个包都是独立的，顶层包不会包含子包的类
 * package和import的顺序是固定的：
 * 	1. package必须位于第一行
 * 	2. 只允许有一个package语句
 * 	3.其次是import
 * 	4.接着是类的声明
 * */

/**
 * @author yangs
 *
 */
public class packageTest {

	/**
	 * @param args
	 * 包 package的作用：
	 * 1.允许类组成较小的单元，易于找到和使用相应的文件
	 * 2.防止命名冲突，区分名字相同的类
	 * 3.有助于实施访问权控制
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
