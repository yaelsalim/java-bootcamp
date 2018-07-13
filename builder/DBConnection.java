package topic0.builder;


import java.sql.Connection;

/**
 * DBConnection.java
 * 
 * Purpose: Create a connection to a SQL DataBase using the Builder Pattern
 * 
 * @author Yael Salim
 */

public class DBConnection {

	public static class Builder {

		private String jdbc_driver ;

		private String user ;

		private String pass ;

		private String db_url ;
		
		public Builder() {
			
		}
		
		public DBConnection build() {
			
			return new DBConnection(this);
		}

		public Builder setJdbc_driver(String jdbc_driver) {
			
			this.jdbc_driver = jdbc_driver;
			
			return this;
		}

		public Builder setUser(String user) {
			
			this.user = user;
			
			return this;
		}

		public Builder setPass(String pass) {
			
			this.pass = pass;
			
			return this;
		}

		public Builder setDb_url(String db_url) {
			
			this.db_url = db_url;
			
			return this;
		}
			
	}
	
	private Connection conn;

	private final String jdbc_driver ;

	private final String user ;

	private final String pass ;

	private final String db_url ;

	private DBConnection(Builder builder) {
		
		this.jdbc_driver = builder.jdbc_driver;
		
		this.db_url = builder.db_url;
		
		this.user = builder.user;
		
		this.pass = builder.pass;
	}

	public Connection getConnection() {

		System.out.println("Connecting to database...");

		System.out.println("Driver:"+jdbc_driver+" URL:"+db_url+" User:"+user+" Pass:"+pass);

		return conn;
	}

	public String getJdbc_driver() {
		return jdbc_driver;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getDb_url() {
		return db_url;
	}

}
