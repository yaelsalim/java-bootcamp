package topic0.proxy;

import java.sql.SQLException;
import java.util.Date;

/**
 * GetConnection.java
 * 
 * Purpose: Represents a DB connection.
 * 
 * @author Yael Salim
 *
 */

public class GetConnection {

	private static GetConnection getConnection = null;

	private GetConnection() {
	}

	public static GetConnection getInstance()

	{
		if (getConnection == null)

			getConnection = new GetConnection();

		return getConnection;

	}

	public void getConnection(String user, String pass, String driver, String dburl) throws SQLException, ClassNotFoundException {

		System.out.println("Connecting to database...");

		System.out.println("User: " + user + " connected at: " + new Date() + " dburl:" + dburl);

	}

}
