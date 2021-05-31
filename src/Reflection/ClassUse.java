/**
 * 
 */
package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yangs
 *
 *	通过发射 创建对象
 *
 * Method和Filed,Constructor对象都有setAccessible()方法；来关闭和打开访问安全检查
 *
 */
public class ClassUse {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// 获取 Class对象
		Class personClass = Class.forName("Reflection.Person");

		// 1. 构造一个对象, 通过Class的newInstance实例化一个对象；调用的是无参构造函数
		Person person = (Person) personClass.newInstance();
		System.out.println(person);

		// 2. 通过构造函数 创建一个对象
		Constructor construct = personClass.getDeclaredConstructor(String.class, int.class, int.class);
		Person person2 = (Person) construct.newInstance("杨顺新", 001, 20);
		System.out.println(person2);

		// 通过反射调用方法
		// 先通过反射获取方法
		Method setNameMethod = personClass.getDeclaredMethod("setNameString", String.class);
		// 调用方法
		setNameMethod.invoke(person, "xxx");
		System.out.println(person.getNameString());

		// 通过反射操作属性
		System.out.println("99999999999999999999999999999");
		java.lang.reflect.Field nameString = personClass.getDeclaredField("nameString");
		// 不能直接操作私有属性，我们需要关闭程序的安全检测
		nameString.setAccessible(true);
		nameString.set(person, "ysx2222");

		System.out.println(person);

	}

}
