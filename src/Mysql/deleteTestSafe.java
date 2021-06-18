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
public class deleteTestSafe {

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
			String sqlString = "DELETE FROM `users` WHERE `id` = ?";

			// 先预编译sql, 然后填值 执行
			statement = connection.prepareStatement(sqlString);

			// 手动参数赋值
			statement.setInt(1, 4);

			int i = statement.executeUpdate();
			if (i > 0) {
				System.out.println("删除成功！");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.release(connection, statement, resultSet);
		}

	}

}
