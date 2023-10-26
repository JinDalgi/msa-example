package com.example.msajoinexample.repository;

import com.example.msajoinexample.entity.User;

import java.util.List;

public interface UserReporitory {

    User getUserByUserId(int userId);
    List<User> getAllUser();
}