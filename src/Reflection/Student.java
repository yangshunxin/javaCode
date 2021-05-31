/**
 * 
 */
package Reflection;

/**
 * @author yangs
 *
 */
public class Student extends Person {
	private String workString = "learning";

	/**
	 * @param workString
	 */
	public Student(String workString) {
		super();
		this.workString = workString;
	}

	/**
	 * @return the workString
	 */
	public String getWorkString() {
		return workString;
	}

	/**
	 * @param workString the workString to set
	 */
	public void setWorkString(String workString) {
		this.workString = workString;
	}

	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nameString
	 * @param id
	 * @param age
	 */
	public Student(String nameString, int id, int age) {
		super(nameString, id, age);
		// TODO Auto-generated constructor stub
	}

}
