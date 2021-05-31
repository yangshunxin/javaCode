/**
 * 
 */
package Reflection;

/**
 * @author yangs
 *	java内存分析：
 *		堆：存放new的对象和数组，可以被所有的线程共享，不会存放对象应用
 *		栈：存放基本变量类型（包含这个基本类型的具体数值），引用对象的变量（会存放这个引用在堆里面的具体地址）
 *		方法区： 也是堆，包含所有的class和static变量，可以被所有线程共享
 *	
 *	类的加载过程：
 *		1. 类的加载Load：将.class字节码文件内容加载到内存中，并将这些静态数据转换成方法去的运行时数据结构，然后生成一个代表这个类的java.lang.Class对象
 *		2. 类的链接Link：将java类的二进制代码合并到JVM的运行状态之中的过程。
 *			a.验证：确保加载的类信息符合JVM规范，没有安全方面的问题；
 *			b.准备：正式为类变量（static）分配内存并设置类类变量默认初始值的阶段，这些内存都将在方法区中进行分配；
 *			c.解析：虚拟机常量池内的符号引用（常量名）替换为直接应用（地址）的过程。
 *		3. 类的初始化Initialize：
 *			a.执行类构造器<clinit>()方法的过程。类构造器<clinit>()方法是由编译器自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的。（类构造器是构造类信息的，不是构造该类对象的构造器）
 *			b.当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先出发其父类的初始化。
 *			c.虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确加锁和同步。
 *
 *	什么时候会发生类初始化？
 *	类的主动引用（一定会发生类的初始化）：
 *		1.当虚拟机启动，先初始化main方法所在的类
 *		2.new一个类的对象
 *		3.调用类的静态成员（除了final常量）和静态方法
 *		4.使用java.lang.reflect包的方法对类进行反射调用
 *		5.当初始化一个类，如果其父类没有被初始化，则先会初始化它的父类
 *	类的被动引用（不会发生类的初始化）：
 *		1.当访问一个静态域时，只有真正声明这个域的类才会被初始化。如：当通过子类引用父类的静态变量，不会导致子类初始化
 *		2.通过数组定义类应用，不会触发此类的初始化
 *		3.引用常量不会触发此类的初始化（常量在链接阶段就存入调用类的常量池中）
 *	
 */
public class ClassLoading {
	static {
		System.out.println("main类被加载");
	}

	public static void main(String[] args) {
		// A a = new A();
		// A a = new A();
		// A.name();

		// 不会初始化子类
		System.out.println(A.b);

		// 不会 初始化子类
		A[] aList = new A[5];
	}

}

class Father {
	static int b = 2;
	static {
		System.out.println("父类被加载");

	}

}

class A extends Father {
	static int m = 100; // 默认是0

	static {
		System.out.println("子类被加载 m = " + m);
		m = 300;
	}

	public static void name() {
		System.out.println("static func m = " + m);
	}

	public A() {
		System.out.println("实例构造器 m = " + m);
	}

}
