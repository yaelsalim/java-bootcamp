package topic0.abstractFactory;

/**
 * MicrosoftServerSQLConnection.java
 * 
 * @author Yael Salim
 *
 */

public class MicrosoftServerSQLConnection extends DBConnection {

	public MicrosoftServerSQLConnection() {

		this.jdbc_driver = "MICROSOFT";

		this.db_url = "URL";

		this.user = "YAEL";

		this.pass = "BOOTCAMP";
	}

}
