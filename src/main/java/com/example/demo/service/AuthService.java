package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;

import java.util.List;

public interface AuthService {
    User register(RegisterRequest req);
    User getById(Long id);
    User findByEmail(String email);
    List<User> listInstructors();
}