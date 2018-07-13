package topic0.abstractFactory;

/**
 * RelationalDbFactory.java
 * 
 * This class generates relational sql connections.
 * 
 * @author Yael Salim
 *
 */

public class RelationalDbFactory extends DBConnectionFactory {

	@Override
	public DBConnection getDBConnection(DBType type) {

		switch (type) {

		case MICROSOFT:

			return new MicrosoftServerSQLConnection();

		case ORACLE:

			return new OracleSQLConnection();

		default:

			return null;
		}

	}

}
