/**
 * 
 */
package Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yangs
 *
 */
public class queryTestSafe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = utils.getConnection();

			String sqlString = "SELECT * from `users` where `name`=? and `password`=?";

			statement = connection.prepareStatement(sqlString);

			// statement.setInt(1, 1); // 有结果
			String username = "'' or '1=1'"; // sql 注入 -- 查不到
			String password = "'' or '1=1'";
			statement.setString(1, username);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
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
