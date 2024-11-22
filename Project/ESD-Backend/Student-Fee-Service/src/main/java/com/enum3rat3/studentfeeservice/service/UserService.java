package com.enum3rat3.studentfeeservice.service;

import com.enum3rat3.studentfeeservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "USER-SERVICE",url = "http://localhost:5001")
public interface UserService {

    @GetMapping("/api/users/profile")
    public User getUserProfileHandler(
            @RequestHeader("Authorization") String jwt);
}