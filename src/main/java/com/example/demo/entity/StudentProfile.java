package com.example.demo.entity;

public class StudentProfile{
    private Long id;
    @Column(unique=true)
    private String entrollmentId;
    private String cohort;
    private Integer yearLevel;
    private Boolean active;
}