/**
 * 
 */
package Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author yangs
 *	java采用泛型擦除的机制引入泛型，java的泛型只给javac使用，确保安全和免去强制类型转换，一旦编译完成，所有和泛型相关的类型都被擦除；
 *	
 *	ParameterizedType: 表示一种参数化类型， 比如 Collection<String>
 *	GenericArrayType: 表示一种元素类型是参数化类型或者类型变量的数组类型
 *	TypeVariable:	是各种类型变量的公共父接口
 *	WildcardType:	代表一种通配符类型的表达式
 *
 *
 */
public class ReflectionGeneric {

	// 参数是泛型
	public void test01(Map<String, Person> map, List<Person> list) {
		System.out.println("test01");
	}

	// 返回值是泛型01
	public Map<String, Person> test02() {
		System.out.println("test02");
		return null;
	}

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Method method = ReflectionGeneric.class.getMethod("test01", Map.class, List.class);

		Type[] genericParameterTypes = method.getGenericParameterTypes();
		for (Type genericParameterType : genericParameterTypes) {
			System.out.println("&" + genericParameterType);
			if (genericParameterType instanceof ParameterizedType) {
				Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
				for (Type actualTypeArgument : actualTypeArguments) {
					System.out.println(actualTypeArgument);
				}
			}
		}

	}

}
