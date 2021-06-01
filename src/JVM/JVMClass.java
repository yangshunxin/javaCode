/**
 * 
 */
package JVM;

import java.util.Random;

/**
 * JVM 学习
 * 1. 请谈谈你对JVM的理解，Java8虚拟机和之前的变化？
 * 2. 什么是OOM，什么是栈溢出StackOverFlowError? 怎么分析？
 * 3. JVM的常用调优参数有哪些？
 * 4. 内存快照如何抓取，怎么分析dump文件？
 * 5. 谈谈JVM中，你对类加载器的认识？
 * 引申出来十个问题：
 * 	1. JVM的位置：JVM是位于操作系统之上的应用程序。
 * 	2. JVM的体系架构：
 * 		.java-》.class文件-》 类加载器（class loader，类都加载在堆中和方法区中） -> 运行时数据区：方法区（Method Area）, java栈，堆（heap）, 本地方法栈;
 * 		本地方法栈对应操作系统的本地方法接口和本地方法库，还有一个执行引擎来管理；
 * 	3. 类加载器
 * 		每个类在堆中都都有要给模块Class,实例化对象时就是在Class的基础上进行实例化。
 * 		启动类加载器：java无法获取, C/C++实现
 * 		扩展类加载器：ExtendClassLoader，继承自classLoader
 * 		应用程序加载器：AppClassLoader，继承自classLoader
 * 	4. 双亲委派机制： 安全
 * 		类加载器之间的关系称为 双亲委派机制；
 * 		双亲委派模型过程：如果一个类加载器收到了类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器去完成，每一个层次的加载器都是如此，因此所有的类加载请求都会传给顶层的启动类加载器，
 * 		只有当父加载器反馈自己无法完成该加载请求（该加载器的搜索范围中没有找到对应的类）时，子加载器才会尝试自己去加载。
 * 		例如类java.lang.Object，它存在在rt.jar中，无论哪一个类加载器要加载这个类，最终都是委派给处于模型最顶端的Bootstrap ClassLoader进行加载，
 * 		因此Object类在程序的各种类加载器环境中都是同一个类。
 * 		相反，如果没有双亲委派模型而是由各个类加载器自行加载的话，如果用户编写了一个java.lang.Object的同名类并放在ClassPath中，那系统中将会出现多个不同的Object类，程序将混乱。
 * 
 * 	5. 沙箱安全机制：
 * 		沙箱就是一个限制程序运行的环境。限制代码对本地资源的访问。
 * 	6. Native
 * 		java调用本地C代码进行互相操作的API，称为Java Native Interface(java本地接口，JNI), native表示调用C方法
 * 
 * 	7. PC寄存器
 * 		每个线程都有一个程序计数器，是线程私有的，就是一个指针，指向方法区中的方法字节码；
 * 	8. 方法区（Method Area）---特殊的堆：static, final, Class, 常量池
 * 		方法区是被所有线程共享；所有字段、方法和一些特殊方法，如构造函数、接口代码也在此定义，即 所有定义的方法的信息都保存在该区域，此区域属于共享区间；
 * 		静态变量、常量、类信息（构造方法，接口定义）、运行时常量池存放在方法区中，但是实例变量存放在堆内存中，和方法区无关；		
 * 
 * 	9. 栈： 数据结构
 * 		栈内存管理程序的运行，每次函数调用都会将调用函数的栈指针压倒被调用函数的栈的底部，然后在被调函数执行完毕，会弹出底部调用函数的指针，让调用函数继续执行下面的语句；
 * 		故递归调用会出现栈溢出(StackOverflow Error) ；栈中无垃圾
 * 		栈中存放的内容：8大基本类型 + 对象引用 + 实例的方法
 * 
 * 	10. 三种JVM
 * 		SUN公司 HotSpot
 * 		BEA JRockit
 * 		IBM J9 VM	
 * 
 * 	11. 堆
 * 		Heap, 一个JVM只有一个堆内存，堆内存的大小是可以调节的。
 * 		类加载器读取了类文件后，一般会把什么东西放在堆中？ 类、方法、常量、变量~、保存引用类型的真实对象；
 * 		堆内存分为三个区域：
 * 			1.新生区（伊甸园区，幸存0区和幸存1区） Young/New
 * 			2.养老区 old
 * 			3.永久存储区 Perm
 * 		堆内存满了，报错OOM：java.lang.OutOfMemoryError: java heap space;
 * 		jdk8以后 永久存储区变成了元空间；
 * 
 *  12. 新生区、老年区
 *  	新生区：
 *		  	伊甸园区（Eden space）：所有的对象都是在伊甸园区new出来的； 
 *		 	幸存0区和幸存1区：每次gc扫描的时候，无数据的区为0区，每次扫描会把伊甸园区中活下来 和 幸存1区中活下来的内容 复制到 幸存0区；
 *		老年区：当幸存区中的实例，被扫描一定次数（可以设置）后还存活 就保存到老年区；
 *
 *  	经研究，99%的对象都是临时对象，生死都在伊甸园区；
 *  
 *  13. 永久区
 *  	这个区域常驻内存，用来存放JDK自身携带的Class对象。Interface元数据，存储的是java运行时的一些环境或类信息~，这个区域不存在垃圾回收。
 *  	jdk1.6之前： 永久代，常量池是在方法区；
 *  	jsd1.7	 ： 永久代，但是慢慢退化了，去永久代，常量池在堆中；
 *  	jsd1.8之后： 无永久代，常量池在元空间；
 *  14. 堆内存调优
 *  	当出现 OOM时，解决办法：
 *  	a. 获取内存快照，分析内存快照的工具，eclipse用MAT， IDEA用Jprofiler
 *  	b. 一行一行debug
 *  
 *  	jvm保存dump文件的方法： java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/log/abc/
 *  	MAT的使用与安装： https://www.cnblogs.com/loong-hon/p/10475143.html
 *  	MAT，Jprofiler作用：
 *  		a.分析Dump文件，快速定位内存泄露
 *  		b.获取堆中的数据
 *  		c.获取大的对象
 *  
 *  15. GC常用算法
 *  	GC分为： 轻GC(普通GC)和重GC（全局GC）
 *  	堆的类型：
 *  		新生区：
 *  			伊甸园（Eden space）
 *  			幸存0/1区(动态转换)--from/to: to一定是空的
 *  		养老区：
 *  			重GC才会操作养老区
 *  	标记清除法，标记压缩，复制算法，引用计数器
 *  	1.引用计数器：记录每个对象的引用个数，每个对象都有个计数器，GC检查到对象计数为0，就清除这个对象对应的空间，计数本身消耗内存；
 *  	2.复制算法：
 *  		谁空谁是to，GC的两步： 
 *  			1.每次GC都讲Eden中活的对象移到幸存区中，一旦Eden区被GC后，就会为空；
 *  			2.每次GC都会将from区复制到to区，复制前to区为空，复制后from区为空，此时from区为下次的to区；
 *  			3.每一个对象经历了15次GC，都没有死，就可以移到老年区，-XX:MaxTenuringThreshold=15，来设置这个参数
 *  		好处：没有内存碎片，坏处：浪费内存空间，多了一半空间，to永远为空；
 *  		复制算法的最佳使用场景：对象存活度较低的时候
 *  	3.标记清除法：
 *  		扫描堆中的对象，对活着的对象进行标记，对没有标记的对象进行清除；
 *  		优点：不需要额外的内存；
 *  		缺点：扫描内存对象，严重浪费时间，会产生内存碎片；		
 *  	4.标记压缩：
 *  		在标记清除算法基础上优化，防止内存碎片；在标记清除法的后面多了一步，向内存的一端移动活着的对象；
 *  
 *  	总结：
 *  		内存效率：复制算法 > 标记清除算法 > 标记压缩方法 (时间复杂度)
 *  		内存整齐度：复制算法 = 标记压缩算法 > 标记清除算法
 *  		内存利用率：标记压缩算法 = 标记清除算法 > 复制算法 
 *  		算法调优：
 *  		年轻代：
 *  			存活率低，适合用复制算法
 *  		老年代：
 *  			区域大：存活率高，适合标记清楚（内存碎片不是很多） + 标记压缩混合 实现
 *  
 *  16. JMM
 *   
 * 
 * 
 *
 *
 *
 *
 *
 */
public class JVMClass {

	public static String string = "fafafa";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 模拟 堆溢出
		OutOfMemorySimulation();

		// 模拟栈溢出 StackOverflowError
		// a();

		// 返回虚拟机试图使用的最大内存
		long max = Runtime.getRuntime().maxMemory();// 字节
		// 返回jvm 的总内存
		long total = Runtime.getRuntime().totalMemory(); // 字节

		System.out.println("max = " + max + "字节\t" + (max / (double) 1024 / 1024) + "MB");
		System.out.println("total = " + max + "字节\t" + (total / (double) 1024 / 1024) + "MB");

		/**
		 * 默认情况下，分配的总内存 是电脑内存的 1/4; 初始化内存是 1/64， 可调
		 * 
		 * -Xms1024m -Xmx1024m -XX:+PrintGCDetails
		 * 
		 * 
		 * */

	}

	// 模拟堆溢出 OOM
	public static void OutOfMemorySimulation() {
		while (true) {
			string += string + new Random().nextInt(888888) + new Random().nextInt(9999999);
		}
	}

	// 模拟栈溢出 StackOverflowError
	public static void a() {
		b();
	}

	public static void b() {
		a();
	}

}
