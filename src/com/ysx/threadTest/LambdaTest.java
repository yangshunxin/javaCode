/**
 * 
 */
package com.ysx.threadTest;

/**
 * @author yangs
 *
 */
// 函数式接口 就是lambda表达式的关键
// 什么是函数式接口：只包含唯一一个抽象方法的接口，就是一个函数式接口； 函数式接口可以通过lambda表达式来创建该接口的对象。
// 用lambda表达式的目的就是简化代码
// 下面介绍lambda编程的简化过程

public class LambdaTest {
	// 3.静态内部类
	// 必须是static的
	static class Like2 implements ILike {

		@Override
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("I like lambda2");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 接口创建对象
		ILike like = new Like();
		like.lambda();

		like = new Like2();
		like.lambda();

		// 4. 局部内部类
		class Like3 implements ILike {

			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lambda3");
			}
		}

		like = new Like3();
		like.lambda();

		// 5. 匿名内部类， 没有类名称
		like = new ILike() {

			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lambda4");
			}
		};
		like.lambda();

		// 6. 用lambda简化
		like = () -> {
			System.out.println("I like lambda5");
		};
		like.lambda();

	}

}

// 1. 定义一个函数式接口
interface ILike {
	void lambda(); // 只有一个抽象方法

}

//2.实现类
class Like implements ILike {

	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		System.out.println("I like lambda");
	}

}