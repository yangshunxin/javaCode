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
public class updateTestSafe {

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
			// 关闭数据库自动提交，自动开启事务
			connection.setAutoCommit(false); // 开启事务

			String sqlString = "update `account` set `money` = `money` - 100 where `name`=\"A\"";
			statement = connection.prepareStatement(sqlString);
			statement.executeUpdate();

			String sqlString2 = "update `account` set `money` = `money` + 100 where `name`='B'";
			statement = connection.prepareStatement(sqlString2);
			statement.executeUpdate();

			// 业务完毕，提交事务
			connection.commit();
			System.out.println("transaction success!!!");

		} catch (SQLException e) {
			try {
				connection.rollback(); // 不用这句话，也会自动回滚
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.release(connection, statement, resultSet);
		}

	}

}
