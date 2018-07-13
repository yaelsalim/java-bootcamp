package topic0.abstractFactory;

/**
 * MongoDBConnection.java
 * 
 * @author Yael Salim
 *
 */

public class MongoDBConnection extends DBConnection {
	
	public MongoDBConnection () {
		
		this.jdbc_driver = "MONGODB";
		
		this.db_url = "URL";
		
		this.user = "YAEL";
		
		this.pass = "BOOTCAMP";
	}

}
