package com.example.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mariadb implements Database {

    private String host = "localhost";
    private String port = "3306";
    private String name = "bama";
    private String user = "bama";
    private String pass = "titok";

    @Override
    public Connection connect() {
        try {
            return tryConnect();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private Connection tryConnect() throws SQLException {
        String url = "jdbc:mariadb://" + host + ":" + port + "/" + name;
        return DriverManager.getConnection(url, user, pass);
    }
    
}
