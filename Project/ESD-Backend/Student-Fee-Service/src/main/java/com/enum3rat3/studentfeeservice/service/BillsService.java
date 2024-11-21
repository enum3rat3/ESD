package com.enum3rat3.studentfeeservice.service;

import com.enum3rat3.studentfeeservice.model.Bills;
import com.enum3rat3.studentfeeservice.model.Student;
import com.enum3rat3.studentfeeservice.model.StudentBillDetails;
import com.enum3rat3.studentfeeservice.model.StudentBills;
import com.enum3rat3.studentfeeservice.repo.BillsRepo;
import com.enum3rat3.studentfeeservice.repo.StudentBillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillsService {
    @Autowired
    private BillsRepo billsRepo;

    @Autowired
    private StudentBillsService studentBillsService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentBillsRepo studentBillsRepo;

    public void createBill(StudentBillDetails studentBillDetails) {

        Bills bills = new Bills();
        bills.setDescription(studentBillDetails.getDescription());
        bills.setAmount(studentBillDetails.getAmount());
        bills.setBillDate(studentBillDetails.getBillDate());
        bills.setDeadline(studentBillDetails.getDeadline());
        Bills b = billsRepo.save(bills);

        Student s = studentService.getStudentById(studentBillDetails.getStudentID());
        StudentBills studentBills = new StudentBills();
        studentBills.setBillId(b.getId());
        studentBills.setStudentId(s.getStudentId());
        studentBillsService.createStudentBill(studentBills);

        billsRepo.save(bills);
    }

    public List<Bills> readBills(List<Integer> billIDs) {
        return billsRepo.findAllById(billIDs);
    }

    public Bills readBill(Integer billID) {
        return billsRepo.findById(billID).orElse(null);
    }

    public Boolean updateBill(String studentId, int billId, StudentBillDetails studentBillDetails) {
        StudentBills studentBills = studentBillsRepo.findByBillIdAndStudentId(billId, studentId);
        if(studentBills != null)
        {
            Bills bills = readBill(billId);
            bills.setDescription(studentBillDetails.getDescription());
            bills.setAmount(studentBillDetails.getAmount());
            bills.setDeadline(studentBillDetails.getDeadline());
            bills.setBillDate(studentBillDetails.getBillDate());
            billsRepo.save(bills);

            return true;
        }
        return false;
    }

    public boolean deleteBill(String studentId, int billId) {
        StudentBills studentBills = studentBillsRepo.findByBillIdAndStudentId(billId, studentId);
        if(studentBills != null)
        {
            studentBillsRepo.delete(studentBills);
            billsRepo.deleteById(billId);
            return true;
        }
        return false;
    }
}
