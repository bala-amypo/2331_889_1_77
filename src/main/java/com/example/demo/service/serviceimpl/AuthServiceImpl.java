package com.example.demo.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse register(RegisterRequest request) {
        // dummy logic
        return new AuthResponse(null, "User registered successfully");
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        // dummy logic
        String token = "dummy-jwt-token";
        return new AuthResponse(token, "Login successful");
    }
}
