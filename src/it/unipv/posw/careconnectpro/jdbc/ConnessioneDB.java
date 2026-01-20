package it.unipv.posw.careconnectpro.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnessioneDB {

    private static final String FILE_PROPERTIES_DB = "properties/db.properties";

    private static final String PROPERTYDBDRIVER = "DBDRIVER";
    private static final String PROPERTYDBURL = "DBURL";
    private static final String PROPERTYNAME = "DBUSER";
    private static final String PROPERTYPSW = "DBPSW";

    private static String username;
    private static String password;
    private static String dbDriver;
    private static String dbURL;



    private static void init() {

        if (username != null) return;

        Properties p = new Properties();

        try (FileInputStream fis = new FileInputStream(FILE_PROPERTIES_DB)) {
            p.load(fis);
            username = p.getProperty(PROPERTYNAME);
            password = p.getProperty(PROPERTYPSW);
            dbDriver = p.getProperty(PROPERTYDBDRIVER);
            dbURL = p.getProperty(PROPERTYDBURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static Connection startConnection(String schema) {

        init();

        try {
            Class.forName(dbDriver);
            String newDbUrl = String.format(dbURL, schema);
            Connection conn = DriverManager.getConnection(newDbUrl, username, password);
            conn.setAutoCommit(true);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}