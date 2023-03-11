package com.goit.mydatabase.service;

import com.goit.mydatabase.storage.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             BufferedReader reader = new BufferedReader(new FileReader("sql/populate_db.sql"))) {
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String[] queries = sb.toString().split(";");
            Statement statement = connection.createStatement();

            for (String query : queries) {
                statement.addBatch(query);
            }
            statement.executeBatch();
            statement.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
