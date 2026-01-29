package io.github.aguileramesa91.usercore;

import io.github.aguileramesa91.usercore.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try (Connection connection = DatabaseConfig.getConnection()){
            System.out.println("Connection established");
        } catch (SQLException e){
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
