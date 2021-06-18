/**
 * 
 */
package Mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author yangs
 *
 */
public class utils_C3P0 {

	private static ComboPooledDataSource dataSource = null;

	static {
		try {

			// 代码配置
			dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setUser("develop");
			dataSource.setPassword("develop@123");
			dataSource.setJdbcUrl(
					"jdbc:mysql://rm-uf6s8m1k8m70jpijrpo.mysql.rds.aliyuncs.com:3306/shop?useUnicode-true&amp;characterEncoding=utf8&amp;useSSL=true");

			// 可以设置很多

			// 从xml读取配置文件 创建数据源
//			dataSource = new ComboPooledDataSource("MySQL");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	// 获取连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection(); // 从数据源中获取连接
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
