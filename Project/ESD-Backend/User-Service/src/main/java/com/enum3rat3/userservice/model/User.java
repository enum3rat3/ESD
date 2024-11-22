package com.enum3rat3.userservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
}