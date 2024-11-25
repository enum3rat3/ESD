package com.enum3rat3.studentfeeservice.controller;

import com.enum3rat3.studentfeeservice.model.*;
import com.enum3rat3.studentfeeservice.service.BillsService;
import com.enum3rat3.studentfeeservice.service.StudentBillsService;
import com.enum3rat3.studentfeeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/bills")
public class BillsController {
    @Autowired
    private BillsService billsService;

    @Autowired
    private StudentBillsService studentBillsService;

    @Autowired
    private UserService userService;

    @PostMapping("create")
    private String createBill(@RequestBody StudentBillDetails studentBillsDetails, @RequestHeader("Authorization") String jwt) throws Exception{

        if(jwt == null){
            throw new Exception("jwt required...");
        }
        User user = userService.findUserProfileByJwt(jwt);

        if(user == null){
            throw new Exception("UNAUTHORIZED CREDENTIALS");
        }

        billsService.createBill(studentBillsDetails);
        return "Bill created";
    }

    @GetMapping("read/{studentId}")
    private List<Bills> readBills(@PathVariable String studentId, @RequestHeader("Authorization") String jwt) throws Exception{
        if(jwt == null){
            throw new Exception("jwt required...");
        }
        User user = userService.findUserProfileByJwt(jwt);

        if(user == null){
            throw new Exception("UNAUTHORIZED CREDENTIALS");
        }

        List<Integer> billIDs = studentBillsService.readBills(studentId);
        return billsService.readBills(billIDs);
    }

    @PutMapping("update/{studentId}/{billId}")
    private String updateBill(@PathVariable String studentId, @PathVariable int billId, @RequestBody StudentBillDetails studentBillDetails, @RequestHeader("Authorization") String jwt) throws Exception{

        if(jwt == null){
            throw new Exception("jwt required...");
        }
        User user = userService.findUserProfileByJwt(jwt);

        if(user == null){
            throw new Exception("UNAUTHORIZED CREDENTIALS");
        }

        if(billsService.updateBill(studentId, billId, studentBillDetails))
        {
            return "Bill updated for " + studentId;
        }
        return "Bill update failed either invalid " + studentId + " or " + " invalid billId " + billId;
    }

    @DeleteMapping("delete/{studentId}/{billId}")
    private String deleteBill(@PathVariable String studentId, @PathVariable int billId, @RequestHeader("Authorization") String jwt) throws Exception {

        if(jwt == null){
            throw new Exception("jwt required...");
        }
        User user = userService.findUserProfileByJwt(jwt);

        if(user == null){
            throw new Exception("UNAUTHORIZED CREDENTIALS");
        }
        if(billsService.deleteBill(studentId, billId))
        {
            return "Bill details deleted for " + studentId;
        }
        return "Unable to delete bill failed either invalid " + studentId + " or " + " invalid billId " + billId;
    }

    // ********************* Domain Related Operation ******************
    @PostMapping("create/domain/")
    private String createBill(@RequestBody DomainBillDetails domainBillDetails, @RequestHeader("Authorization") String jwt) throws Exception{

        if(jwt == null){
            throw new Exception("jwt required...");
        }
        User user = userService.findUserProfileByJwt(jwt);
        if(user == null){
            throw new Exception("UNAUTHORIZED CREDENTIALS");
        }
        billsService.createBillForDomain(domainBillDetails);
        return "Bill created for " + domainBillDetails.getDomainId();
    }

    @GetMapping("read/domain/{domainId}")
    private List<Bills> readBillsForDomain(@PathVariable int domainId, @RequestHeader("Authorization") String jwt) throws Exception{

        if(jwt == null){
            throw new Exception("jwt required...");
        }
        User user = userService.findUserProfileByJwt(jwt);

        if(user == null){
            throw new Exception("UNAUTHORIZED CREDENTIALS");
        }
        return billsService.readBillsForDomain(domainId);
    }
}