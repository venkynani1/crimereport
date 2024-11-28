package util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getPropertyString(String fileName) {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(fileName);
            props.load(fis);
            String host = props.getProperty("localhost");
            String port = props.getProperty("3306");
            String dbName = props.getProperty("hexaware");
            String username = props.getProperty("root");
            String password = props.getProperty("welcome123");

            return "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?user=" + username + "&password=" + password;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
