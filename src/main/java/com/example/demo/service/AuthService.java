package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repository;

    @Override
    public User register(User user) {

        
        if (repository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already registered");
        }

        
        user.setCreatedAt(LocalDate.now());

        return repository.save(user);
    }

    @Override
    public User login(String email, String password) {

        User user = repository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("Invalid email");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
