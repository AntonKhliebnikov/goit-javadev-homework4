package com.goit.mydatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private int clientId;
    private org.h2.store.Data startDate;
    private org.h2.store.Data finishDate;
}
