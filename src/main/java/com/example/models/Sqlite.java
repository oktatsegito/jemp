package com.example.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite implements Database {

    @Override
    public Connection connect() {
        try {
            return tryConnect();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    private Connection tryConnect() throws SQLException {
        String url = "jdbc:sqlite:database.sqlite";
        return DriverManager.getConnection(url);
    }
    
}
