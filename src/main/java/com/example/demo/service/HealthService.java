package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service   // ⭐ FIRST AND MOST IMPORTANT CHANGE
public class HealthService {

    public String getStatus() {
        return "OK";
    }
}
