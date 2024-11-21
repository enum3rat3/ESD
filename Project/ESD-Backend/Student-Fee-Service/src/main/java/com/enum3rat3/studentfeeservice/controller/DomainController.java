package com.enum3rat3.studentfeeservice.controller;

import com.enum3rat3.studentfeeservice.model.Domain;
import com.enum3rat3.studentfeeservice.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/domain/")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @PostMapping("create")
    public Domain createDomain(@RequestBody Domain domain) {
        return domainService.createDomain(domain);
    }
}
