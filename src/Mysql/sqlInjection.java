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
public class sqlInjection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// username = '' or '1=1' password = '' or '1=1''
//		String sqlString = "select * from `users` where `name`= '' or '1=1' and `password` ='' or '1=1'";
//		select(sqlString);

		String username = "'' or '1=1'"; // sql 注入
		String password = "'' or '1=1'";
		select2(username, password);

	}

	public static void select(String sqlString) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = utils.getConnection();

			statement = connection.createStatement();

			// String sqlString = "SELECT * from `users` ";

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

	public static void select2(String usernameString, String passwordString) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = utils.getConnection();

			statement = connection.createStatement();

			String sqlString = "SELECT * from `users` where `name`= " + usernameString + " and `password` = "
					+ passwordString;

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
