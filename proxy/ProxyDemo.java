package topic0.proxy;

import java.sql.SQLException;

/**
 * ProxyDemo.java
 * 
 * Purpose: Test Proxy Pattern Example.
 * 
 * @author Yael Salim
 *
 */

public class ProxyDemo {

	public static void main(String[] args) {

		DbAccessor proxy = new DbAccessor("user1", "pass1");

		GetConnection directConn = GetConnection.getInstance();

		try {

			directConn.getConnection("user2", "pass2", "driver2", "dburl2");

			System.out.println(proxy.dbProxyAccess("SELECT * FROM A "));

			System.out.println(proxy.dbProxyAccess("SELECT * FROM B" ));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
