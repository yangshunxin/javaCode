/**
 * 
 */
package Reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @author yangs
 *	ORM: Object relationship Mapping ----对象关系映射
 *		1.类和表结构对应
 *		2.属性和字段对应
 *		3.对象和记录对应
 *	利用注释和反射完成类和表结构的映射关系
 *
 *
 */
public class ReflectionAnnotation {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		// TODO Auto-generated method stub
		Class class1 = Class.forName("Reflection.Student2");

		// 通过反射获取注解
		Annotation[] annotations = class1.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
		// 获取注解value的值
		TableYsx tableYsx = (TableYsx) class1.getAnnotation(TableYsx.class);
		String valueString = tableYsx.value();
		System.out.println(valueString);

		// 获取属性的注解和值
		// 先获取属性
		Field f = class1.getDeclaredField("nameString");
		// 然后通过属性 获取注解
		FieldYsx fieldYsx = f.getAnnotation(FieldYsx.class);
		// 获取注解的值
		System.out.println(fieldYsx.columnName());
		System.out.println(fieldYsx.type());
		System.out.println(fieldYsx.length());

	}

}

@TableYsx("db_student")
class Student2 {
	@FieldYsx(columnName = "db_id", type = "int", length = 10)
	private int id;
	@FieldYsx(columnName = "db_age", type = "int", length = 10)
	private int age;
	@FieldYsx(columnName = "db_name", type = "varchar", length = 3)
	private String nameString;

	/**
	 * 
	 */
	public Student2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param age
	 * @param nameString
	 */
	public Student2(int id, int age, String nameString) {
		super();
		this.id = id;
		this.age = age;
		this.nameString = nameString;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the nameString
	 */
	public String getNameString() {
		return nameString;
	}

	/**
	 * @param nameString the nameString to set
	 */
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", nameString=" + nameString + "]";
	}
}

// 类名的注解，对应数据库的表
@Target(ElementType.TYPE) // 修饰类
@Retention(RetentionPolicy.RUNTIME)
@interface TableYsx {
	String value();// 类名
}

//属性的注解
@Target(ElementType.FIELD) // 修饰属性
@Retention(RetentionPolicy.RUNTIME)
@interface FieldYsx {
	String columnName();

	String type();

	int length();

}
