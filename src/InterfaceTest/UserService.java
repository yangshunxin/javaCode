/**
 * 
 */
package InterfaceTest;

/**
 * @author yangs
 *
 */
// 抽象能力--架构师
// interface 关键字， 
public interface UserService {

	// 默认是 public static final 修饰，
	// 常量
	int AGE = 15;// 一般不用

	// 接口中所有定义都是抽象的 public abstract
	void add(String name);

	void delete(String name);

	void update(String name);

	void query(String name);
}
