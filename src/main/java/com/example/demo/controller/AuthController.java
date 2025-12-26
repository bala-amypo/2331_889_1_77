// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.User;
// import com.example.demo.service.AuthService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     @Autowired AuthService authService;

//     @PostMapping("/register")
//     public User register(@RequestBody RegisterRequest request) {
//         return authService.register(request);
//     }

//     @PostMapping("/login")
//     public User login(@RequestBody LoginRequest request) {
//         return authService.login(request);
//     }
// }
