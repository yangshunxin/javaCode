/**
 * 
 */
package Reflection;

/**
 * @author yangs
 *
 */
public class Person {

	private String nameString;
	private int id;
	private int age;

	/**
	 * 
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nameString
	 * @param id
	 * @param age
	 */
	public Person(String nameString, int id, int age) {
		super();
		this.nameString = nameString;
		this.id = id;
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

	private void test() {

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

	@Override
	public String toString() {
		return "Person [nameString=" + nameString + ", id=" + id + ", age=" + age + "]";
	}

}
