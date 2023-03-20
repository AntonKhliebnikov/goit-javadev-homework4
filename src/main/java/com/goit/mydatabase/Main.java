package com.goit.mydatabase;

import com.goit.mydatabase.service.ClientService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:./dbhw5", "", "").load();
        flyway.migrate();

        ClientService clientService = new ClientService();
        clientService.listAll().forEach(System.out::println);
    }
}
