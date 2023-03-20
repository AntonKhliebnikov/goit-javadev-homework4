package com.goit.mydatabase.service;

import com.goit.mydatabase.entity.Client;
import com.goit.mydatabase.storage.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public long create(String name) {
        Client client = new Client();
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO client (id, name) VALUES (?, ?)");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM client")) {

            if (rs.next()) {
                long maxId = rs.getLong(1);
                client.setId(maxId + 1);
                client.setName(name);
            }

            if (name.length() >= 2 && name.length() <= 1000) {
                ps.setLong(1, client.getId());
                ps.setString(2, client.getName());
                ps.executeUpdate();
            } else {
                throw new IllegalArgumentException("You entered an invalid name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client.getId();
    }


    public String getById(long id) {
        String name = "";
        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM client WHERE id = " + id)) {

            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public void setName(long id, String name) {
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?")) {

            ps.setString(1, name);
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM client WHERE id = ?")) {

            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM client")) {
            while (rs.next()) {
                Client client = new Client();
                long id = rs.getLong("id");
                String name = rs.getString("name");
                client.setId(id);
                client.setName(name);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
