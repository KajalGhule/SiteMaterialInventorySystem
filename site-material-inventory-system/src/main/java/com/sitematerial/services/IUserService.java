package com.sitematerial.services;

import java.util.List;

import com.sitematerial.entities.User;

public interface IUserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Integer id);
    void deleteUser(Integer id);
    User updateuserRole(Integer id, String rolename);
}