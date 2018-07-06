package topic0.abstractFactory;

/**
 * OracleSQLConnection.java
 * 
 * @author Yael Salim
 *
 */

public class OracleSQLConnection extends DBConnection {

	public OracleSQLConnection() {

		this.jdbc_driver = "ORACLE";

		this.db_url = "URL";

		this.user = "YAEL";

		this.pass = "BOOTCAMP";

	}

}
