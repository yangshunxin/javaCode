/**
 * 
 */
package Reflection;

/**
 * @author yangs
 *
 *	类加载器的作用：
 *		将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，
 *	然后在堆中生成一个代表这个类的java.lang.class对象，作为方法区中类数据的访问入口。
 *	类缓存：
 *		标准的JavaSE类加载器可以按要求查找类，但一旦某个类被记载到类加载器中，它将维持加载（缓存）一段时间。
 *	不过JVM垃圾回收机制可以回收这些Class对象。
 *	
 *	*.java文件 通过 java编译器	变成 字节码文件*.class文件
 *	然后依次通过类装载器、字节码校验器、解释器后，运行在操作系统平台上；
 *
 *	类加载器的作用是把类class装载进内存的。JVM规范定义了如下类型的类的加载器。
 *	自定义类加载器 --》 System Classloader  --> Extension Classloader --> Bootstap ClassLoader
 *	引导类加载器（Bootstap Classloader）: 用C++编写的，是JVM自带的类加载器，负责java平台核心库，用来装载核心类库。该加载器无法直接获取。
 *	扩展类加载器（Extension Classloader）: 负责jre/lib/ext目录下的jar包或 -D Java.ext.dirs 指定目录下的jar包装入工作库。
 *	系统类加载器（System Classloader）: 负责java -classpath 或 -D Java.class.path所指的目录下的类与jar包装入工作，是最常用的加载器
 *
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		// 获取系统类的加载器
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader);

		// 获取系统类加载器的父类加载器 ---》扩展类加载器
		ClassLoader parentClassLoader = systemClassLoader.getParent();
		System.out.println(parentClassLoader);

		// 获取扩展类加载器的父类加载器 ---》 根加载器（c/C++）
		ClassLoader classLoader = parentClassLoader.getParent();
		System.err.println(classLoader);

		// 测试当前类是哪个加载器加载的
		ClassLoader classLoader2 = Class.forName("Reflection.ClassLoaderTest").getClassLoader();
		System.out.println(classLoader2);

		// 测试jdk内置的类是谁加载的
		classLoader2 = Class.forName("java.lang.Object").getClassLoader();
		System.out.println(classLoader2);

		// 获取系统类加载器可以加载的路径
		System.out.println(System.getProperty("java.class.path"));
		/**
		 * 双亲委派机制
		 * 
		 * D:\javaLearn\javaCode\bin;
		 * D:\javaLearn\javaCode\lib\commons-io-2.8.0.jar
		 * */

	}
}
