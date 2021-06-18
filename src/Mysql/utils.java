/**
 * 
 */
package Mysql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author yangs
 *
 */
public class utils {

	private static String driverString = null;
	private static String urlString = null;
	private static String usernameString = null;
	private static String passwordString = null;

	static {
		try {
			InputStream inputStream = utils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
//
//			String fileName = System.getProperty("user.dir") + "\\db.properties";
//
//			File file = new File(fileName);
//			if (file.exists()) {
//				InputStream in = new BufferedInputStream(new FileInputStream(file));
//				properties.load(in);
//			}

			driverString = properties.getProperty("driver");
			urlString = properties.getProperty("url");
			usernameString = properties.getProperty("username");
			passwordString = properties.getProperty("password");

			// 驱动只需要加载一次
			Class.forName(driverString);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	// 获取连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(urlString, usernameString, passwordString);
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
