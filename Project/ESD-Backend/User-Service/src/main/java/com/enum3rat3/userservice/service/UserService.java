package com.enum3rat3.userservice.service;

import com.enum3rat3.userservice.model.User;
import java.util.List;

public interface UserService {
    public User findUserProfileByJwt(String jwt) throws Exception;
    public User findUserByEmail(String email) throws Exception;
    public User findUserById(Long userId) throws Exception;
    public List<User> findAllUsers();
}