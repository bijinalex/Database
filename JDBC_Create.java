import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBC_Create {
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

            System.out.println("Creating database...");
            statement = con.createStatement();

            String sql = "CREATE DATABASE student25";
            boolean result = statement.execute(sql);
            System.out.println("Database created successfully: " + !result); // result is false if DDL success

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}