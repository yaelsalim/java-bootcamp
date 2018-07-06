package topic0.abstractFactory;

import java.sql.Connection;

import topic0.builder.DBConnection.Builder;

/**
 * DBConnection.java
 * 
 * This class contains connection properties.
 * 
 * @author Yael Salim
 *
 */

public abstract class DBConnection {

	protected Connection conn;

	protected String jdbc_driver;

	protected String user;

	protected String pass;

	protected String db_url;

	public Connection getConnection() {

		System.out.println("Connecting to database...");

		System.out.println("Driver:" + jdbc_driver + " URL:" + db_url + " User:" + user + " Pass:" + pass);

		return conn;
	}

	public String getJdbc_driver() {
		return jdbc_driver;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getDb_url() {
		return db_url;
	}

}
