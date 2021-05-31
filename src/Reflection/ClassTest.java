/**
 * 
 */
package Reflection;

import java.lang.annotation.ElementType;

/**
 * @author yangs
 * 动态语言：运行时可以改变其结构的语言； object-c, C#, JavaScript, PHP, python等;
 * 静态语言: 运行时不可改变其结构的语言； 如 Java, C, C++, 但是反射能使java成为"准动态语言";
 * 
 * Reflection（反射）是java被视为动态语言的关键，反射机制允许程序在执行期间借助于Reflection API取得类的所有内部信息，并能直接操作任意对象的内部属性及方法。
 * 加载完类后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构， 
 * 
 * 反射在运行时的作用：
 * 		1.判断任意一个对象所属的类
 * 		2.构造任意一个类的对象
 * 		3.判断任意一个类所具有的成员变量和方法
 * 		4.获取泛型信息
 * 		5.调用任意一个对象的成员变量和方法
 * 		6.处理注解
 * 		7.生成动态代理
 * 优点：动态创建对象和编译，很灵活，缺点：性能比new慢十几倍；
 *
 *	java.lang.Class: 代表一个类
 *	java.lang.reflect.Method: 代表类的方法
 *	java.lang.reflect.Field: 代表类的成员变量
 *	java.lang.reflect.Constructor: 代表类的构造器
 *
 * 获取Class实例的方法：--见代码
 * 	1. Class.forName("包名.类名")
 * 	2. object中有getClass()的方法， 实例.getClass() 和 类名.Class
 * 	3. 内置类可以通过 类名.Type 
 *
 * 对于每个类，JRE都会为其保留一个不变的Class类型的对象，该对象这样理解：
 * 		Class本身也是一个类
 * 		Class对象只能由系统建立对象
 * 		一个加载的类在JVM中只会有一个Class实例
 *  	一个Class对象对应的是一个加载到JVM中的一个.class文件
 *  	每个类的实例都会记得自己是由哪个Class实例所生成
 *  	通过Class可以完整地得到一个类中的所有被加载的结构
 *  	Class类是Reflecion的根源，针对任何动态加载和运行的类，只有首先获取对应的Class对象
 *
 *	哪些类型可以有class对象：--见代码
 *		class：外部类，成员（成员内部类和静态内部类），局部内部类，匿名内部类
 *		interface: 接口
 *		[]: 数组
 *		enum: 枚举
 *		annotation: 注解@interface
 *		primitive type: 基本数据类型
 *		void
 *
 */
public class ClassTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// 通过反射获取Class对象
		// 1. 通过包名获取
		Class cUserClass = Class.forName("Reflection.Student");
		Class cUserClass1 = Class.forName("Reflection.Student");
		System.out.println(cUserClass.hashCode());
		System.out.println(cUserClass1.hashCode()); // hashCode相同，说明是同一个东西
		System.out.println(cUserClass);

		// 2. 通过实例获取
		Student student = new Student();
		Class cUserClass2 = student.getClass();
		System.out.println(cUserClass2);

		// 3. 通过类名.class获得
		Class cUserClass3 = Student.class;
		System.out.println(cUserClass3);

		// 只有内置类型才可以用
		Class intClass = Integer.TYPE;
		System.out.println(intClass);

		// 获取父类
		Class fatherClass = cUserClass.getSuperclass();
		System.err.println(fatherClass);

		System.out.println("==============================");
		System.out.println("所有类型的class");
		Class class1 = Object.class; // 实例获取Class
		Class class2 = Comparable.class; // 接口获取Class
		Class class3 = String[].class; // 数组获取Class
		Class class4 = int[][].class; // 二位数组获取Class
		Class class5 = Override.class; // 注解获取Class
		Class class6 = ElementType.class; // 枚举获取Class
		Class class7 = Integer.class; // 基本数据类型获取Class
		Class class8 = Void.class; // void获取Class
		Class class9 = Class.class; // Class获取Class

		System.out.println(class1);
		System.out.println(class2);
		System.out.println(class3);
		System.out.println(class4);
		System.out.println(class5);
		System.out.println(class6);
		System.out.println(class7);
		System.out.println(class8);
		System.out.println(class9);
	}

}
