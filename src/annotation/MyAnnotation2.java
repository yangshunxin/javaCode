/**
 * 
 */
package annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
/**
 * @author yangs
 * 自定义注解
 *
 */
public @interface MyAnnotation2 {
	// 如果只有一个值，定义为value, 那么在使用的时候就不用带参数名，默认就是value

	// 注释的参数： 参数类型 参数名();

	String name() default "ysx";

	int age() default 0;

	int id() default -1; // -1表示找不到

	String[] schools();
}
