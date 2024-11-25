package com.enum3rat3.studentfeeservice.service;

import com.enum3rat3.studentfeeservice.model.User;

import java.util.List;

public interface UserService {
    public User findUserProfileByJwt(String jwt) throws Exception;
    public User findUserByEmail(String email) throws Exception;
    public User findUserById(Long userId) throws Exception;
    public List<User> findAllUsers();
}