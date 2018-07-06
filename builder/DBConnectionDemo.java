package topic0.builder;

/**
 * DBConnectionDemo.java
 * 
 * Purpose: Test connection to a database using the Builder Pattern
 * 
 * @author Yael Salim
 *
 */

public class DBConnectionDemo {
	
    public static void main (String args[]) {
    	
	DBConnection.Builder builder = new DBConnection.Builder();
	
	builder.setJdbc_driver("JDBC").setDb_url("URL").setUser("Yael").setPass("BootCamp");
	
	DBConnection conn = builder.build();
	
	conn.getConnection();
	
    }
}
