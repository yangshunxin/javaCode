/**
 * 
 */
package com.ysx.javabase;

import java.util.Scanner;

/**
 * @author yangs
 *
 */
public class testScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.从标准输入模块输入读取信息
		Scanner sc = new Scanner(System.in);
		// 2. 调用nextInt()方法
		// int i = sc.nextInt();

		// 3. 读取一行
		String line = sc.nextLine();
		// 4. 并输出
		System.out.println(line);
		// 关闭
		sc.close();

	}

}
