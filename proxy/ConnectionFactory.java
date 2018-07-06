package topic0.proxy;

import java.sql.*;

/**
 * ConnectionFactory.java
 * 
 * Purpose: Creates a connection.
 * 
 * @author Yael Salim
 *
 */

public class ConnectionFactory {

	private static final String JDBC_DRIVER = "Driver";

	private static final String DB_URL = "db_url ";

	private GetConnection getconn = null;

	public ConnectionFactory(String user, String pass) {

		try {

			createConnection(user, pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createConnection(String user, String pass) throws ClassNotFoundException, SQLException {

		getconn = GetConnection.getInstance();

		getconn.getConnection(user, pass, JDBC_DRIVER, DB_URL);

	}

}
