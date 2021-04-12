package com.example.carconfigurator.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final String ip = "192.168.2.103";
    private static final String port = "1433";
    private static final String driver = "net.sourceforge.jtds.jdbc.Driver";
    private static final String databaseTest = "Test";
    private static final String database = "CarConfigurator";
    private static final String username = "superadmin";
    private static final String password = "superadmin";
    private static final String urlTest = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+databaseTest;
    private static final String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;
    private static Connection testConnection;
    private static Connection connection;

    public static String connectToTestDatabase(){
        try {
            Class.forName(driver);
            testConnection = DriverManager.getConnection(urlTest, username,password);
            return "SUCCESS";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "ERROR";
        } catch (SQLException e) {
            e.printStackTrace();
            return "FAILURE";
        }
    }

    public static String connectToCarConfiguratorDatabase(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username,password);
            return "SUCCESS";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "ERROR";
        } catch (SQLException e) {
            e.printStackTrace();
            return "FAILURE";
        }
    }

    public static Connection getTestConnection(){
        return testConnection;
    }

    public static Connection getConnection(){
        return connection;
    }
}
