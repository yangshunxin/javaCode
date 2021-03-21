/**
 * 
 */
package com.ysx.javabase;

/**
 * @author yangs
 *
 */
public class calculate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 基本算术运算符 + - * / %
		// 符合算数运算符 ++ -- += -+ *= /=
		// 关系运算符： == != > < >= <=
		// 逻辑运算符：&& || !
		// 条件运算符： 条件 ？表达式1：表达式2
		System.out.println(10 + 3);
		System.out.println(10 - 3);
		System.out.println(10 * 3);
		System.out.println(10 / 3);
		System.out.println(10 % 3);
		int a = 10;
		System.out.println((a++) + (++a));
		a += 1;
		a -= 1;
		System.out.println(a);

		int b = 10;
	}

}
