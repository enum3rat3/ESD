package com.enum3rat3.studentfeeservice.repo;

import com.enum3rat3.studentfeeservice.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepo extends JpaRepository<Domain, Integer> {
}
