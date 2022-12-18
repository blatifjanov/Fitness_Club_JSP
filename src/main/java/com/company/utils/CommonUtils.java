package com.company.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonUtils {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/gym_club",
                    "postgres",
                    "root12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
