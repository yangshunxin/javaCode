/**
 * 
 */
package Mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yangs
 *
 */
public class insertTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = utils.getConnection();

			statement = connection.createStatement();

			String sqlString = "INSERT into `users`(`id`, `name`, `password`, `email`, `birthday`) VALUES (4, \"ysx\", \"1235332e\", \"ysx@139.com\", \"1990-12-22\")";

			int i = statement.executeUpdate(sqlString);
			if (i > 0) {
				System.out.println("插入成功！");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.release(connection, statement, resultSet);
		}

	}

}
