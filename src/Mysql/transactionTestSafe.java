/**
 * 
 */
package Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author yangs
 *
 */
public class transactionTestSafe {

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

			// 区别 用问好占位符
			String sqlString = "INSERT into `users`(`id`, `name`, `password`, `email`, `birthday`) VALUES (?, ?, ?, ?, ?)";

			// 先预编译sql, 然后填值 执行
			statement = connection.prepareStatement(sqlString);

			// 手动参数赋值
			statement.setInt(1, 4);
			statement.setString(2, "ysx");
			statement.setString(3, "12345653");
			statement.setString(4, "123#123.com");
			statement.setDate(5, new java.sql.Date(new Date().getTime()));

			int i = statement.executeUpdate();
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
