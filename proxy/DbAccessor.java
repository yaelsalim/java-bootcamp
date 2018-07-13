package topic0.proxy;

import java.sql.*;
import java.util.Date;

/**
 * DbAccessor.java
 * 
 * Purpose: Database accessor class.
 * 
 * @author Yael Salim
 *
 */

public class DbAccessor {

	private ConnectionFactory connfactory = null;

	private String user;

	private String pass;

	public DbAccessor(String user, String pass) {

		System.out.println("Creating proxy at " + new Date());

		this.user = user;

		this.pass = pass;
	}

	public String dbProxyAccess(String sql) throws ClassNotFoundException, SQLException {

		if (connfactory == null) {

			System.out.println("Creating new access at " + new Date());

			connfactory = new ConnectionFactory(user, pass);

		}

		return sql;

	}

}
