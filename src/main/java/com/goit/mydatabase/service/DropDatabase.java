package com.goit.mydatabase.service;

import com.goit.mydatabase.storage.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropDatabase {
    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP ALL OBJECTS DELETE FILES\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
