package it.unipv.posw.careconnectpro.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnessioneSimple {
	    public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/ccp",
	                "CareConnectPro",
	                "CareConnectProPassword"
	            );

	            if (conn != null) {
	                System.out.println("✓ Connessione riuscita!");
	            }

	            conn.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

