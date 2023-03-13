package com.goit.mydatabase;

import com.goit.mydatabase.model.ProjectPrices;
import com.goit.mydatabase.service.DatabaseQueryService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ProjectPrices> projectPrices = new DatabaseQueryService().projectPrices();
        System.out.println(projectPrices);
    }
}
