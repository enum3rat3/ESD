package com.enum3rat3.studentfeeservice.service;

import com.enum3rat3.studentfeeservice.model.Bills;
import com.enum3rat3.studentfeeservice.model.StudentBills;
import com.enum3rat3.studentfeeservice.repo.StudentBillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentBillsService {
    @Autowired
    private StudentBillsRepo studentBillsRepo;

    public void createStudentBill(StudentBills studentBills) {
        studentBillsRepo.save(studentBills);
    }

    public List<Integer> readBills(String studentId) {
        List<StudentBills> sb = studentBillsRepo.findBystudentId(studentId);

        List<Integer> billIDs = new ArrayList<>();

        for (StudentBills sb1 : sb) {
            billIDs.add(sb1.getBillId());
        }
        return billIDs;
    }
}
