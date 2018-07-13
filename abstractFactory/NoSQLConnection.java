package topic0.abstractFactory;

/**
 * NoSQLConnection.java
 * 
 * @author Yael Salim
 *
 */

public class NoSQLConnection extends DBConnection {

	public NoSQLConnection() {

		this.jdbc_driver = "NOSQL";

		this.db_url = "URL";

		this.user = "YAEL";

		this.pass = "BOOTCAMP";
	}

}
