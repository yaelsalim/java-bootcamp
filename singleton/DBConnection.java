package topic0.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection.java
 * 
 * Purpose: Create a connection to a SQL DataBase using the Singleton Pattern
 * 
 * @author Yael Salim
 */

public class DBConnection {

	private static DBConnection singletonInstance = null;

	private static Connection conn;

	private static final String JDBC_DRIVER = "Driver";

	private static final String USER = "username";

	private static final String PASS = "password";

	private static final String DB_URL = "db_url ";

	private DBConnection() {

	}

	public static DBConnection getInstance() throws ClassNotFoundException, SQLException {

		if (singletonInstance == null) {

			singletonInstance = new DBConnection();

		}
		return singletonInstance;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);

		System.out.println("Connecting to database...");

		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		return conn;
	}

}
