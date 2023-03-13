package com.goit.mydatabase.service;

import com.goit.mydatabase.storage.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String queryWorker = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
        String queryClient = "INSERT INTO client (name) VALUES (?)";
        String queryProject = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)";
        String queryProjectWorker = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement psWorker = connection.prepareStatement(queryWorker);
             PreparedStatement psClient = connection.prepareStatement(queryClient);
             PreparedStatement psProject = connection.prepareStatement(queryProject);
             PreparedStatement psProjectWorker = connection.prepareStatement(queryProjectWorker)) {

            psWorker.setString(1, "Anton");
            psWorker.setDate(2, Date.valueOf("1986-02-02"));
            psWorker.setString(3, "Senior");
            psWorker.setInt(4, 4000);
            psWorker.addBatch();

            psWorker.setString(1, "Kris");
            psWorker.setDate(2, Date.valueOf("1996-01-21"));
            psWorker.setString(3, "Middle");
            psWorker.setInt(4, 2500);
            psWorker.addBatch();

            psWorker.setString(1, "Polina");
            psWorker.setDate(2, Date.valueOf("1984-05-18"));
            psWorker.setString(3, "Senior");
            psWorker.setInt(4, 5500);
            psWorker.addBatch();

            psWorker.setString(1, "Anfisa");
            psWorker.setDate(2, Date.valueOf("1984-04-30"));
            psWorker.setString(3, "Senior");
            psWorker.setInt(4, 3000);
            psWorker.addBatch();

            psWorker.setString(1, "Tanya");
            psWorker.setDate(2, Date.valueOf("1989-05-17"));
            psWorker.setString(3, "Junior");
            psWorker.setInt(4, 1100);
            psWorker.addBatch();

            psWorker.setString(1, "Sasha");
            psWorker.setDate(2, Date.valueOf("1999-01-05"));
            psWorker.setString(3, "Junior");
            psWorker.setInt(4, 1100);
            psWorker.addBatch();

            psWorker.setString(1, "Max");
            psWorker.setDate(2, Date.valueOf("1993-06-30"));
            psWorker.setString(3, "Middle");
            psWorker.setInt(4, 2000);
            psWorker.addBatch();

            psWorker.setString(1, "Alyona");
            psWorker.setDate(2, Date.valueOf("1992-05-19"));
            psWorker.setString(3, "Middle");
            psWorker.setInt(4, 1900);
            psWorker.addBatch();

            psWorker.setString(1, "Ivan");
            psWorker.setDate(2, Date.valueOf("2000-06-15"));
            psWorker.setString(3, "Trainee");
            psWorker.setInt(4, 850);
            psWorker.addBatch();

            psWorker.setString(1, "Masha");
            psWorker.setDate(2, Date.valueOf("1989-10-10"));
            psWorker.setString(3, "Trainee");
            psWorker.setInt(4, 850);
            psWorker.addBatch();

            psWorker.executeBatch();


            psClient.setString(1, "Peter Jackson");
            psClient.addBatch();

            psClient.setString(1, "Michelle Williams");
            psClient.addBatch();

            psClient.setString(1, "Ernest Hemingway");
            psClient.addBatch();

            psClient.setString(1, "Paul Atreides");
            psClient.addBatch();

            psClient.setString(1, "Tim Cook");
            psClient.addBatch();

            psClient.executeBatch();


            psProject.setInt(1, 3);
            psProject.setDate(2, Date.valueOf("2022-11-11"));
            psProject.setDate(3, Date.valueOf("2022-12-22"));
            psProject.addBatch();

            psProject.setInt(1, 3);
            psProject.setDate(2, Date.valueOf("2022-01-01"));
            psProject.setDate(3, Date.valueOf("2022-05-31"));
            psProject.addBatch();

            psProject.setInt(1, 3);
            psProject.setDate(2, Date.valueOf("2021-07-25"));
            psProject.setDate(3, Date.valueOf("2022-06-11"));
            psProject.addBatch();

            psProject.setInt(1, 5);
            psProject.setDate(2, Date.valueOf("2020-10-17"));
            psProject.setDate(3, Date.valueOf("2021-05-05"));
            psProject.addBatch();

            psProject.setInt(1, 2);
            psProject.setDate(2, Date.valueOf("2022-02-02"));
            psProject.setDate(3, Date.valueOf("2022-12-12"));
            psProject.addBatch();

            psProject.setInt(1, 2);
            psProject.setDate(2, Date.valueOf("2018-05-09"));
            psProject.setDate(3, Date.valueOf("2025-05-25"));
            psProject.addBatch();

            psProject.setInt(1, 1);
            psProject.setDate(2, Date.valueOf("2022-07-03"));
            psProject.setDate(3, Date.valueOf("2026-09-09"));
            psProject.addBatch();

            psProject.setInt(1, 4);
            psProject.setDate(2, Date.valueOf("2023-02-08"));
            psProject.setDate(3, Date.valueOf("2024-04-09"));
            psProject.addBatch();

            psProject.setInt(1, 4);
            psProject.setDate(2, Date.valueOf("2023-02-02"));
            psProject.setDate(3, Date.valueOf("2024-02-02"));
            psProject.addBatch();

            psProject.setInt(1, 3);
            psProject.setDate(2, Date.valueOf("2019-06-04"));
            psProject.setDate(3, Date.valueOf("2023-06-05"));
            psProject.addBatch();

            psProject.executeBatch();


            psProjectWorker.setInt(1, 1);
            psProjectWorker.setInt(2, 6);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 2);
            psProjectWorker.setInt(2, 9);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 3);
            psProjectWorker.setInt(2, 8);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 4);
            psProjectWorker.setInt(2, 10);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 5);
            psProjectWorker.setInt(2, 2);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 6);
            psProjectWorker.setInt(2, 4);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 7);
            psProjectWorker.setInt(2, 1);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 8);
            psProjectWorker.setInt(2, 5);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 9);
            psProjectWorker.setInt(2, 7);
            psProjectWorker.addBatch();

            psProjectWorker.setInt(1, 10);
            psProjectWorker.setInt(2, 3);
            psProjectWorker.addBatch();

            psProjectWorker.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
