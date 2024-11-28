package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Static connection variable
    private static Connection connection = null;

    // Static method to get the database connection
    public static Connection getConnection() throws SQLException {
        // Fetch the connection string from DBPropertyUtil
        String connectionString = DBPropertyUtil.getPropertyString("src/main/java/db.properties");

        if (connection == null) {
            try {
                // Establish the connection to the database using the connection string
                connection = DriverManager.getConnection(connectionString);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new SQLException("Connection failed. Check your DB credentials or network.");
            }
        }
        return connection;
    }
}
