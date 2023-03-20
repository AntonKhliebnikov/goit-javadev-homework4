package com.goit.mydatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private String name;
    private org.h2.store.Data birthday;
    private String level;
    private int salary;
}
