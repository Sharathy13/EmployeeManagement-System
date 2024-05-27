package com.employmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection createDBConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/EmpManagement";
        String username = "root";
        String password = "admin";

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to the database failed.");
            e.printStackTrace();
        }

        return con;
    }
}
