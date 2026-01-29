package io.github.aguileramesa91.usercore.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String DATABASE_NAME ="user_core_db";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Admin123";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException e){
            throw new RuntimeException("Error connecting to database: " + e.getMessage(), e);
        }
    }
}
