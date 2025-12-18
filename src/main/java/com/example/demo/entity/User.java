package com.example.demo.entity;

public class User{
    private Long id;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;
}