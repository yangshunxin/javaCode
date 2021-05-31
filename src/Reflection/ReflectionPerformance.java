/**
 * 
 */
package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yangs
 *
 */
public class ReflectionPerformance {

	// 普通方式
	public static void test01() {

		long startTime = System.currentTimeMillis();

		Person person = new Person();
		for (int i = 0; i < 1000000000; i++) {
			person.getNameString();
		}

		long endTime = System.currentTimeMillis();

		System.out.println("普通方式调用方法10亿次花时间：" + (endTime - startTime) + "ms");

	}

	// 反射方式
	public static void test02() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		long startTime = System.currentTimeMillis();

		Person person = new Person();
		Class personClass = Class.forName("Reflection.Person");
		Method getNameStringMethod = personClass.getDeclaredMethod("getNameString", null);

		for (int i = 0; i < 1000000000; i++) {
			// person.getNameString();
			getNameStringMethod.invoke(person, null);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("反射方式调用方法10亿次花时间：" + (endTime - startTime) + "ms");

	}

	// 反射方式 关闭权限检测
	public static void test03() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		long startTime = System.currentTimeMillis();

		Person person = new Person();
		Class personClass = Class.forName("Reflection.Person");
		Method getNameStringMethod = personClass.getDeclaredMethod("getNameString", null);
		getNameStringMethod.setAccessible(true);
		for (int i = 0; i < 1000000000; i++) {
			// person.getNameString();
			getNameStringMethod.invoke(person, null);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("反射去掉权限方式调用方法10亿次花时间：" + (endTime - startTime) + "ms");

	}

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		test01();
		test02();
		test03();
	}

}
