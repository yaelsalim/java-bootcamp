package topic0.singleton;

import java.sql.SQLException;

/**
 * DBConnectionDemo.java
 * 
 * Purpose: Test connection to a Database using the singleton Pattern.
 * 
 * @author Yael Salim
 *
 */

public class DBConnectionDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DBConnection singletonExample = DBConnection.getInstance();

		singletonExample.getConnection();
		
		System.out.println(singletonExample);
		
		DBConnection anotherExample = DBConnection.getInstance();
		
		anotherExample.getConnection();
		
		System.out.println(anotherExample);


	}

}
