package com.enum3rat3.studentfeeservice.service;

import com.enum3rat3.studentfeeservice.model.Student;
import com.enum3rat3.studentfeeservice.repo.StudentBillsRepo;
import com.enum3rat3.studentfeeservice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(String studentID) {
        return studentRepo.findById(studentID).get();
    }

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }
}
