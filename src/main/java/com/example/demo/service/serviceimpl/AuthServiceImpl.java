package com.example.demo.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.RegisterRequest;
import com.example.demo.service.AuthService;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ==================== REGISTER USER ====================
    @Override
    public User register(RegisterRequest req) {

        // Check if user already exists by email
        Optional<User> existingUser = userRepository.findByEmail(req.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with this email");
        }

        // Create new user
        User user = new User();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        user.setUsername(req.getEmail()); // use email as username for JWT
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRole(req.getRole()); // e.g., "STUDENT" or "ADMIN"

        return userRepository.save(user);
    }

    // ==================== LOGIN USER ====================
    @Override
    public User login(LoginRequest req) {

        // Find user by email
        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Check password
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }
}
