package com.example.oopcoursework;

import java.sql.*;

public class Utils {
    public static String dbUrl = "jdbc:postgresql://localhost:5432/Events";
    public static String dbUser = "postgres";
    public static String dbPass = "1111";


    public static void execubeDB(String query) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            Statement stmt = conn.createStatement();
            stmt.execute(query);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeDBQuery(String query) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
