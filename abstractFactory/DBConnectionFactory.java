package topic0.abstractFactory;

/**
 * DBConnectionFactory.java
 * 
 * This class generates connection factories.
 * 
 * @author Yael Salim
 *
 */

public abstract class DBConnectionFactory {

	public static DBConnectionFactory getDBConnectionFactory(ConnectionType connType) {

		switch (connType) {

		case RELATIONAL:

			return new RelationalDbFactory();

		case NONRELATIONAL:

			return new NonRelationalDbFactory();

		default:

			return null;
		}

	}

	public abstract DBConnection getDBConnection(DBType type);

}
