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
public class queryTest {

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

			String sqlString = "SELECT * from `users` ";

			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("password"));
				System.out.println("=============");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.release(connection, statement, resultSet);
		}

	}

}
