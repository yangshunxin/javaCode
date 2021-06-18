/**
 * 
 */
package Mysql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * @author yangs
 *
 */
public class utils_DBCP {

	private static DataSource dataSource = null;

	static {
		try {
			InputStream inputStream = utils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties properties = new Properties();
			properties.load(inputStream);

			// 创建数据源
			dataSource = BasicDataSourceFactory.createDataSource(properties);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	// 获取连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	// 释放连接资源
	public static void release(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
