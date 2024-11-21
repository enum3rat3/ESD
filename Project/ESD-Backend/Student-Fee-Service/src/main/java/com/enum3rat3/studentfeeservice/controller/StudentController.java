package com.enum3rat3.studentfeeservice.controller;

import com.enum3rat3.studentfeeservice.model.Student;
import com.enum3rat3.studentfeeservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("all")
    private List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
