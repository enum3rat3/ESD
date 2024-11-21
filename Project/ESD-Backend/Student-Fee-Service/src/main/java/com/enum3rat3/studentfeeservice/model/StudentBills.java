package com.enum3rat3.studentfeeservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_bills")
public class StudentBills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int billId;
    private String studentId;
}
