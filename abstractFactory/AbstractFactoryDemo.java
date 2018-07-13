package topic0.abstractFactory;

/**
 * AbstractFactoryDemo.java
 * 
 * Purpose: Test different types of SQL connections using the abstract factory
 * pattern.
 * 
 * @author Yael Salim
 *
 */

public class AbstractFactoryDemo {

	public static void main(String[] args) {

		DBConnectionFactory abstractFactory = DBConnectionFactory.getDBConnectionFactory(ConnectionType.RELATIONAL);

		DBConnection dbConn = abstractFactory.getDBConnection(DBType.MICROSOFT);

		dbConn.getConnection();

		DBConnectionFactory abstractFactory2 = DBConnectionFactory.getDBConnectionFactory(ConnectionType.NONRELATIONAL);

		DBConnection dbConn2 = abstractFactory2.getDBConnection(DBType.MONGODB);

		dbConn2.getConnection();
	}

}
