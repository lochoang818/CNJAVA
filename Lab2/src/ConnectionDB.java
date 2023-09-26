import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String url = "jdbc:mysql://localhost:3306/ProductManagement?useSSL=false";
    private static final String userName = "root";
    private static final String passWord = "123456";

    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            c = DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception for debugging purposes
        }
        return c;
    }
}

