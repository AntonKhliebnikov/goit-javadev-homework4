package com.goit.mydatabase.entity;

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
