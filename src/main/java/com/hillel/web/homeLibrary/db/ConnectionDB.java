package com.hillel.web.homeLibrary.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionDB {

    public static Connection getConnection() throws SQLException/*, IOException*/ {

        String url = "jdbc:mysql://localhost:3306/hillel?allowPublicKeyRetrieval=true&useSSL=false";

        Properties properties = new Properties();

        properties.put("user", "root");
        properties.put("password", "qw0415LK");
        properties.put("useSSL", "false");
        properties.put("serverTimezone", "UTC");
        properties.put("characterEncoding", "UTF-8");
        return DriverManager.getConnection(url, properties);
    }

}
