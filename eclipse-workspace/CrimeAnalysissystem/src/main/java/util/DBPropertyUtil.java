package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    public static String getPropertyString(String fileName) {
        Properties properties = new Properties();
        String connectionString = "";
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            properties.load(inputStream);
            // Get properties from the file
            String host = properties.getProperty("host", "localhost");  
            String dbName = properties.getProperty("dbName");
            String user = properties.getProperty("user", "root"); 
            String password = properties.getProperty("password", "welcome123");  
            String port = properties.getProperty("port", "3306");

            // Constructing the connection string
            connectionString = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?user=" + user + "&password=" + password;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connectionString;
    }
}
