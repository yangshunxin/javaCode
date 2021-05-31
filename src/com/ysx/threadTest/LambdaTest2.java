package com.ysx.threadTest;

public class LambdaTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 匿名内部内
		ILove iLove = new ILove() {

			@Override
			public void love(int a) {
				// TODO Auto-generated method stub
				System.out.println("I Love You --->" + a);
			}
		};
		iLove.love(123);

		// lambda表达式
		iLove = (int a) -> {
			System.out.println("I Love You --->" + a);
		};
		iLove.love(520);

		// 简化1. 去掉 参数类型
		iLove = (a) -> {
			System.out.println("I Love You --->" + a);
		};
		iLove.love(521);

		// 简化2. 去掉阔含---只有一个参数才能去掉
		iLove = a -> {
			System.out.println("I Love You --->" + a);
		};
		iLove.love(523);

		// 简化3. 去掉花括号--只有一句实现才能去掉
		iLove = a -> System.out.println("I Love You --->" + a);
		iLove.love(524);

		/**
		 * 1.lambda表达式只能有一行代码的情况才能去掉花阔号；
		 * 2.多个参数，不能去掉括号，单可以去掉类型；
		 * 
		 * */

	}

}

interface ILove {
	void love(int a); // 带参数的
}