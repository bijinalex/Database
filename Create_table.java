import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_table {
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost:3306/";
	    static final String USER = "Zaza";
	    static final String PWD = "Bijin232006";

	    public static void main(String[] args) {
	        Connection con = null;
	        Statement statement = null;
	        
	        try {
	            // Register JDBC driver
	            Class.forName(JDBC_DRIVER);

	            System.out.println("Connecting to database...");
	            con = DriverManager.getConnection(DB_URL, USER, PWD);

	        
	        System.out.println("Creating table...");
	        statement = con.createStatement();
	        
	        String sql = "Create table user" +
	        "(roll_number integer not null , " +
	        	   "first_name varchar(50), " +
	        "last_name varchar (50), " +
	        		"age integer," +
	        "primary key (roll_number))";
	        
	        int i = statement.executeUpdate(sql);
	        System.out.println("Table created ,"+"value of i="+i);
	    }
	    catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
	    catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
	    
	        
	    }
}
