package com.goit.mydatabase.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:./dbhw5");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Database getInstance() {
        return INSTANCE;
    }
    public Connection getConnection() {
        return connection;
    }
}
