package com.enum3rat3.studentfeeservice.controller;

import com.enum3rat3.studentfeeservice.model.Bills;
import com.enum3rat3.studentfeeservice.service.StudentBillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/read")
public class StudentBillsController {
    @Autowired
    private StudentBillsService studentBillsService;

        @GetMapping("/{studentId}")
    private List<Integer> readBills(@PathVariable String studentId) {
        return studentBillsService.readBills(studentId);
    }
}
