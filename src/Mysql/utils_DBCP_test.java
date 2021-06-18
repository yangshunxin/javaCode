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
public class utils_DBCP_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = utils_DBCP.getConnection();

			// 区别 用问好占位符
			String sqlString = "update `users` set `name`=? where `id`=?";

			// 先预编译sql, 然后填值 执行
			statement = connection.prepareStatement(sqlString);

			// 手动参数赋值
			statement.setInt(2, 1);
			statement.setString(1, "中文");

			int i = statement.executeUpdate();
			if (i > 0) {
				System.out.println("更新成功！");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.release(connection, statement, resultSet);
		}

	}

}
