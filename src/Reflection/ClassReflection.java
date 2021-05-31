/**
 * 
 */
package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yangs
 * 
 * 通过映射的方法获取 类的 属性、方法、构造器和修饰符等
 *
 */
public class ClassReflection {
	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		Class personClass = Class.forName("Reflection.Person");

		// 获取类的名字
		System.out.println(personClass.getName()); // 包名 + 类名
		System.out.println(personClass.getSimpleName()); // 类名

		// 获取类的属性
		System.out.println("========================");
		Field[] fields = personClass.getFields(); // 只能拿到public的属性

		fields = personClass.getDeclaredFields();// 获取全部的属性
		for (Field field : fields) {
			System.out.println(field);
		}

		// 获取指定属性的值
		Field nameField = personClass.getDeclaredField("nameString");
		System.out.println(nameField);

		// 获取类的方法
		System.out.println("**************************");
		Method[] methods = personClass.getMethods(); // 获得本类和父类的 public方法
		for (Method method : methods) {
			System.out.println("getMethods: " + method);
		}

		methods = personClass.getDeclaredMethods();// 获取本类所有方法 包括private方法
		for (Method method : methods) {
			System.out.println("getDeclaredMethods： " + method);
		}

		// 获取指定方法
		// 重载
		Method getNameMethod = personClass.getMethod("getNameString", null);
		Method setNameMethod = personClass.getMethod("setNameString", String.class);
		System.out.println(getNameMethod);
		System.out.println(setNameMethod);

		// 获取指定的构造器
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Constructor[] constructors = personClass.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}

		constructors = personClass.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.err.println("*" + constructor);
		}

		// 获取指定的构造器
		Constructor declaredConstructor = personClass.getDeclaredConstructor(String.class, int.class, int.class);
		System.err.println(declaredConstructor);

	}
}
