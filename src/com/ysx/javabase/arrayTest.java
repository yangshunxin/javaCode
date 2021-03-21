/**
 * 
 */
package com.ysx.javabase;

import java.util.Arrays;

/**
 * @author yangs
 *
 */
public class arrayTest {
	public static void main(String[] args) {
		// 数组是一个变量，存储相同数据类型的一组数据
		// 声明 一个数组就是在内存空间划出一串连续的空间
		//////////////// 1//////////////////
		// 数组的用法基本步骤: 1, 2, 3
		// 1.声明数组--
		int[] a;
		// 2.分配空间
		a = new int[5];
		// 3.赋值
		a[0] = 9;

		// 1和2 合并
		int[] b = new int[7];

		// 1, 2, 3合并
		int[] c = { 1, 2, 3 };
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		// 实现冒泡算法
		int[] list = { 100, 23, 66, 30, 90, 2000, 1, 80, 5, 89, 70 };
		System.out.println("===========");
		//////////////// 2///////////////
		// 使用 arrays 进行排序
		Arrays.sort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

		///////////// 3//////////////////
		// 多维数组
		int[][] scores1 = new int[2][5];
		int[][] scores2 = new int[2][];
		int[][] scores3 = new int[][] { { 1, 2 }, { 3 } }; // 声明并赋值
		int[][] scores4 = { { 1, 2 }, { 3 } }; // 声明并赋值
	}
}
