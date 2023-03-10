package com.goit.mydatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxProjectCountClient {
    private int clientId;
    private int projectCount;
}
