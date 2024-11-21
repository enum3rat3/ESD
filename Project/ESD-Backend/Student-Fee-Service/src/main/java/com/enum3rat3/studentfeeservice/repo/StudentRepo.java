package com.enum3rat3.studentfeeservice.repo;

import com.enum3rat3.studentfeeservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, String> {
}
