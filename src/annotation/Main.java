/**
 * 
 */
package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangs
 * 什么是注解？
 * 常用的 @注释名 @Override @SuppressWarnings(value="unchecked")
 * 可以用在 package class method field上，作为辅助信息；
 * 起到限定的作用， 可以通过反射机制实现对这些元数据的访问；
 * 
 * 内置注解， java常用的注解， 三个常用的内置注解：
 * @override：定义在Java.lange下，此注释只能修饰方法，表示一个方法声明打算重写父类中的另一个方法声明；
 * @Deprecated 此注释可以用于修饰方法，属性和类，表示不鼓励程序员用这个元素，通常表示很危险或者存在更好的选择；
 * @SuppressWarnings: 用来抑制编译时的警告；可以带参数 
 * 		@SuppressWarnings("all") 
 * 		@SuppressWarnings("unchecked")
 * 		@SuppressWarnings(value={"unchecked","deprecation"}) 
 * 
 * 元注解， 负责注释其他注解，共有4个meta-annotation:
 * @Target: 用于描述注释的使用范围（即描述该注释可以用在什么地方）
 * @Retention: 表示需要在什么级别保存该注释信息，用于描述注解的生命周期 （SOURCE < CLASS < RUNTIME）， 一般直接用RUNTIME
 * @Document: 说明该注释将被包含在javadoc中
 * @Inherited: 说明子类可以继承父类中的该注解
 * 
 *
 */
public class Main {

	@MyAnnotation
	@MyAnnotation2(age = 18, schools = { "", "hongangaozhong" })
	void test() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 自定义注解
@Target(value = ElementType.METHOD) // 用在方法上
@Retention(value = RetentionPolicy.RUNTIME) // 表示注释在什么地方有效，共三个值：SOURCE < CLASS < RUNTIME
@Documented // 表示 注解是否生产在Javadoc中
@Inherited // 子类可以继承父类的注释
@interface MyAnnotation { // @interface 自定义注解

}
