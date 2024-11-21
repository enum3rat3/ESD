package com.enum3rat3.studentfeeservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBillDetails {
    private String description;
    private int amount;
    private String billDate;
    private String deadline;
    private String studentID;
}
