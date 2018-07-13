package topic0.abstractFactory;

/**
 * NonRelationalDbFactory.java
 * 
 * This class generates non relational db connections.
 * 
 * @author Yael Salim
 *
 */

public class NonRelationalDbFactory extends DBConnectionFactory {

	@Override
	public DBConnection getDBConnection(DBType type) {

		switch (type) {

		case MONGODB:

			return new MongoDBConnection();

		case NOSQL:

			return new NoSQLConnection();

		default:

			return null;
		}

	}
}
