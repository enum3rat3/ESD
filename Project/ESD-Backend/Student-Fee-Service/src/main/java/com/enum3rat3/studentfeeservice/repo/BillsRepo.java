package com.enum3rat3.studentfeeservice.repo;

import com.enum3rat3.studentfeeservice.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepo extends JpaRepository<Bills, Integer> {
}
