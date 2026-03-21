package com.hospital.dbms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.dbms.dao.UserDAO;
import com.hospital.dbms.models.User;

@Service
public class UserService {

    @Autowired
    private UserDAO dao;

    public void addUser(User user) {
        dao.saveUser(user);
    }
    public List<User> getUsers(){
        return dao.getAllUsers();
    }
}