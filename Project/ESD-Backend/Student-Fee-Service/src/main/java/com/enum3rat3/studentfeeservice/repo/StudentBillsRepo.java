package com.enum3rat3.studentfeeservice.repo;

import com.enum3rat3.studentfeeservice.model.StudentBills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentBillsRepo extends JpaRepository<StudentBills, Integer> {
    @Query(value = "select * from student_bills where student_id = :studentId", nativeQuery = true)
    List<StudentBills> findBystudentId(@Param("studentId") String studentId);

    StudentBills findByBillIdAndStudentId(int billId, String studentId);
}
